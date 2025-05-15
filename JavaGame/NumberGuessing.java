import java.util.*;

public class NumberGuessing {
    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100. Can you guess what it is?");

        // Choose a random number between 1 and 100
        Random random = new Random();
        int number = random.nextInt(100) + 1;

        // Set up the game state
        int guessesLeft = 5;
        int guess;
        int max = 100;
        int min = 1;

        while (true) {
            // Prompt the user to guess a number
            System.out.print("Guess a number: ");
            try {
                guess = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            if (guess < 1 || guess > 100) {
                System.out.println("Invalid input. Please enter a number between 1 and 100.");
                continue;
            }

            // Check if the guess is correct
            if (guess == number) {
                System.out.println("Congratulations, you guessed the number!");
                break;
            } else if (guess < number) {
                min = guess;
                System.out.println("Sorry, your guess is too low. The number is between " + min + " and " + max);
            } else {
                max = guess;
                System.out.println("Sorry, your guess is too high. The number is between " + min + " and " + max );
            }

            // Update the number of guesses left
            guessesLeft--;
            if (guessesLeft == 0) {
                System.out.println("Sorry, you ran out of guesses. The number was " + number + ".");
                break;
            } else {
                System.out.println("Guesses left: " + guessesLeft);
            }
        }
    }

    public static void main(String[] args) {
        NumberGuessing game = new NumberGuessing();
        game.play();
    }
}

    
