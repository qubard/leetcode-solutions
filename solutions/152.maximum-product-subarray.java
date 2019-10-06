class Solution {
    public int maxProduct(int[] nums) {
        int currMin = nums[0];
        int currMax = currMin;
        int ans = currMax;
        
        for (int i = 1; i < nums.length; i++) {
            // We have to include the value at each number
            // or start a new sequence there
            int tempMin = Math.min(nums[i] * currMin, Math.min(nums[i], nums[i] * currMax));
            currMax = Math.max(nums[i] * currMin, Math.max(nums[i], nums[i] * currMax));
            currMin = tempMin;
            ans = Math.max(ans, currMax);
        }
        
        return ans;
    }
}
