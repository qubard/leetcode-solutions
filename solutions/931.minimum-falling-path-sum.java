class Solution {
    public int minFallingPathSum(int[][] A) {
        int[][] dp = new int[A.length][A[0].length];
        int ret = Integer.MAX_VALUE;
        for (int y = 0; y < A.length; y++) {
            for (int x = 0; x < A[y].length; x++) {
                if (y == 0) {
                    dp[y][x] = A[y][x];
                } else {
                    if (x == 0) {
                        dp[y][x] = A[y][x] + Math.min(dp[y - 1][x], dp[y - 1][x + 1]);
                    } else {
                        dp[y][x] = A[y][x] + Math.min(dp[y - 1][x], Math.min(x + 1 < A[y].length ? dp[y - 1][x + 1] : Integer.MAX_VALUE, dp[y - 1][x - 1]));
                    }
                }
                
                if (y == A.length - 1) {
                    ret = Math.min(ret, dp[y][x]);   
                }
            }
        }
        
        return ret;
    }
}