class Solution {

    private int[] original;
    private int[] curr;
    
    public Solution(int[] nums) {
        original = nums.clone();
        curr = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        curr = original.clone();
        return curr;
    }
    
    /** Returns a random shuffling of the array. */
    // Fisher Yates algorithm, note we choose an index from range [curr_index, arr_length - 1]
    public int[] shuffle() {
        Random r = new Random();
        for (int i = 0; i < curr.length; i++) {
            int a = r.nextInt(curr.length - i) + i;
            int temp = curr[a];
            curr[a] = curr[i];
            curr[i] = temp;
        }
        return curr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */