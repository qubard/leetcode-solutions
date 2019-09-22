class Solution {
    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) dp[i] = Integer.MAX_VALUE;
        int i = 0;
        while (i < nums.length) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < dp.length)
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
            if (i + nums[i] >= nums.length - 1) {
                return dp[nums.length - 1];
            }
            i++;
        }
        return dp[nums.length - 1];
    }
}