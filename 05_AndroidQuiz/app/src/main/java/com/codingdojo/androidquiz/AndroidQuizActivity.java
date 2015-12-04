package com.codingdojo.androidquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AndroidQuizActivity extends AppCompatActivity {

    public static final String TAG = "AndroidQuizActivity";

    private Button androidButton;
    private Button iosButton;
    private Button nextButton;

    private TextView questionTextView;
    private TextView scoreTextView;

    private QuestionBank questionBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_quiz);

        androidButton = (Button) findViewById(R.id.android_button);
        iosButton = (Button) findViewById(R.id.ios_button);
        nextButton = (Button) findViewById(R.id.next_button);

        questionTextView = (TextView) findViewById(R.id.question_text_view);
        scoreTextView = (TextView) findViewById(R.id.score_text_view);

        questionBank = new QuestionBank();

        androidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionBank.isCurrentQuestionAndroid()) {
                    Log.d(TAG, "Correct");
                    questionBank.correct();
                } else {
                    Log.d(TAG, "Incorrect");
                    questionBank.incorrect();
                }
                updateUI();
            }
        });

        iosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionBank.isCurrentQuestionAndroid()) {
                    Log.d(TAG, "Incorrect");
                    questionBank.incorrect();
                } else {
                    Log.d(TAG, "Correct");
                    questionBank.correct();
                }
                updateUI();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUI();
            }
        });

        updateUI();
    }

    private void updateUI() {
        questionBank.nextQuestion();
        questionTextView.setText(questionBank.getCurrentQuestion().getQuestion());
        scoreTextView.setText("" + questionBank.getCurrentScore());
    }
}
