class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        int left = 0;
        int right = A.length - 1;
        Arrays.sort(A);
        Integer sol = null;
        while (left < right) {
            int sum = A[left] + A[right];
            if (sum < K) {
                sol = sol == null ? sum : Math.max(sum, sol);
                left++;
            } else {
                right--;
            }
        }
        return sol == null ? -1 : sol;
    }
}