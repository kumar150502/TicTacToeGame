import java.util.*;
public class TicTacToeGame {
    private char[] board;
    private char currentPlayer;

    public TicTacToeGame() {
        board = new char[10];
        Arrays.fill(board, ' ');
        currentPlayer = ' ';
    }

    public void startGame() {
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("You can choose 'X' or 'O'.");
        chooseLetter();
        showBoard();

        while (true) {
            playerMove();
            showBoard();
            if (checkWinner(currentPlayer)) {
                System.out.println("Congratulations! " + currentPlayer + " wins!");
                break;
            }
            if (isBoardFull()) {
                System.out.println("It's a tie!");
                break;
            }
            computerMove();
            showBoard();
            if (checkWinner('O')) {
                System.out.println("Computer wins!");
                break;
            }
        }

        System.out.println("Thanks for playing Tic Tac Toe!");
    }

    private void chooseLetter() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose 'X' or 'O': ");
        char choice = scanner.next().toUpperCase().charAt(0);

        if (choice == 'X') {
            currentPlayer = 'X';
        } else if (choice == 'O') {
            currentPlayer = 'O';
        } else {
            System.out.println("Invalid choice. Defaulting to 'X'.");
            currentPlayer = 'X';
        }
    }

    private void showBoard() {
        System.out.println("-------------");
        for (int i = 1; i <= 9; i += 3) {
            System.out.println("| " + board[i] + " | " + board[i + 1] + " | " + board[i + 2] + " |");
            System.out.println("-------------");
        }
    }

    private void playerMove() {
        Scanner scanner = new Scanner(System.in);
        int move;
        do {
            System.out.print("Enter your move (1-9): ");
            move = scanner.nextInt();
        } while (move < 1 || move > 9 || board[move] != ' ');

        board[move] = currentPlayer;
    }

    private void computerMove() {
        Random random = new Random();
        int move;
        do {
            move = random.nextInt(9) + 1;
        } while (board[move] != ' ');

        board[move] = 'O';
    }

    private boolean checkWinner(char player) {

        for (int i = 0; i < 3; i++) {
            if (board[1 + i] == player && board[4 + i] == player && board[7 + i] == player) {
                return true;
            }
            if (board[1 + i * 3] == player && board[2 + i * 3] == player && board[3 + i * 3] == player) {
                return true;
            }
        }
        if ((board[1] == player && board[5] == player && board[9] == player) ||
                (board[3] == player && board[5] == player && board[7] == player)) {
            return true;
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int i = 1; i <= 9; i++) {
            if (board[i] == ' ') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.startGame();
    }
}
