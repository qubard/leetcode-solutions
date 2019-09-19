// Dynamic programming solution
// TLDR; if you can't write a chain recursive solution 
// for the general problem based on subproblems 
// calling your solution for every single possible combination
// works and is equivalently expressible (they all exist in the (i, j) space)
class Solution {
    public int findLength(int[] A, int[] B) {
        int sol = 0;
        int dp[][] = new int[A.length + 1][B.length + 1];
        for (int j = B.length - 1; j >= 0; j--) {
            for (int i = A.length - 1; i >= 0; i--) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                    sol = Math.max(dp[i][j], sol);
                }
            }
        }
        return sol;
    }
}
/*
// recursive solution

class Solution {
    public int findLength(int[] A, int[] B) {
        int sol = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                sol = Math.max(findLength(A, B, i, j), sol);
            }
        }
        return sol;
    }
    
    public int findLength(int[] A, int[] B, int i, int j) {
        if (i >= A.length || j >= B.length)
            return 0;
        
        if (A[i] == B[j]) {
            return findLength(A, B, i + 1, j + 1) + 1;
        }
        
        return 0;
    }
}
*/