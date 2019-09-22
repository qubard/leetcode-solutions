class Solution {
    public boolean canJump(int[] nums) {
        int i = 0;
        int max = -1;
        if (nums.length == 1) return true;
        while ((i <= max || max < 0) && i < nums.length) {
            max = max < 0 ? nums[i] : Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) {
                return true;
            }
            i++;
        }
        return false;
    }
}