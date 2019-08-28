class Solution {
    public boolean helper(String s, Set<String> wordDict) {
        if (wordDict.contains(s)) {
            return true;
        }
        
        for (int i = 1; i < s.length(); i++) {
            String str = s.substring(0, i);
            if (wordDict.contains(str)) {
                if (helper(s.substring(i, s.length()), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dp(String s, Set<String> wordDict) {
        if (wordDict.contains(s)) {
            return true;
        }
        
        boolean dp[] = new boolean[s.length()];

        for (int l = 0; l < s.length(); l++) {
            // From left to right check if lhs is valid solution
            // and then if rhs is in the words list
            int i = 0;
            String ss = s.substring(0, l + 1);
            if (wordDict.contains(ss)) {
                dp[l] = true;
            }
            for (int end = l + 1; end < s.length(); end++) {
                dp[end] = dp[end] || (dp[l] && wordDict.contains(s.substring(l + 1, end + 1)));
                if (dp[s.length() - 1]) return true;
            }
        }
        return dp[s.length() - 1];
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<String>();
        dict.addAll(wordDict);
        return dp(s, dict);
    }
}