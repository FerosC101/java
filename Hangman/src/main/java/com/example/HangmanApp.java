package com.example;

import java.util.Scanner;

public class HangmanApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hangman");

        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        int choice = scanner.nextInt();
        scanner.nextLine();

        User user = new User();
        boolean login = false;

        if (choice == 1) {
            System.out.print("Please enter your username: ");
            String username = scanner.nextLine();
            System.out.print("Please enter your password: ");
            String password = scanner.nextLine();
            login = user.register(username, password);
        } else if (choice == 2) {
            System.out.print("Please enter your password: ");
            String username = scanner.nextLine();
            System.out.print("Please enter your password: ");
            String password = scanner.nextLine();
            login = user.login(username, password);
        } else if (choice == 3) {
            System.exit(0);
        }

        WordGuessoingGame game = null;
        if (login) {
            System.out.println("Select difficulty: \n1.Easy\n2.Medium\n3.Hard");
            int level = scanner.nextInt();
            game = switch (level) {
                case 1 -> new EasyLevel();
                case 2 -> new MediumLevel();
                case 3 -> new HardLevel();
                default -> {
                    System.out.println("Invalid level, setting to easy");
                    yield new EasyLevel();
                }
            };
        }
        assert game != null;
        game.initializeGame();

        while (game.attemptsLeft > 0 && !game.checkWin()) {
            System.out.print("Please enter Letter: ");
            char letter = scanner.next().charAt(0);
            game.guessLetter(letter);
        }
        if (game.checkWin()) {
            System.out.println("You won!");
        } else {
            System.out.println("You lost!, your word was: " + game.word);
        }
    }
}
