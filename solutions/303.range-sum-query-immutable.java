class NumArray {
    
    int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum; // sum up to index i
        }
    }
    
    public int sumRange(int i, int j) {
        if (i - 1 < 0) {
            return sums[j];
        }
        return sums[j] - sums[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */