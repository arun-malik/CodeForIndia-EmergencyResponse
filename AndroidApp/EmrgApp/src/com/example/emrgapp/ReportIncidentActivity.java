package com.example.emrgapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ReportIncidentActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_layout);
    }
    
    public void reportEmergency(View view){
    	Toast.makeText(view.getContext(), "Emergency Reported", Toast.LENGTH_LONG).show();
    }
}
