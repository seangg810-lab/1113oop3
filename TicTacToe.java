
public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private boolean gameOver;
    private String result;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        gameOver = false;
        result = "尚未結束";

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }

  
    public boolean set(int row, int col) {
        if (gameOver) return false;
        if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ')
            return false;

        board[row][col] = currentPlayer;
        evaluate();
        if (!gameOver)
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        return true;
    }

    
    private void evaluate() {
       
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' &&
                board[i][0] == board[i][1] &&
                board[i][1] == board[i][2]) {
                result = board[i][0] + " 勝利";
                gameOver = true;
                return;
            }

            if (board[0][i] != ' ' &&
                board[0][i] == board[1][i] &&
                board[1][i] == board[2][i]) {
                result = board[0][i] + " 勝利";
                gameOver = true;
                return;
            }
        }

        if (board[0][0] != ' ' &&
            board[0][0] == board[1][1] &&
            board[1][1] == board[2][2]) {
            result = board[0][0] + " 勝利";
            gameOver = true;
            return;
        }

        if (board[0][2] != ' ' &&
            board[0][2] == board[1][1] &&
            board[1][1] == board[2][0]) {
            result = board[0][2] + " 勝利";
            gameOver = true;
            return;
        }

    
        boolean full = true;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    full = false;
                    break;

        if (full) {
            result = "平手";
            gameOver = true;
        }
    }

    public String getResult() {
        return result;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char[][] getBoard() {
        return board;
    }
}
