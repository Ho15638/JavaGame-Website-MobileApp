import java.util.*;

public class TicTacToe {
    char[][] board = new char[3][3];
    char currentPlayer = 'X';
    boolean gameEnded = false;

    public TicTacToe() {
        // Initialize the board with numbers from 1 to 9
        int num = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.toString(num).charAt(0);
                num++;
            }
        }
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public void makeMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        do {
            try {
                System.out.print("Player " + currentPlayer + ", enter a number (1-9): ");
                int position = scanner.nextInt();
                row = (position - 1) / 3;
                col = (position - 1) % 3;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number from 1 to 9.");
                scanner.nextLine(); // clear the input buffer
                row = -1; // set row and col to invalid values to trigger re-prompt
                col = -1;
            }
        } while (positionIsInvalid(row, col));
        board[row][col] = currentPlayer;
    }

    public boolean positionIsInvalid(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid position. Please enter a number from 1 to 9.");
            return true;
        }
        if (board[row][col] == 'X' || board[row][col] == 'O') {
            System.out.println("Position already occupied. Please choose a different position.");
            return true;
        }
        return false;
    }

    public void switchPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    public void checkForWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                gameEnded = true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                gameEnded = true;
            }
        }

        // Check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            gameEnded = true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            gameEnded = true;
        }

        if (gameEnded) {
            System.out.println("Player " + currentPlayer + " wins!");
        }
    }

    public void checkForTie() {
        boolean isTie = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') {
                    isTie = false;
                    break;
                }
            }
        }
        if (isTie) {
            gameEnded = true;
            System.out.println("It's a tie!");
        }
    }

    public void play() {
        while (!gameEnded) {
            printBoard();
            makeMove();
            checkForWinner();
            checkForTie();
            switchPlayer();
        }
        printBoard();
        System.out.println("Do you want to play again? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("Y")) {
            reset();
            play();
        } else {
            System.out.println("Thanks for playing!");
        }
    }

    public void reset() {
        gameEnded = false;
        currentPlayer = 'X';
        int num = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.toString(num).charAt(0);
                num++;
            }
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
}