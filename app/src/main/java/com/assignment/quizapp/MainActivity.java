package com.assignment.quizapp;

import com.example.quizapp.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	Button nextViewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiateViews();
        
        nextViewButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainActivity.this, TestActivity.class);
				startActivity(intent);
			}
		});
    }

	private void initiateViews() {
		
		nextViewButton = (Button) findViewById(R.id.button1);
		
	}
    
    
    
}
