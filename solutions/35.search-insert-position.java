class Solution {
    public int searchInsert(int[] nums, int target) {
        // find two indices i, j such that nums[i] <= target <= nums[j]
        if (nums.length == 0) return 0;
        if (nums[nums.length - 1] < target) return nums.length;
        if (nums[0] >= target) return 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < target && nums[i + 1] >= target) {
                return i + 1;
            }
        }
        
        return 0;
    }
}