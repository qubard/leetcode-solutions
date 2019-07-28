class Solution {
    // we def don't NEED this
    public long toNum(String s) {
        long pow = 1;
        long v = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            v += pow * (c - '0');
            pow *= 10;
        }
        return v;
    }
    
    public int reverse(int x) {
        boolean neg = x < 0;
        String rev = new StringBuilder(Integer.toString(Math.abs(x))).reverse().toString();
        
        if (rev.length() >= 1 && rev.charAt(0) == '0') {
            int maxI = 0;
            for (int i = 1; i < rev.length(); i++) {
                if (rev.charAt(i) != '0') {
                    maxI = i;
                    break;
                }
            }
            rev = rev.substring(maxI, rev.length());
        }
        
        long val = toNum(rev);
        
        if (val > Math.pow(2, 31) - 1 || val <= -Math.pow(2,31)) {
            return 0;
        }
        
        if (neg) {
            return -(int)val;
        }
        
        return (int)val;
    }
}