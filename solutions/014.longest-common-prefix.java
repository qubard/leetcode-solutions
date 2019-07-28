class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        
        if (strs.length == 1) return strs[0];
        
        String s = strs[0];
        String maxPrefix = "";
       
        int maxLength = -1;
        for (String str: strs) {
            if (str != s) {
                // Compare the prefixes one char at a time
                String prefix = "";
                int l = 0;
                for (int i = 0; i < Math.min(str.length(), s.length()); i++) {
                    if (str.charAt(i) == s.charAt(i)) {
                        prefix += str.charAt(i);
                        l++;
                    } else {
                        break;
                    }
                }

                if (l < maxLength || maxLength == -1) {
                    maxLength = l;
                    maxPrefix = prefix;
                }
            }
        }
       
        return maxPrefix;
    }
}