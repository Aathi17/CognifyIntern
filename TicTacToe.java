package intern;
import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            resetBoard();
            playGame();

            System.out.print("Do you want to play again? (Y/N): ");
        } while (scanner.next().equalsIgnoreCase("Y"));

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static void playGame() {
        boolean gameInProgress = true;

        while (gameInProgress) {
            displayBoard();
            getPlayerMove();
            gameInProgress = !checkForWin() && !checkForDraw();
            switchPlayer();
        }

        displayBoard();
        announceResult();
    }

    private static void displayBoard() {
        System.out.println("-------------");
        for (char[] row : board) {
            System.out.print("| ");
            for (char cell : row) {
                System.out.print(cell + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static void getPlayerMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        do {
            System.out.print("Player " + currentPlayer + ", enter your move (row and column, separated by space): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
        } while (!isValidMove(row, col));

        board[row][col] = currentPlayer;
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private static boolean checkForWin() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                return true;
            }
        }

        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            System.out.println("Player " + currentPlayer + " wins!");
            return true;
        }

        return false;
    }

    private static boolean checkForDraw() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }

        System.out.println("It's a draw!");
        return true;
    }

    private static void announceResult() {
        System.out.println("Game Over!");
    }

    private static void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X';
    }
}
