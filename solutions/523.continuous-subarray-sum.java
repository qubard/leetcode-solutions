class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int c = 0;
        
        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sums[i] = i == 0 ? nums[0] : sums[i - 1] + nums[i];
            if (i > 0 && ((k == 0 && sums[i] == 0) || (k != 0 && sums[i] % k == 0))) return true;
        }
        
        for (int j = 0; j < nums.length; j++) {
            for (int l = 1; j + l < nums.length; l++) {
                int subsum = sums[j + l] - sums[j];
                if (l > 1 && ((k == 0 && subsum == 0) || (k != 0 && subsum % k == 0))) {
                    return true;
                }
            }
        }
        return false;
    }
}
