package com.example;

public abstract class WordGuessoingGame extends Game{
    private String[] hangmanStages;
    private int currentStage;

    public void WordGuessingGame() {
        this.hangmanStages = new String[] {
                " -----\n" +
                        " |   |\n" +
                        "     |\n" +
                        "     |\n" +
                        "     |\n" +
                        "     |\n" +
                        "---------",

                " -----\n" +
                        " |   |\n" +
                        " O   |\n" +
                        "     |\n" +
                        "     |\n" +
                        "     |\n" +
                        "---------",

                " -----\n" +
                        " |   |\n" +
                        " O   |\n" +
                        " |   |\n" +
                        "     |\n" +
                        "     |\n" +
                        "---------",

                " -----\n" +
                        " |   |\n" +
                        " O   |\n" +
                        " /|  |\n" +
                        "     |\n" +
                        "     |\n" +
                        "---------",

                " -----\n" +
                        " |   |\n" +
                        " O   |\n" +
                        " /|\\ |\n" +
                        "     |\n" +
                        "     |\n" +
                        "---------",

                " -----\n" +
                        " |   |\n" +
                        " O   |\n" +
                        " /|\\ |\n" +
                        " /   |\n" +
                        "     |\n" +
                        "---------",

                " -----\n" +
                        " |   |\n" +
                        " O   |\n" +
                        " /|\\ |\n" +
                        " / \\ |\n" +
                        "     |\n" +
                        "---------"
        };
        this.currentStage = 0;
    }

    @Override
    public void intializeGame() {
        //get words from DB
        this.word = Database.getWord("Easy");
        this.progress = new StringBuilder("_".repeat(word.length()));
        this.maxAttempts = 6;
        this.attemptsLeft = maxAttempts;
    }

    @Override
    public void guessLetter(char letter) {
        boolean found = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                progress.setCharAt(i, letter);
                found = true;
            }
        }

        if (!found) {
            attemptsLeft--;
            currentStage++;
        }
        displayHangman();
    }

    public void displayHangman() {
        System.out.println(hangmanStages[currentStage]);
        displayProgress();
    }

    public abstract void initializeGame();
}
