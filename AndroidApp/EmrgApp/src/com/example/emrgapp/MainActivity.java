package com.example.emrgapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

	public static final String PREFS_NAME = "emergencyAppData";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TabHost tabHost = getTabHost();

		TextView txtView = (TextView)findViewById(R.id.userID);
		txtView.setVisibility(View.GONE);

		// Tab for Tracking
		TabSpec trackSpec = tabHost.newTabSpec("Track");
		// setting Title and Icon for the Tab
		trackSpec.setIndicator("Track", getResources().getDrawable(R.drawable.icon_track_tab));
		Intent trackIntent = new Intent(this, TrackingActivity.class);
		trackSpec.setContent(trackIntent);

		// Tab for Profile
		TabSpec profileSpec = tabHost.newTabSpec("My Profile");        
		profileSpec.setIndicator("My Profile", getResources().getDrawable(R.drawable.icon_profile_tab));
		Intent profileIntent = new Intent(this, ProfileInfoActivity.class);
		profileSpec.setContent(profileIntent);

		// Tab for Reporting
		TabSpec reportSpec = tabHost.newTabSpec("Report");
		reportSpec.setIndicator("Report", getResources().getDrawable(R.drawable.icon_report_tab));
		Intent reportIntent = new Intent(this, ReportIncidentActivity.class);
		reportSpec.setContent(reportIntent);

		// Tab for Reporting
		TabSpec fellowSpec = tabHost.newTabSpec("Fellow Info");
		fellowSpec.setIndicator("Fellow Info", getResources().getDrawable(R.drawable.icon_fellow_tab));
		Intent fellowIntent = new Intent(this, FellowTrackActivity.class);
		fellowSpec.setContent(fellowIntent);

		// Adding all TabSpec to TabHost
		tabHost.addTab(trackSpec); 
		tabHost.addTab(profileSpec);
		tabHost.addTab(reportSpec);
		tabHost.addTab(fellowSpec);

		//get userID
		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		txtView.setText(settings.getString("userID", ""));

		if(txtView.getText().toString().isEmpty()) {

			String phNo= getPhoneNumber();
			Log.v("Phone Number",phNo);
			if(phNo==null){
				AlertDialog alertDialog = new AlertDialog.Builder(this).create();
				alertDialog.setTitle("Cannot get phone number");
				alertDialog.setMessage("Cannot get phone number. Please set phone number in settings.");
				alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
					}
				});
				alertDialog.show();

			} else {
				try {
					new uploadUserData().execute(phNo);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}


	}

	class uploadUserData extends AsyncTask<String, Void, String> {

		protected String doInBackground(String... params) {

			String phoneNo = params[0];

			HttpClient httpClientObject = new DefaultHttpClient();
			HttpPost httpPostCall = new HttpPost("http://54.215.202.235:8000/users");

			JSONObject json = new JSONObject();
			json.put("mobileNumber", phoneNo);

			try {
				httpPostCall.setEntity(new StringEntity(json.toString(), "UTF8"));
				httpPostCall.setHeader("Content-type", "application/json");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {

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

					return jsonResultStringBuilder.toString();
				}

			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return null;
		}

		protected void onPostExecute(String response) {

			try {
				JSONObject json = (JSONObject)new JSONParser().parse(response);
				TextView saveUserID = (TextView) findViewById(R.id.userID);
				Log.v("userID",json.get("userDetailsKey").toString());
				saveUserID.setText(json.get("userDetailsKey").toString());
				SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, 0);
				SharedPreferences.Editor editor = settings.edit();
				editor.putString("userID",json.get("userDetailsKey").toString());
				try {
					editor.commit();
				} catch(Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



		}
	}

	public String getPhoneNumber(){

		TelephonyManager tMgr = (TelephonyManager)getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
		String phoneNumber = tMgr.getLine1Number();

		if(phoneNumber != null) {
			return phoneNumber;
		}
		AccountManager am = AccountManager.get(this);
		Account[] accounts = am.getAccounts();
		try {
			for (Account ac : accounts) {
				String actype = ac.type;
				if(actype.equals("com.whatsapp")){
					return ac.name;
				}
			}
		}catch(Exception e){
			Log.v("Exception while getting phone number from watsapp: ", "");
		}
		return null;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
