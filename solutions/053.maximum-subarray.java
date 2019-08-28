class Solution {
    public int maxSubArray(int[] nums) {
        // Kadane's algorithm
        int sum = 0;
        if (nums.length == 0) return 0;
        int maxsum = Integer.MIN_VALUE;
        int right = 0;
        while (right < nums.length) {
            sum = Math.max(nums[right], nums[right] + sum); 
            maxsum = Math.max(maxsum, sum); 
            right++;
        }
        return maxsum;
    }
}