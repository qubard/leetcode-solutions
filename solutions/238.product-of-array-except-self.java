class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for (int i = 0; i < left.length; i++) {
            if (i > 0) {
                left[i] = left[i - 1] * nums[i];
            } else {
                left[0] = nums[0];
            }
        }
        
        int[] ret = new int[nums.length];
        for (int i = right.length - 1; i >= 0; i--) {
            if (i == right.length - 1) {
                right[i] = nums[right.length - 1];
            } else {
                right[i] = right[i + 1] * nums[i];
            }
            ret[i] = i == 0 ? right[i + 1] : i == right.length - 1 ? left[i-1] : left[i - 1] * right[i + 1];
        }
        
        return ret;
    }
}