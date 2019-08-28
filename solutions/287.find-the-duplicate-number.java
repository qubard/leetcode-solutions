class Solution {
    public int findDuplicate(int[] nums) {
        for (Integer i: nums) {
            if (nums[Math.abs(i) - 1] < 0) {
                return Math.abs(i);
            }
            nums[Math.abs(i) - 1] *= -1;
        }
        return 0;
    }
}