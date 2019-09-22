class Solution {
    // O(3n) solution which uses the boundaries to find max up to the boundary
    // in either direction and then do a comparison
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        ArrayDeque<Integer> window = new ArrayDeque<>();
        int currMax = 0;
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // max from start of boundary to i
            left[i] = i % k == 0 ? nums[i] : Math.max(left[i - 1], nums[i]);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            // max from end of boundary to i
            right[i] = (i + 1 >= nums.length || (i + 1) % k == 0) ? nums[i] : Math.max(right[i + 1], nums[i]);
        }
        int i = 0;
        int j = k - 1;
        int ret[] = new int[nums.length - k + 1];
        while(j < nums.length) {
            ret[i] = Math.max(right[i], left[j]);
            i++;
            j++;
        }
        return ret;
    }
}