class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int dp[][] = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        
        for (int M = 0; M < m; M++) {
            for (int N = 0; N < n; N++) {
                if (obstacleGrid[M][N] == 0) {
                    if (M > 0 && N > 0) {
                        dp[M][N] = dp[M - 1][N] + dp[M][N - 1];
                    } else if (M == 0 && N != 0) {
                        dp[M][N] = dp[M][N - 1];
                    } else if (N == 0&& M != 0){
                        dp[M][N] = dp[M - 1][N];
                    }
               }
            }
        }
        
        return dp[m - 1][n - 1];
    }
}