class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        
        for (int i = 0; i < dp.length; i++) dp[i] = amount + 1;
        
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount)
                dp[coins[i]] = 1;
        }
        
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                // It's asking for the .. FEWEST number of ways
                if (coins[j] <= i) {
                    int prev = dp[i - coins[j]];
                    dp[i] = Math.min(dp[i], prev + 1);
                }
            } 
        }
        
        // My max case was wrong? defaulting it to amount + 1?
        
        if (dp[amount] > amount) return -1;
        
        return dp[amount];
    }
}