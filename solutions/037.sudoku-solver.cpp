class Solution {
public:
    bool finished = false;
    
    void solveSudoku(vector<vector<char>>& board) {
        bool srow[10][10] = { false };
        bool scol[10][10] = { false };
        bool sbox[3][3][10] = { false };
        
        // Compute initial value of sets
        for (int row = 0; row < board.size(); row++) {
            for (int col = 0; col < board[row].size(); col++) {
                // use row, col to store a set 
                if (board[row][col] != '.') {
                    scol[col][board[row][col] - '0'] = true;
                    srow[row][board[row][col] - '0'] = true;
                    int i = row / 3;
                    int j = col / 3;
                    // 2:20am/
                    // 2:39 break
                    // max 2 + 2 * 3 = 8
                    sbox[i][j][board[row][col] - '0'] = true;
                }
            }
        }
        
        solveSudokuHelper(0, 0, board, sbox, scol, srow);
    }
    
    void solveSudokuHelper(int row, int col, vector<vector<char>>& board,  bool sbox[3][3][10], bool scol[10][10], bool srow[10][10]) {
        int possible = 0;
        
        int i = row / 3;
        int j = col / 3;
        
        int dcol = col + 1;
        int drow = row;
        if (col + 1 >= 9) {
            dcol = 0;
            drow = row + 1;
        }
        
        // I made the mistake of writing an NxN loop here 
        // instead of just checking one tile at a time and then
        // branching out
        
        if (row >= 9 || col >= 9) {
            if (board[8][8] != '.') {
                finished = true;
            }
            return;
        }

        if (board[row][col] == '.') {
            // Try inserting a number here
            for (int v = 1; v <= 9; v++) {
                char c = (char)((int)v + '0');
                if (!scol[col][v] && !srow[row][v] && !sbox[i][j][v]) {
                    scol[col][v] = true;
                    srow[row][v] = true;
                    sbox[i][j][v] = true;
                    board[row][col] = c;
                    solveSudokuHelper(drow, dcol, board, sbox, scol, srow);
                    scol[col][v] = false;
                    srow[row][v] = false;
                    sbox[i][j][v] = false;
                    if (!finished) {
                        board[row][col] = '.';
                    } else {
                        return;
                    }
                }
            }
            possible++;
        } else {
            solveSudokuHelper(drow, dcol, board, sbox, scol, srow);
        }
        return;
    }
};