class Solution {
    /*
    public int numRollsToTarget(int d, int f, int target) {
        if (target == 0) return 1;
        if (d == 1)  {
            if (target > f) {
                return 0;
            }
            return 1;
        }

        int ways = 0;
        for (int face = 1; face <= f; face++) {
            if (target - face >= 0) {
                ways += numRollsToTarget(d - 1, f, target - face);
            }
        }
        // use dynamic programming
        return ways % 1000000007;
    }
    */
    public int numRollsToTarget(int d, int f, int target) {
        long dp[][] = new long[d + 1][1001];
        
        for (int i = 1; i <= f; i++) {
            // if d is 1 there is 1 way to make target
            dp[1][i] = 1;
        }
        
        long mod = (long)(Math.pow(10,9) + 7);
        
        for (int j = 2; j <= d; j++) {
            for (int face = 1; face <= target; face++) {
                for (int k = 1; k <= f; k++) {
                    if (face - k >= 0){
                        dp[j][face] = (dp[j][face] % mod + dp[j - 1][face - k]) % mod;
                    } else {
                        break;
                    }
                }
            }
        }
        
        return (int) dp[d][target];
    }
}