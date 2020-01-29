class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        std::set<std::string> keys;
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    std::string key1 = "row" + std::to_string(i) + " " + board[i][j];
                    std::string key2 = "col" + std::to_string(j) + " " + board[i][j];
                    std::string key3 = "mat" + std::to_string(i / 3 | 0) + "," + std::to_string(j / 3 | 0) + " " + std::to_string(board[i][j]);
                    
                    if (keys.find(key1) != keys.end() || keys.find(key2) != keys.end() || keys.find(key3) != keys.end()) {
                        return false;
                    }

                    keys.insert(key1);
                    keys.insert(key2);
                    keys.insert(key3);
                }
            }
        }
        return true;
    }
};