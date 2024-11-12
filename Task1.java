package com.solution.Game;

import java.util.Random;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain;

        System.out.println("Welcome to the Number Guesser Game!");
        System.out.println("--------------------------------------------------");

        do {
            int randomNum = random.nextInt(100) + 1; 
            int attempts = 0;
            int maxAttempts = 5;
            boolean hasWon = false;

            System.out.println("Guess the number between 1 and 100: You have " + maxAttempts + " attempts.");
            System.out.println("--------------------------------------------------");
           
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

            
                if (guess == randomNum) {
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1; 
                    hasWon = true;
                    break;
                } else if (guess > randomNum) {
                    System.out.println("Your guess is too higher, Guess lower.");
                } else {
                    System.out.println("Your guess is too lower, Guess higher.");
                }
            }

            if (!hasWon) {
                System.out.println("Sorry, you've lost the game! The number was: " + randomNum);
            }

            
            System.out.print("Want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

    
        System.out.println("\n********** Game Over **********");
        System.out.println("----------------------------------------------");
        System.out.println("Your final score: " + score);

        scanner.close();
    }
}
