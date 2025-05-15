
import java.util.*;

public class Hangman {

    private String[] words = {"apple", "banana", "cherry", "orange", "pear"};
    private String word;
    private int guessesLeft;
    private Set<Character> guessedLetters;

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hangman!");
        System.out.println("---------");
        System.out.println("  |   |  ");
        System.out.println("  |   O  ");
        System.out.println("  |  \\|/  ");
        System.out.println("  |   |  ");
        System.out.println("  |  / \\  ");
        System.out.println(" _|_       ");
        System.out.println("           ");
        System.out.println("_ _ _ _ _ _");
        System.out.println("I'm thinking of a word. Can you guess what it is?");

        // Choose a random word from the list
        Random random = new Random();
        word = words[random.nextInt(words.length)];

        // Set up the game state
        guessesLeft = 7;
        guessedLetters = new HashSet<>();

        while (true) {
            // Display the current state of the word
            System.out.print("Word: ");
            for (char letter : word.toCharArray()) {
                if (guessedLetters.contains(letter)) {
                    System.out.print(letter);
                } else {
                    System.out.print("_");
                }
            }
            System.out.println();

            // Display the remaining guesses and guessed letters
            System.out.println("Guesses left: " + guessesLeft);
            System.out.print("Guessed letters: ");
            for (char letter : guessedLetters) {
                System.out.print(letter + " ");
            }
            System.out.println();

            // Prompt the user to guess a letter
            System.out.print("Guess a letter: ");
            String input = scanner.nextLine().toLowerCase();
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Invalid input. Please enter a single letter.");
                continue;
            }
            char letter = input.charAt(0);
            if (guessedLetters.contains(letter)) {
                System.out.println("You already guessed that letter.");
                continue;
            }
            guessedLetters.add(letter);

            // Check if the letter is in the word
            if (word.indexOf(letter) == -1) {
                guessesLeft--;
                System.out.println("---------------");
                System.out.println("|             |");
                System.out.println("|             O");
                System.out.println("|            " + (guessesLeft > 1 ? "\\" : "") + (guessesLeft > 2 ? "|" : "") + (guessesLeft > 3 ? "/" : ""));
                System.out.println("|            " + (guessesLeft > 4 ? " |" : ""));
                System.out.println("|            " + (guessesLeft > 5 ? "/" : "") + " ");
                System.out.println("|");
                System.out.println("_ _ _ _ _ _");
                System.out.println("Sorry, that letter is not in the word.");
            } else {
                System.out.println("Good guess!");
            }
            // Check if the game is over
            if (guessesLeft == 0) {
                System.out.println("---------");
                System.out.println("  |   |  ");
                System.out.println("  |     ");
                System.out.println("  |    ");
                System.out.println("  |     ");
                System.out.println("  |    ");
                System.out.println(" _|_       ");
                System.out.println("           ");
                System.out.println("_ _ _ _ _ _");
                System.out.println("Sorry, you ran out of guesses. The word was " + word + ".");
                break;
            }
            if (isWordGuessed(word, guessedLetters)) {
                System.out.println("Congratulations, you guessed the word!");
                break;
            }
        }
    }

    private static boolean isWordGuessed(String word, Set<Character> guessedLetters) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!guessedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Hangman game = new Hangman();
        game.play();
    }
}
