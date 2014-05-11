package com.example.emrgapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class GPSLocationBroadcastReceiver extends BroadcastReceiver {

	//private long MIN_TIME_BW_UPDATES = 0l;
	//private float MIN_DISTANCE_CHANGE_FOR_UPDATES = 0f;
	public void onReceive(Context context, Intent intent) {
		
		Intent locationServiceIntent = new Intent(context, LocationUpdateService.class); 
		context.startService(locationServiceIntent);
		// call location service and get latitude, long and accuracy
		// push any previous pending locations
		// get user id if in shared preference or get mobile number
		// call database to update. If fails store in local storage
		// else send to db
		// save userid returned on success
		/*LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
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
		if (!isGPSEnabled && !isNetworkEnabled) {
			// no network provider is enabled
		} else {
			//context.canGetLocation = true;
			if (isGPSEnabled) { // if GPS Enabled get lat/long using GPS Services
				locationManager.requestLocationUpdates(
						LocationManager.GPS_PROVIDER,
						MIN_TIME_BW_UPDATES,
						MIN_DISTANCE_CHANGE_FOR_UPDATES,  locationListener );
				
				String locationProvider = LocationManager.GPS_PROVIDER;
				Location lastKnownLocation = locationManager.getLastKnownLocation(locationProvider);
				Log.v("Location: ",""+lastKnownLocation.getLatitude());
				Log.v("Location: ",""+lastKnownLocation.getLongitude());
			} else if (isNetworkEnabled ) {   

				locationManager.requestLocationUpdates(
						LocationManager.NETWORK_PROVIDER,
						MIN_TIME_BW_UPDATES,
						MIN_DISTANCE_CHANGE_FOR_UPDATES, locationListener);
				String locationProvider = LocationManager.NETWORK_PROVIDER;
				Location lastKnownLocation = locationManager.getLastKnownLocation(locationProvider);
				
				Log.v("Location: ",""+lastKnownLocation.getLatitude());
				Log.v("Location: ",""+lastKnownLocation.getLongitude());
				
			}
		}*/

	}
}

