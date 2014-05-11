package com.example.emrgapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ProfileInfoActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);
    }
    
    public void saveMyProfile(View view){
    	Toast.makeText(view.getContext(), "Saved", Toast.LENGTH_LONG).show();
    }
}
