class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        bool a = false;
        bool b = false;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix[0].size(); j++) {
                if (i == 0) {
                    if (matrix[i][j] == 0) {
                        a = true;
                        if (j == 0) b = true;
                    }
                } else if (j == 0) {
                    if (matrix[i][j] == 0) b = true;
                } else {
                    if (matrix[i][j] == 0) {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
        }
        
        for (int i = matrix.size() - 1; i >= 0; i--) {
            for (int j = matrix[0].size() - 1; j >= 0; j--) {
                int& v = matrix[i][j];
                if (v != 0) {
                    if (i == 0 && a) {
                        v = 0;
                    } else if (j == 0 && b) {
                        v = 0;
                    } else {
                        if (matrix[0][j] == 0 || matrix[i][0] == 0) v = 0;
                    }
                }
            }
        }
    }
};