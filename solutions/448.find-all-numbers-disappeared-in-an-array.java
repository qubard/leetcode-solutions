class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Trick is to use the actual array 
        // for no extra space. And map each integer to i - 1 (its unique slot)
        // Reason i - 1 and not i is because the number n is out of bounds and we start
        // at 1.
        for (int i = 0; i < nums.length; i++) {
            int v = Math.abs(nums[i]);
            if (nums[v - 1] > 0) {
                nums[v - 1] = -1 * nums[v - 1]; // make it negative
            }
        }
        
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                ret.add(i);
            }
        }
        return ret;
    }
}