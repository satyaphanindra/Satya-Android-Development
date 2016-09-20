package com.assignment.quizapp;

import com.example.quizapp.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity {

	TextView resultView;
	Button startOver;
	Button quit;

	String resultString;
	String stringValue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_result);

		resultView = (TextView) findViewById(R.id.textView1);
		startOver = (Button) findViewById(R.id.button1);
		quit = (Button) findViewById(R.id.button2);

		Bundle dataFromIntent = getIntent().getExtras();
		if (dataFromIntent != null) {

			 stringValue = dataFromIntent.getString("result");

		}

    switch (Integer.valueOf(stringValue)) {

		case 3:
			resultString = "Good job!";
			break;

		case 4:
			resultString = "Excellent work!";
			break;

		case 5:
			resultString = "You are a genius!";
			break;

		default:
			resultString = "Please try again!";
			break;
	 }
    
	resultView.setText(resultView.getText() + stringValue+"/5 : "+resultString);


		quit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				startActivity(intent);


			}
		});
		
		startOver.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(ResultActivity.this, TestActivity.class);
				startActivity(intent);
				
			}
		});

	}

}
