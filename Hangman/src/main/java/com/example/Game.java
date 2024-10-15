package com.example;

public abstract class Game {
    protected String word;
    protected StringBuilder progress;
    protected int attemptsLeft; //dpends on level
    protected int maxAttempts;

    public abstract void intializeGame();
    public abstract void guessLetter(char letter);
    public boolean checkWin() {
        return progress.toString().equals(word); // appends to sql(word) then check if correct
    }

    public void displayProgress() {
        System.out.println("Current progress: " + progress.toString());
    }
}
