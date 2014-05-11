package com.example.emrgapp;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class TrackingActivity extends Activity {

	AlarmManager alarmManager;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.track_layout);
		alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
		SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, 0);
		ToggleButton buttonLED = (ToggleButton) findViewById(R.id.ToggleButton01);
		buttonLED.setChecked(false);
		int toggle = settings.getInt("trackAuto", 0);
		if(toggle == 1) {
			buttonLED.setChecked(true);
		}
	}

	public void checkInCurrentLocation(View view){
		Intent locationServiceIntent = new Intent(getApplicationContext(), LocationUpdateService.class); 
		getApplicationContext().startService(locationServiceIntent);
		Toast.makeText(view.getContext(), "Checked-In", Toast.LENGTH_LONG).show();
	}

	public void onToggle(View view){
		ToggleButton buttonLED = (ToggleButton) findViewById(R.id.ToggleButton01);
		SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();

		if(buttonLED.isChecked()) {

			Intent GPSLocationTrackerService = new Intent(getApplicationContext(), GPSLocationBroadcastReceiver.class);
			PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 1 , GPSLocationTrackerService, 0);
			Calendar calendar = Calendar.getInstance();       
			calendar.setTimeInMillis(SystemClock.currentThreadTimeMillis());
			calendar.add(Calendar.SECOND, 10);
			int updateFreq = 1000 * 60 * 2;
			alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), updateFreq, pendingIntent);
			editor.putInt("trackAuto", 1);
			try {
				editor.commit();
				Toast.makeText(view.getContext(), "Tracking On", Toast.LENGTH_LONG).show();
			} catch(Exception e) {
				e.printStackTrace();
			}

		} else {

			PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 1 , new Intent(getApplicationContext(), GPSLocationBroadcastReceiver.class), 0);
			alarmManager.cancel(pendingIntent);

			editor.putInt("trackAuto", 0);
			try {
				editor.commit();
				Toast.makeText(view.getContext(), "Tracking Off", Toast.LENGTH_LONG).show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
}


