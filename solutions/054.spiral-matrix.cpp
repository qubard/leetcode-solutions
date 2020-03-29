class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        
        vector<int> res;
        if (matrix.size() == 0) return res;
        int r = 0;
        int c = 0;
        int rd = matrix.size()-1;
        int cd = matrix[0].size()-1;
        
        while (r <= rd && c <= cd) {
            for (int a = c; a <= cd; a++) {
                res.push_back(matrix[r][a]);
            }
            
            for (int a = r + 1; a <= rd; a++) {
                res.push_back(matrix[a][cd]);
            }
            
            if (rd != r) {
                for (int a = cd - 1; a >= c; a--) {
                    res.push_back(matrix[rd][a]);
                }
            }
            
            if (c != cd) {
                for (int a = rd - 1; a >= r + 1; a--) {
                    res.push_back(matrix[a][c]);
                }
            }
            
            r++;
            rd--;
            c++;
            cd--;
        }
        
        return res;
    }
};