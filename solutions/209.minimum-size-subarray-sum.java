class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int sol = -1;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= s) {
                sol = sol < 0 ? right - left : Math.min(sol, right - left);
                sum -= nums[left++];
            }
        }
        return sol < 0 ? 0 : sol;
    }
}

/*

O(nlogn) TreeMap solution

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int sol = -1;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(sum, i);
            if (sum >= s) {
                int v = i - (map.higherEntry(sum - s) == null ? 0 : map.higherEntry(sum - s).getValue()) + 1;
                if (sol == -1) {
                    sol = v;
                } else {
                    sol = Math.min(v, sol);
                }
            }
        }
        return sol < 0 ? 0 : sol;
    }
}

*/