package RockpaperScissor;

import java.util.Scanner;
import java.util.Random;

public class RockpaperScissor{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"Rock", "Paper", "Scissors"};
        int computerChoice = random.nextInt(3);

        System.out.println("Enter your choice (Rock, Paper, Scissors):");
        String playerChoice = scanner.nextLine().toLowerCase();

        System.out.println("Computer chose: " + choices[computerChoice]);

        if (playerChoice.equals(choices[computerChoice])) {
            System.out.println("It's a tie!");
        } else if (playerChoice.equals("rock") && computerChoice == 2) {
            System.out.println("Computer wins!");
        } else if (playerChoice.equals("paper") && computerChoice == 0) {
            System.out.println("Computer wins!");
        } else if (playerChoice.equals("scissors") && computerChoice == 1) {
            System.out.println("Computer wins!");
        } else {
            System.out.println("You win!");
        }

        scanner.close();
    }
}