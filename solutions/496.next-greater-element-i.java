class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Integer> stk = new ArrayDeque<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            while (!stk.isEmpty() && nums[i] > stk.peek()) {
               map.put(stk.pop(), nums[i]);
            }
            stk.push(nums[i]);
        }
        
        int[] ret = new int[findNums.length];
        
        for (int i = 0; i < ret.length; i++)
            ret[i] = map.getOrDefault(findNums[i], -1);
        return ret;
    }
}