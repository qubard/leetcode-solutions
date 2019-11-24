class Solution {
public:
    int countBattleships(vector<vector<char>>& board) {
        int count = 0;
        for (int row = 0; row < board.size(); row++) {
            for (int col = 0; col < board[0].size(); col++) {
                if (board[row][col] == 'X') {
                    bool up = row - 1 >= 0 && board[row - 1][col] == 'X';
                    bool left = col - 1 >= 0 && board[row][col - 1] == 'X';
                    
                    // just record start of line (top left corner) 
                    // so (X)XXXX
                    // or (X)
                    //     X
                    //     X
                    if (up || left) {
                        continue;
                    }
                    
                    count++;
                }
            }
        }
        return count;
    }
};