package com.example;

public class EasyLevel extends  WordGuessoingGame{
    @Override
    public void initializeGame() {
        this.word = Database.getWord("Easy");
        this.progress = new StringBuilder("_".repeat(word.length()));
        this.maxAttempts = 6;
        this.attemptsLeft = maxAttempts;
    }
}
