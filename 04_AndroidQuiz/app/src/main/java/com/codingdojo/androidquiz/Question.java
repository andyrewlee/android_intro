package com.codingdojo.androidquiz;

/**
 * Created by dev1 on 11/12/15.
 */
public class Question {
    private String question;
    private boolean isAndroid;

    public Question(String question, boolean isAndroid) {
        this.question = question;
        this.isAndroid = isAndroid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isAndroid() {
        return isAndroid;
    }

    public void setIsAndroid(boolean isAndroid) {
        this.isAndroid = isAndroid;
    }
}
