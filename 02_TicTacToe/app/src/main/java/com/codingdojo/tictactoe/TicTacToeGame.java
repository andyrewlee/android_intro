package com.codingdojo.tictactoe;

import android.util.Log;

public class TicTacToeGame {
    private int[] gameBoard;
    private boolean gameOver;
    private String winner;
    private String currentTurn;

    public TicTacToeGame() {
        gameBoard = new int[9];
        gameOver = false;
        winner = "";
        currentTurn = "Red";
    }

    public int[] getGameBoard() {
        return gameBoard;
    }

    public String getCurrentTurn() {
        return currentTurn;
    }

    public String getWinner() {
        return winner;
    }

    public void updateGameBoardAt(int index, String color) {
        if(color == "Red") {
            if(gameBoard[index] == 0) {
                gameBoard[index] = 1;
                currentTurn = "Blue";
            }
        } else {
            if(gameBoard[index] == 0) {
                gameBoard[index] = 2;
                currentTurn = "Red";
            }
        }
    }

    public void resetGame() {
        winner = "";
        gameBoard = new int[9];
        gameOver = false;
    }

    public void checkGame() {
        checkRows();
        checkColumns();
        checkDiagonals();
    }

    private void checkRows() {
        for(int i = 0; i <= 6; i += 3) {
            if(gameBoard[i] != 0
                    && (gameBoard[i] == gameBoard[i + 1] && gameBoard[i + 1] == gameBoard[i + 2])) {
                declareWinner(gameBoard[i]);
            }
        }
    }

    private void checkColumns() {
        for(int i = 0; i <= 2; i++) {
            if(gameBoard[i] != 0
                    && (gameBoard[i] == gameBoard[i + 3] && gameBoard[i + 3] == gameBoard[i + 6])) {
                declareWinner(gameBoard[i]);
            }
        }
    }

    private void checkDiagonals() {
        if(gameBoard[4] != 0 && (leftDiagonal() || rightDiagonal())) {
            declareWinner(gameBoard[4]);
        }
    }

    private boolean leftDiagonal() {
        return gameBoard[0] == gameBoard[4] && gameBoard[4] == gameBoard[8];
    }

    private boolean rightDiagonal() {
        return gameBoard[2] == gameBoard[4] && gameBoard[4] == gameBoard[6];
    }

    private void declareWinner(int winningIndex) {
        gameOver = true;
        if(winningIndex == 1) {
            winner = "Red";
        } else {
            winner = "Blue";
        }
    }
}
