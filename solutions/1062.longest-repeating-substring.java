class Solution {
    public int longestRepeatingSubstring(String S) {
        // Maximum repeating subarray or equivalently longest common substring on itself
        int dp[][] = new int[S.length() + 1][S.length() + 1];
        int sol = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            for (int j = S.length() - 1; j >= 0; j--) {
                if (i != j && S.charAt(i) == S.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                    sol = Math.max(sol, dp[i][j]);
                }
            }
        }
        return sol;
    }
}