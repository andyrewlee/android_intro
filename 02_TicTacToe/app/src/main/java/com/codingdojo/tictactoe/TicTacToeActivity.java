package com.codingdojo.tictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TicTacToeActivity extends AppCompatActivity {

    private static final String TAG = "TicTacToeActivity";
    private TicTacToeGame tictactoe;
    private TextView declareWinnerTextView;
    private Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        declareWinnerTextView = (TextView) findViewById(R.id.declareWinner);
        resetButton = (Button) findViewById(R.id.reset);
        tictactoe = new TicTacToeGame();

        updateUI();

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tictactoe.resetGame();
                updateUI();
            }
        });
    }

    private void updateUI() {
        int[] gameBoard = tictactoe.getGameBoard();
        for(int i = 0; i < gameBoard.length; i++) {
            Button button = (Button) findViewById(R.id.gameboard).findViewWithTag("" + i);
            if(gameBoard[i] == 1) {
                button.setBackgroundColor(Color.RED);
            } else if(gameBoard[i] == 2) {
                button.setBackgroundColor(Color.BLUE);
            } else {
                button.setBackgroundColor(Color.LTGRAY);
            }
        }
        if(tictactoe.getWinner() != "") {
            declareWinnerTextView.setText(tictactoe.getWinner() + " wins");
        } else {
            declareWinnerTextView.setText("");
        }
    }

    public void gameButtonPressed(View button) {
        String tag = button.getTag().toString();
        int boardIndex = Integer.parseInt(tag);
        tictactoe.updateGameBoardAt(boardIndex, tictactoe.getCurrentTurn());
        tictactoe.checkGame();
        updateUI();
    }
}
