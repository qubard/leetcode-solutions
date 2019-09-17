class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (t.length() < s.length()) {
            return isOneEditDistance(t, s);
        }
        
        if (s.isEmpty() && t.isEmpty() || s.equals(t) || t.length() - s.length() > 1) {
            return false;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                // all chars up to i are equal, check rhs
                if (s.length() != t.length()) {
                    return s.substring(i).equals(t.substring(i + 1));
                } else {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
            }
        }
        
        return s.length() + 1 == t.length(); // "a", ""
    }
}