package com.andyrewlee.ninjagold;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NinjaGoldActivity extends AppCompatActivity {
    private TextView totalGoldTextView;
    private TextView recentActivityTextView;
    private NinjaGoldGame ninjaGoldGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninja_gold);

        totalGoldTextView = (TextView) findViewById(R.id.total_gold_text_view);
        recentActivityTextView = (TextView) findViewById(R.id.recent_activity_text_view);
        ninjaGoldGame = new NinjaGoldGame();
    }

    public void gameButtonPressed(View sender) {
        Button pressedButton = (Button) sender;
        String result = ninjaGoldGame.gameTurnWith(pressedButton.getText().toString());
        String totalGold = ninjaGoldGame.getCurrentTotalGold();

        recentActivityTextView.setText(result);
        totalGoldTextView.setText(totalGold);
    }
}
