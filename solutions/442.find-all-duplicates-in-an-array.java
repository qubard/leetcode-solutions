class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int v = Math.abs(nums[i]);
            if (nums[v - 1] < 0) {
                ret.add(v);
            }
            nums[v - 1] = -1 * nums[v - 1];
        }
        return ret;
    }
}