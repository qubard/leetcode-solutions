class Solution {
    public int maxTurbulenceSize(int[] A) {
        if(A.length == 0) return 0;
        int max = 1;
        int anchor = 0;
        for (int i = 1; i < A.length; i++) {
            int c = Integer.compare(A[i], A[i - 1]);
            if (i == A.length - 1 || c == 0 || Integer.compare(A[i], A[i + 1]) != c) { 
                max = Math.max(max, i - anchor + (c == 0 ? 0 : 1));
                anchor = i;
            }
        }
        return max;
    }
}