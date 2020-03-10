class Solution {
public:
    int countServers(vector<vector<int>>& grid) {
        vector<int> r(grid.size(), 0);
        vector<int> c(grid[0].size(), 0);
        int sol = 0;
        for (int row = 0; row < grid.size(); row++) {
            for (int col = 0; col < grid[0].size(); col++) {
                if (grid[row][col] == 1) {
                    r[row]++;
                    c[col]++;
                }
            }
        }
        
        for (int row = 0; row < grid.size(); row++) {
            for (int col = 0; col < grid[0].size(); col++) {
                if (grid[row][col] == 1 && (r[row] > 1 || c[col] > 1)) {
                    sol++;
                }
            }
        }
        return sol;
    }
};