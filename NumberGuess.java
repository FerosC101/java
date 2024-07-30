import java.util.Random;
import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int numberOfTries = 0;
        int guess;
        boolean isCorrect = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess the number between 1 and 100");

        while (!isCorrect) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            numberOfTries++;

            if (guess < numberToGuess) {
                System.out.println("Too low.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high.");
            } else {
                isCorrect = true;
                System.out.println("Congratulations! You've guessed the right number.");
                System.out.println("It took you " + numberOfTries + " tries.");
            }
        }

        scanner.close();
    }
}
