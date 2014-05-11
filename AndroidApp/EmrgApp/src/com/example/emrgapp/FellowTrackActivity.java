package com.example.emrgapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class FellowTrackActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fellow_layout);
    }
    
    public void checkInFellowProfile(View view){
    	Toast.makeText(view.getContext(), "Checked-In", Toast.LENGTH_LONG).show();
    }
    
}
