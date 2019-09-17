class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Store for each level the min
        int count = 0;
        int sol = 0;
        map.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 0 ? -1 : 1;
            if (!map.containsKey(count)) {
                map.put(count, i + 1);
            } else {
                sol = Math.max(i + 1 - map.get(count), sol);
            }
        }
        return sol;
    }
}