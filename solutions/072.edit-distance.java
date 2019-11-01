class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() * word2.length() == 0) {
            return word1.length() + word2.length();
        }
        
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }q
        
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                dp[i][j] = Integer.MAX_VALUE;
                char a = word1.charAt(i - 1);
                char b = word2.charAt(j - 1);
                if (a == b) {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1] - 1));
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}