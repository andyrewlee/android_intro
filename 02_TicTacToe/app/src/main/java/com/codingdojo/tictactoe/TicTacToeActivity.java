package com.codingdojo.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class TicTacToeActivity extends AppCompatActivity {

    private static final String TAG = "TicTacToe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
    }

    public void gameButtonPressed(View button) {
        switch(button.getId()) {
            case R.id.button0:
                Log.d(TAG, "0");
                break;
            case R.id.button1:
                Log.d(TAG, "1");
                break;
            case R.id.button2:
                Log.d(TAG, "2");
                break;
            case R.id.button3:
                Log.d(TAG, "3");
                break;
            case R.id.button4:
                Log.d(TAG, "4");
                break;
            case R.id.button5:
                Log.d(TAG, "5");
                break;
            case R.id.button6:
                Log.d(TAG, "6");
                break;
            case R.id.button7:
                Log.d(TAG, "7");
                break;
            case R.id.button8:
                Log.d(TAG, "8");
                break;
        }

    }
}
