class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] soln = new int[2];
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (m.containsKey(target - numbers[i])) {
                soln[0] = m.get(target - numbers[i]) + 1;
                soln[1] = i + 1;
                return soln;
            }
            m.put(numbers[i], i);
        }
        return soln;
    }
}