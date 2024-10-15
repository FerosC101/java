package com.example;

public class MediumLevel extends WordGuessoingGame{
    @Override
    public void initializeGame() {
        this.word = Database.getWord("Medium");
        this.progress = new StringBuilder("_".repeat(word.length()));
        this.maxAttempts = 5;
        this.attemptsLeft = maxAttempts;
    }
}
