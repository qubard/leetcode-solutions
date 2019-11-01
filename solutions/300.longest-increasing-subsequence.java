class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        
        if (nums.length == 0) return 0;
        int sol = 1;
        for (int i = 0; i < nums.length; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
            sol = Math.max(lis[i], sol);
        }
        return sol;
    }
}