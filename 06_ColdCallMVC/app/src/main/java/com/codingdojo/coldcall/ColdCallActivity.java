package com.codingdojo.coldcall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ColdCallActivity extends AppCompatActivity {
    private Button coldCallButton;
    private TextView coldCalledTextView;
    private StudentsFactory studentsFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cold_call);
        coldCallButton = (Button) findViewById(R.id.cold_call_button);
        coldCalledTextView = (TextView) findViewById(R.id.cold_called_student_button);

        studentsFactory = new StudentsFactory();
        coldCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coldCalledTextView.setText(studentsFactory.findRandomStudentName());
            }
        });
    }
}
