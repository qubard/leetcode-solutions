class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] sol = new int[A.length];
        int e = 0; // even index
        int o = A.length - 1; // odd index
        for (int i = 0; i < A.length; i++) {
            sol[A[i] % 2 == 0 ? e++ : o--] = A[i];
        }
        return sol;
    }
}