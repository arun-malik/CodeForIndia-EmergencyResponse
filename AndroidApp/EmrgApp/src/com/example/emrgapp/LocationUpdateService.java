package com.example.emrgapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.TextView;

public class LocationUpdateService extends IntentService {

	private long MIN_TIME_BW_UPDATES = 0l;
	private float MIN_DISTANCE_CHANGE_FOR_UPDATES = 0f;

	public LocationUpdateService(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public LocationUpdateService() {
		super("LocationService");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub

		SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, 0);
		String userID = settings.getString("userID", "");

		LocationManager locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
		// getting GPS status
		boolean isGPSEnabled = locationManager
				.isProviderEnabled(LocationManager.GPS_PROVIDER);

		// getting network status
		boolean isNetworkEnabled = locationManager
				.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

		LocationListener locationListener = new LocationListener() {

			@Override
			public void onLocationChanged(Location location) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStatusChanged(String provider, int status,
					Bundle extras) {
				// TODO Auto-generated method stub

			}
		};

		//syncPreviousLocationData();
		if (!isGPSEnabled && !isNetworkEnabled) {
			// no network coverage case
		} else {
			if (isGPSEnabled) { // if GPS Enabled get lat/long using GPS Services
				locationManager.requestLocationUpdates(
						LocationManager.GPS_PROVIDER,
						MIN_TIME_BW_UPDATES,
						MIN_DISTANCE_CHANGE_FOR_UPDATES,  locationListener );

				String locationProvider = LocationManager.GPS_PROVIDER;
				Location lastKnownLocation = locationManager.getLastKnownLocation(locationProvider);
				Log.v("Location: ",""+lastKnownLocation.getLatitude());
				Log.v("Location: ",""+lastKnownLocation.getLongitude());
				LocationRecord record = new LocationRecord();
				record.setLatitute(lastKnownLocation.getLatitude()+"");
				record.setLongitute(lastKnownLocation.getLongitude()+"");
				record.setAccuracy(lastKnownLocation.getAccuracy()+"");
				record.setAccuracy(SystemClock.currentThreadTimeMillis()+"");
				ArrayList<LocationRecord> listOfRecords = new ArrayList<LocationRecord>();
				listOfRecords.add(record);
				sendLocationToServer(listOfRecords,userID);
			} else if (isNetworkEnabled ) {   

				locationManager.requestLocationUpdates(
						LocationManager.NETWORK_PROVIDER,
						MIN_TIME_BW_UPDATES,
						MIN_DISTANCE_CHANGE_FOR_UPDATES, locationListener);
				String locationProvider = LocationManager.NETWORK_PROVIDER;
				Location lastKnownLocation = locationManager.getLastKnownLocation(locationProvider);

				Log.v("Location: ",""+lastKnownLocation.getLatitude());
				Log.v("Location: ",""+lastKnownLocation.getLongitude());
				LocationRecord record = new LocationRecord();
				record.setLatitute(lastKnownLocation.getLatitude()+"");
				record.setLongitute(lastKnownLocation.getLongitude()+"");
				record.setAccuracy(lastKnownLocation.getAccuracy()+"");
				record.setAccuracy(SystemClock.currentThreadTimeMillis()+"");
				ArrayList<LocationRecord> listOfRecords = new ArrayList<LocationRecord>();
				listOfRecords.add(record);
				sendLocationToServer(listOfRecords,userID);

			}
		}

	}

	private void syncPreviousLocationData() {
		SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, 0);
		String LocationData = settings.getString("LocationData", null);
		if(LocationData != null) {
			String[] records = LocationData.split(";");
			ArrayList<LocationRecord> sendRecords = new ArrayList<LocationRecord>();
			for(int i=0;i< records.length;i++){
				String[] record = records[i].split(":");
				LocationRecord singleRecord = new LocationRecord();
				singleRecord.setLatitute(record[0]);
				singleRecord.setLongitute(record[1]);
				singleRecord.setAccuracy(record[2]);
				singleRecord.setTimestamp(record[3]);
				sendRecords.add(singleRecord);
			}
			String userID = settings.getString("userID", "");
			sendLocationToServer(sendRecords,userID);
		}

	}

	private void sendLocationToServer(ArrayList<LocationRecord> listOfRecords,
			String userId) {

		for(int k=0; k<listOfRecords.size();k++){
			JSONObject json = new JSONObject();
			json.put("userDetailsKey", userId);
			json.put("lat", listOfRecords.get(k).getLatitute());
			json.put("long", listOfRecords.get(k).getLongitute());
			json.put("accuracyRadius", listOfRecords.get(k).getAccuracy());
			json.put("modifiedDateTime", listOfRecords.get(k).getTimestamp());
			try {
				Log.v("Json",json.toString());
				uploadLocation(json.toString());
			} catch(Exception e){
				// database add fails
				SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, 0);
				String LocationData = settings.getString("LocationData", null);
				SharedPreferences.Editor editor = settings.edit();
				String record = "";
				if(LocationData == null) {


					for(int i=0;i<listOfRecords.size();i++){
						record = record +listOfRecords.get(i).getLatitute()
								+":"+listOfRecords.get(i).getLongitute()+":"+listOfRecords.get(i).getAccuracy()
								+":"+listOfRecords.get(i).getTimestamp()+";";
					}
				} else {
					record = LocationData;
					for(int i=0;i<listOfRecords.size();i++){
						record = record +listOfRecords.get(i).getLatitute()
								+":"+listOfRecords.get(i).getLongitute()+":"+listOfRecords.get(i).getAccuracy()
								+":"+listOfRecords.get(i).getTimestamp()+";";
					}
				}
				editor.putString("LocationData",record);
				try {
					editor.commit();
				} catch(Exception ex) {
					ex.printStackTrace();
				}
			}

		}


	}

	public void uploadLocation(String param) throws Exception{


		String record = param;

		HttpClient httpClientObject = new DefaultHttpClient();
		HttpPost httpPostCall = new HttpPost("http://54.215.202.235:8000/checkIn");

		httpPostCall.setEntity(new StringEntity(record, "UTF8"));
		httpPostCall.setHeader("Content-type", "application/json");

		HttpEntity httpEntityObject = httpClientObject.execute(httpPostCall).getEntity();

		if (httpEntityObject != null) {

			InputStream inputStreamObject = httpEntityObject.getContent();
			Reader readerObject = new InputStreamReader(inputStreamObject);
			BufferedReader bufferedReaderObject = new BufferedReader(readerObject);

			StringBuilder jsonResultStringBuilder = new StringBuilder();
			String readLine = null;

			while ((readLine = bufferedReaderObject.readLine()) != null) {
				jsonResultStringBuilder.append(readLine + "\n");
			}
			
			Log.v("Response",jsonResultStringBuilder.toString());

		}

	}

}
