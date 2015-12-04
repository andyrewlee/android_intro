package com.codingdojo.androidquiz;

/**
 * Created by dev1 on 12/4/15.
 */
public class QuestionBank {
    private Question[] questions;
    private int currentQuestionIndex;
    private int currentScore;

    public QuestionBank() {
        currentQuestionIndex = 0;
        currentScore = 0;

        questions = new Question[] {
                new Question("This OS was originally developed as a platform for digital cameras", true),
                new Question("This OS is based on Linux", true),
                new Question("Fragmentation is a big concern on this OS", true),
                new Question("Languages used to build apps for this OS use either Swift or Objective-C", false),
                new Question("This OS is currently naming its versions after desserts", true),
                new Question("Xcode is the name of the IDE used to develop for this OS", false),
                new Question("This OS features a cool animation if user repeatedly clicks the version number in About screen", true),
        };
    }

    public boolean isCurrentQuestionAndroid() {
        return getCurrentQuestion().isAndroid();
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public Question getCurrentQuestion() {
        return questions[currentQuestionIndex];
    }

    public void incorrect() {
        currentScore--;
    }

    public void correct() {
        currentScore++;
    }

    public void nextQuestion() {
        currentQuestionIndex = (currentQuestionIndex + 1) % questions.length;
    }
}
