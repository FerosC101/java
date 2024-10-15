package com.example;

public class HardLevel extends WordGuessoingGame{
    @Override
    public void initializeGame() {
        this.word = Database.getWord("Hard");
        this.progress = new StringBuilder("_".repeat(word.length()));
        this.maxAttempts = 4;
        this.attemptsLeft = maxAttempts;
    }
}
