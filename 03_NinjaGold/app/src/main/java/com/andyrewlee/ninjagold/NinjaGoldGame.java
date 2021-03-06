package com.andyrewlee.ninjagold;

import android.util.Log;

import java.util.Random;

/**
 * Created by dev1 on 12/4/15.
 */
public class NinjaGoldGame {
    private int totalGold;

    public NinjaGoldGame() {
        this.totalGold = 0;
    }

    public String gameTurnWith(String choice) {
        int gold;

        if(choice.equals("Farm")) {
            // farm earns 10 - 20 golds
            gold = new Random().nextInt(11) + 10;
        } else if (choice.equals("Cave")) {
            // cave earns 5 - 10 golds
            gold = new Random().nextInt(6) + 5;
        } else if (choice.equals("House")) {
            // house earns 2 - 5 golds
            gold = new Random().nextInt(4) + 2;
        } else if (choice.equals("Casino")) {
            // casino earns/takes 0 - 50 golds
            int coinFlip = new Random().nextInt(2);
            gold = new Random().nextInt(50);

            if(coinFlip == 0) {
                gold *= -1;
            }
        } else {
            gold = 0;
        }

        String result;

        if(gold > 0) {
            result = "You chose " + choice + " and earned " + gold;
        } else if(gold < 0) {
            result = "You chose " + choice + " and lost " + gold;
        } else {
            result = "You chose " + choice + " and didn't earn anything";
        }

        totalGold += gold;
        return result;
    }

    public String getCurrentTotalGold() {
        return "" + totalGold;
    }
}
