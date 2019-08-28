class Solution {
    public int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target + 1];
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < dp.length) {
                dp[nums[i]] = 1; // initially
            }
        }
        
        for (int i = 1; i <= target; i++) {
            for (int k = 0; k < nums.length; k++) {
                int v =  i - nums[k];
                if (v >= 0) {
                    dp[i] += dp[v];
                }
            }
        }
        
        /*
        int total = 0;
        if (target == 0) return 1;
        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                total += combinationSum4(nums, target - nums[i]);
            }
        }
        */
        
        return dp[target];
    }
}