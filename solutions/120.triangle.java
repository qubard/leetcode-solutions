class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][] = new int[triangle.size()][triangle.size()];
        
        Integer sol = null;
        for (int row = 0; row < triangle.size(); row++) {
            for (int col = 0; col < row + 1; col++) {
                if (row == 0) {
                    dp[row][col] = triangle.get(0).get(0);
                } else {
                    if (col == 0 || col == row) {
                        dp[row][col] = dp[row - 1][col == 0 ? 0 : col - 1] + triangle.get(row).get(col);
                    } else {
                        dp[row][col] = Math.min(dp[row - 1][col], dp[row - 1][col - 1]) + triangle.get(row).get(col);
                    }
                }
                
                if (row == triangle.size() - 1) {
                    if (sol == null || sol > dp[row][col]) 
                        sol = dp[row][col];
                }
            }
        }
        
        return sol;
    }
}