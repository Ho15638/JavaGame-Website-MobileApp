import java.util.Scanner;

public class GameConsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the game console!");

        while (true) {
            System.out.println("Choose a game to play:");
            System.out.println("1. Tic Tac Toe");
            System.out.println("2. Hangman");
            System.out.println("3. Number Guessing");
            System.out.println("4. Quit");
            int choice = scanner.nextInt();

            if (choice == 1) {
                TicTacToe game = new TicTacToe();
                game.play();
            } else if (choice == 2) {
                Hangman game = new Hangman();
                game.play();
            } else if (choice == 3) {
                NumberGuessing game = new NumberGuessing();
                game.play();
            } else if (choice == 4) {
                System.out.println("Thanks for playing!");
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, 3 or 4.");
            }
        }
    }
}
