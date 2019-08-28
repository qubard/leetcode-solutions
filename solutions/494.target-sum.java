class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        // dp[i][j] is number of ways to make target j with values from 0 to i (inclusive)
        int sum = 0;
        for (int i = 0; i < nums.length; i++ ){
            sum += nums[i];
        }
        
        if (S > sum || S < -sum) {
            return 0;
        }
        
        // Note: CONVERT THE RECURSION TO THE DP. 
        // The reason it will not work is because 
        // your base case should be 0-> 1
        // Sum will not exceed 1000, so go up to 2000
        // tldr; always write the recurrence
        int dp[][] = new int[nums.length + 1][2 * sum + 1];
        
        dp[0][0 + sum] = 1; // base case
        
        for (int i = 1; i <= nums.length; i++) {
            for (int s = 0; s < 2 * sum + 1; s++) {
                if (s + nums[i - 1] < 2 * sum + 1) {
                    dp[i][s] += dp[i - 1][s + nums[i - 1]];
                }

                if (s - nums[i - 1] >= 0) {
                    dp[i][s] += dp[i - 1][s - nums[i - 1]];
                }
            }
        }
        
        
        return dp[nums.length][S + sum];
    }
    
    /*
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }
    public void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S)
                count++;
        } else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S); // i + 1 depends on i. top to bottom from the recursion we get dp[i] depends on dp[i - 1]
        } // If you see a dependency on i + 1 or i - 1 that means you have sub problems and can apply DP
        // same thing as dependencies in a topological graph, doesn't matter which direction it goes
    }
}
    */
}