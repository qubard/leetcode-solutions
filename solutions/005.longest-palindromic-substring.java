class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) { return s; }
        
        boolean dp[][] = new boolean[s.length()][s.length()];
        
        // We just look at base cases n = 1, n = 2 substrings and then build from n = 3 to s.length()
        // substrings whether or not something is a palindrome: dp(i, j) returns true if substring s_i,j is a palindrome
        // false otherwise. 
        // thus we get the recursive definition of a palindrome as dp(i,j) = dp(i+1, j-1) && s[i] == s[j]
        
        // Once we know all the palindromes of length 2 we can easily build the palindromes of length 3 in O(1) time this way
   
        int max = 1;
        int maxI = 0;
        int maxJ = 0;
        
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            if (i + 1 < s.length()) {
                dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
                
                if (dp[i][i + 1]) {
                    max = 2;
                    maxI = i;
                    maxJ = i + 1;
                }
            }
        }
        
        for (int length = 2; length < s.length(); length++) {
            for (int i = 0; i < s.length(); i++) {
                int j = i + length;
                if (j < s.length()) {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                    
                    if (dp[i][j] && j - i + 1 > max) {
                        max = j - i + 1;
                        maxI = i;
                        maxJ = j;
                    }
                }
            }
        }
        
        return s.substring(maxI, maxJ + 1);
    }   
}