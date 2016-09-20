package com.assignment.quizapp;

import java.util.List;

import com.example.quizapp.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends Activity {

	TextView question;

	RadioGroup radioGroup;
	RadioButton radioButton1;
	RadioButton radioButton2;
	RadioButton radioButton3;
	RadioButton radioButton4;

	Button button;

	List<Question> questionList;
	int count;

	String correctAnswer;
	String selectedAnswer;
	
	int result;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);

		initiateViews();

		Random random = new Random();
		questionList = random.getQuestionList();

		question.setText(questionList.get(count).getQuestion());

		radioButton1.setText(questionList.get(count).getOptions().get(0));
		radioButton2.setText(questionList.get(count).getOptions().get(1));
		radioButton3.setText(questionList.get(count).getOptions().get(2));
		radioButton4.setText(questionList.get(count).getOptions().get(3));
		correctAnswer = questionList.get(count).getCorrectAnswer();

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {


				if (radioGroup.getCheckedRadioButtonId() == -1) {
					Toast.makeText(getApplicationContext(),
							"Please select your answer", Toast.LENGTH_SHORT)
							.show();

				} else {


					if (selectedAnswer.equals(correctAnswer)) {

						result++;

					} 

					
					if (count < 4) {

						count++;

						question.setText(questionList.get(count).getQuestion());

						radioButton1.setText(questionList.get(count)
								.getOptions().get(0));
						radioButton2.setText(questionList.get(count)
								.getOptions().get(1));
						radioButton3.setText(questionList.get(count)
								.getOptions().get(2));
						radioButton4.setText(questionList.get(count)
								.getOptions().get(3));
						correctAnswer = questionList.get(count)
								.getCorrectAnswer();

					}else if(count == 4){
						
						Intent intent = new Intent(TestActivity.this, ResultActivity.class);
						Bundle bundle = new Bundle();
						bundle.putString("result", String.valueOf(result));
						intent.putExtras(bundle);
						
						startActivity(intent);

					}

				}

				radioGroup.clearCheck();
			}
		});

		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				switch (checkedId) {

				case -1:
					break;

				case R.id.radioButton1:
					selectedAnswer = radioButton1.getText().toString();

					break;

				case R.id.radioButton2:
					selectedAnswer = radioButton2.getText().toString();
					break;

				case R.id.radioButton3:
					selectedAnswer = radioButton3.getText().toString();
					break;

				case R.id.radioButton4:
					selectedAnswer = radioButton4.getText().toString();
					break;

				default:
					break;
				}

			}
		});

	}

	private void initiateViews() {

		question = (TextView) findViewById(R.id.textView1);

		radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
		radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
		radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
		radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
		radioButton4 = (RadioButton) findViewById(R.id.radioButton4);

		button = (Button) findViewById(R.id.button1);

	}
}
