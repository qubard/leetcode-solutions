class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int sol = 0;
        map.put(0, 0); // sum -> index
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i + 1);
            }
            
            if (map.containsKey(sum - k)) {
                sol = Math.max(sol, i + 1- map.get(sum - k));
            }
        }
        return sol;
    }
}