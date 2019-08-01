class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        
        dp[1][1] = 1;
        
        for (int M = 1; M <= m; M++) {
            for (int N = 1; N <= n; N++) {
                if (M > 1 && N > 1) {
                    dp[M][N] = dp[M - 1][N] + dp[M][N - 1];
                } else if (M == 1 && N != 1) {
                    dp[M][N] = dp[M][N - 1];
                } else if (N == 1 && M != 1) {
                    dp[M][N] = dp[M - 1][N];
                }
            }
        }
        
        return dp[m][n];
    }
}   

