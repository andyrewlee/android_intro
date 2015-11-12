package com.codingdojo.lovecalculator;

public class LoveCalculator {
    public static int calculate(String loverOne, String loverTwo) {
        int randomNumber = loverOne.length() * loverTwo.length() * 99;
        return randomNumber % 100;
    }
}
