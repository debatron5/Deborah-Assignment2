package com.coderscampus.objects;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

	public static void main(String[] args) {

		// Generate a number between 1 and 100
		Random rand = new Random();
		int theRandomNumber = rand.nextInt(100) + 1;
		{

			// Reading user input
			Scanner myTurn = new Scanner(System.in);

			System.out.println("Pick a number between 1 and 100");
			int guesses;
			int numberOfTries = 1; // This is the initial count of the number of guesses.
			boolean win = false;

			while (win == false) {
				guesses = myTurn.nextInt(); // Read the input to see if matches the random number.

				if (numberOfTries < 5) {

					if (guesses == theRandomNumber) { // if number is guessed, while loop is terminated
						System.out.println();
						System.out.println("You win! The number was: " + theRandomNumber);
						System.out.println("It took you " + numberOfTries + " guesses to win!");
						myTurn.close();
						win = true;
					}

					if (guesses < 1 || guesses > 100) {
						System.out.print("Your guess was not between 1 and 100, please try again: ");
					} else if (guesses < theRandomNumber) { // if the guess is too low, it will display
						System.out.println("Please pick a higher number");
					} else if (guesses > theRandomNumber) { // if guess is too high, it will display
						System.out.println("Please pick a lower number");
					}
				}
				// Output closing message and information to user if they guessed right
				else if (numberOfTries == 5) {
					if (guesses == theRandomNumber) { // if the number is guessed, while loop is terminated
						System.out.println();
						System.out.println("You win!");
						System.out.println("It took you" + numberOfTries + " guesses to get it correct!");
						myTurn.close();
						win = true;
					}
					if (guesses != theRandomNumber) { // Then the user did not guess the correct number
						System.out.println();
						System.out.println("You lose, the number to guess was: " + theRandomNumber);
						myTurn.close();
						break;
					}
				}
				numberOfTries = numberOfTries + 1; // Increment count of number of guesses by 1
			}
		}
	}
}