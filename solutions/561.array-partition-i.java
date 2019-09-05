class Solution {
    public int arrayPairSum(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (Integer i : nums) {
            arr.add(i);
        }
        Collections.sort(arr);
        int sum = 0;
        for (int i = 0; i < arr.size() - 1; i += 2) {
            sum += Math.min(arr.get(i), arr.get(i + 1));
        }
        return sum;
    }
}