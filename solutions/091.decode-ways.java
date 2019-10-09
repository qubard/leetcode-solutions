class Solution {
     public int numDecodings(String s) {
        int dp[] = new int[s.length() + 1];
        
        // Empty
        dp[s.length()] = 1;
        
        // dp[i] is substring from i to s.length() - 1
        // We want to solve for dp[0]
        
        for (int i = s.length() - 1; i >= 0; i--) {
            int first = s.charAt(i) - '0';
            if (first == 0) {
                dp[i] = 0;
            } else {
                int second = i + 1 >= s.length() ? 0 : s.charAt(i + 1) - '0';
                int total = second + first * 10;
                if (total <= 26 && i + 2 < s.length() + 1) {
                    dp[i] = dp[i + 1] + dp[i + 2];
                } else {
                    dp[i] = dp[i + 1];
                }
            }
        }
        
        return dp[0];
    }
   
    /*
        Recurrence:
        public int numDecodings(String s) {
            if (s.isEmpty()) return 1;

            if (s.length() == 1) {
                int val = s.charAt(0) - '0';
                if (val >= 1 && val <= 9) {
                    return 1;
                }
                return 0;
            }

            int first = s.charAt(0) - '0';
            int val = first * 10 + (s.charAt(1) - '0');

            if (s.charAt(0) == '0') {
                return 0;
            }

            if (val <= 26) {
                return numDecodings(s.substring(2, s.length())) + numDecodings(s.substring(1, s.length()));
            }

            return numDecodings(s.substring(1, s.length()));
        }
    */
}
