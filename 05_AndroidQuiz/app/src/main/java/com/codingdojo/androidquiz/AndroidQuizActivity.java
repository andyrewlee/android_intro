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

    private int currentQuestionIndex = 0;
    private int score = 0;

    private Question[] questions = new Question[] {
            new Question("This OS was originally developed as a platform for digital cameras", true),
            new Question("This OS is based on Linux", true),
            new Question("Fragmentation is a big concern on this OS", true),
            new Question("Languages used to build apps for this OS use either Swift or Objective-C", false),
            new Question("This OS is currently naming its versions after desserts", true),
            new Question("Xcode is the name of the IDE used to develop for this OS", false),
            new Question("This OS features a cool animation if user repeatedly clicks the version number in About screen", true),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_quiz);

        androidButton = (Button) findViewById(R.id.android_button);
        iosButton = (Button) findViewById(R.id.ios_button);
        nextButton = (Button) findViewById(R.id.next_button);

        questionTextView = (TextView) findViewById(R.id.question_text_view);
        scoreTextView = (TextView) findViewById(R.id.score_text_view);

        androidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questions[currentQuestionIndex].isAndroid()) {
                    Log.d(TAG, "Correct");
                    score++;
                } else {
                    Log.d(TAG, "Incorrect");
                    score--;
                }
                updateUI();
            }
        });

        iosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questions[currentQuestionIndex].isAndroid()) {
                    Log.d(TAG, "Incorrect");
                    score--;
                } else {
                    Log.d(TAG, "Correct");
                    score++;
                }
                updateUI();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuestionIndex = (currentQuestionIndex + 1) % questions.length;
                updateUI();
            }
        });

        updateUI();
    }

    private void updateUI() {
        questionTextView.setText(questions[currentQuestionIndex].getQuestion());
        scoreTextView.setText("" + score);
    }
}
