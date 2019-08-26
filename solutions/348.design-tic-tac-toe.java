class TicTacToe {

    /** Initialize your data structure here. */
    char[][] board;
    int n;
    public TicTacToe(int n) {
        board = new char[n][n];
        this.n = n;
    }
    
    public int isGameOver() {
        // check rows
        char last = ' ';
        int nX = 0;
        int nO = 0;
        for (int row = 0; row < n; row++) {
            for (int i = 0; i < n; i++) {
                char cell = board[row][i];
                if (cell == 'O') nO++;
                if (cell == 'X') nX++;
                if (nX >= n || nO >= n) {
                    return nX >= n ? 1 : 2;
                }
            }
            nX = 0;
            nO = 0;
        }

        nX = 0;
        nO = 0;
        for (int col = 0; col < n; col++) {
            for (int i = 0; i < n; i++) {
                char cell = board[i][col];
                if (cell == 'O') nO++;
                if (cell == 'X') nX++;
                if (nX >= n || nO >= n) {
                    return nX >= n ? 1 : 2;
                }
            }
            nX = 0;
            nO = 0;
        }
        
        
        nX = 0;
        nO = 0;
        for (int i = 0; i < n; i++) {
            char cell = board[i][i];
            if (cell == 'O') nO++;
            if (cell == 'X') nX++;
            if (nX >= n || nO >= n) {
                return nX >= n ? 1 : 2;
            }
        }
        
        nX = 0;
        nO = 0;
        for (int i = 0; i < n; i++) {
            char cell = board[i][n - i - 1];
            if (cell == 'O') nO++;
            if (cell == 'X') nX++;
            if (nX >= n || nO >= n) {
                return nX >= n ? 1 : 2;
            }
        }
        return 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        // make the move, check win condition
        char move = player == 1 ? 'X' : 'O';
        board[row][col] = move;
        return isGameOver();
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */