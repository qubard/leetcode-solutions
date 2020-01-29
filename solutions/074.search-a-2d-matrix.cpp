class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if (matrix.size() == 0) return false;
        return search(matrix, target, 0, matrix.size() - 1);
    }
    
    bool search(vector<vector<int>>& matrix, int target, int r1, int r2) {
        // observe that on the grid you have the top left number and bottom right number
        // specifying a range. we can look at either rows or columns each time
        // splitting it into two ranges and checking the boundary for our value
        // each time cutting it in half until we get either 1 row or 1 column
        // then we run a simple binary search for the value
        if (r2 - r1 == 1) {
            // binary search on either row ORed
            return std::binary_search(matrix[r1].begin(), matrix[r1].end(), target) | std::binary_search(matrix[r2].begin(), matrix[r2].end(), target);
        } else if (r2 - r1 == 0) {
            // binary search on single row
            return std::binary_search(matrix[r1].begin(), matrix[r1].end(), target);
        }
        
        int first = matrix[r1][0];
        int m = r1 + (r2-r1)/2;
        int m1 = matrix[m][0];
        int m2 = matrix[m][matrix[m].size() - 1];
        int second = matrix[r2][matrix[r2].size() - 1];
        
        if (target >= first && target <= m2) {
            return search(matrix, target, r1, m);
        } else if (target >= m1 && target <= second) {
            return search(matrix, target, m, r2);
        }
        
        return false;
    }
};