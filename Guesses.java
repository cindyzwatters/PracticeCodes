import java.util.*;

public class Guess {
    public static void main(String[] args) {
        giveIntro();01
        //Initiates Scanner
        Scanner console = new Scanner(System.in);

        //Introduction
        System.out.println("Let's play a guessing game!");

        
        //Initiates Random for Guessing Game
        Random rand = new Random();
        //Sets number range for randomized guess
        int number = rand.nextInt(100);
        

        //First guess
        System.out.print("What is your guess? ");
        int guess = Console.nextInt();
        int numberOfGuesses = 1;

        //Initializes command if user does not guess correctly
        while (guess != number) {
            int numberOfMatches = matches(number, guess);
            System.out.print("Sorry. Try again!");
        }

        //Next guess
        System.out.print("What is your next guess? ");
        guess = console.nextInt();
        numberOfGuesses++;

        System.out.println("You did it! You guessed it right in " + numberOfGuesses + " tries.");

    }

    public static int matches(int number, int guess) {
        int numberOfMatches = 0;
        return numberOfMatches;
    }
}
