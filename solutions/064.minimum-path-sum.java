class Solution {
    public int minPathSum(int[][] grid) {
        // It's the math.min of path from the top or left 
        // so you get this dp, only cause its a DAG
        int dp[][] = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (y > 0 && x > 0) {
                    dp[y][x] = Math.min(dp[y - 1][x], dp[y][x - 1]) + grid[y][x];
                } else if (x > 0) {
                    dp[y][x] = dp[y][x - 1] + grid[y][x];
                } else if (y > 0) {
                    dp[y][x] = dp[y - 1][x] + grid[y][x];
                }
            }
        }
        
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
