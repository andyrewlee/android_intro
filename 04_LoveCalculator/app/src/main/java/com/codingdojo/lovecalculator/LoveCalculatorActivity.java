package com.codingdojo.lovecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoveCalculatorActivity extends AppCompatActivity {

    private Button calculateButton;
    private EditText loverOneEditText;
    private EditText loverTwoEditText;
    private TextView percentageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love_calculator);

        calculateButton = (Button) findViewById(R.id.calculateButton);
        loverOneEditText = (EditText) findViewById(R.id.loverOneEditText);
        loverTwoEditText = (EditText) findViewById(R.id.loverTwoEditText);
        percentageTextView = (TextView) findViewById(R.id.percentageTextView);

        percentageTextView.setText("");

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loverOne = loverOneEditText.getText().toString();
                String loverTwo = loverTwoEditText.getText().toString();
                int percentage = LoveCalculator.calculate(loverOne, loverTwo);

                percentageTextView.setText("" + percentage + "%");
            }
        });
    }
}
