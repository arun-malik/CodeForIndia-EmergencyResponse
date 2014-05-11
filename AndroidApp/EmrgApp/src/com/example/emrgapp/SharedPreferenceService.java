package com.example.emrgapp;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;

public class SharedPreferenceService extends IntentService{

	public SharedPreferenceService(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public SharedPreferenceService() {
		super("SharedPreferenceService");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		new SaveInPreference().execute(intent.getStringExtra("key"),
				intent.getStringExtra("value"));
	}

	private class SaveInPreference extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... str) {
			SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, 0);
			SharedPreferences.Editor editor = settings.edit();
			editor.putString(str[0], str[1]);
			try {
				editor.commit();
				return str[0]+","+str[1];
			} catch(Exception e) {
				e.printStackTrace();
				return "Error";
			}
			
		}


		@Override
		protected void onPostExecute(String result) {
			
		}
	}
}
