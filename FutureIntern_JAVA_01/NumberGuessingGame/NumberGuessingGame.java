package NumberGuessingGame;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(100) + 1;
        int guess;

        System.out.println("Welcome to the Guessing Game!");

        do {
            System.out.print("Guess a number between 1 and 100: ");
            guess = scanner.nextInt();

            if (guess < numberToGuess) {
                System.out.println("Your guess is too low.");
            } else if (guess > numberToGuess) {
                System.out.println("Your guess is too high.");
            } else {
                System.out.println("Congratulations! You guessed the number.");
            }
        } while (guess != numberToGuess);

        scanner.close();
    }
}