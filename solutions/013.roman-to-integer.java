class Solution {
    
    static HashMap<String, Integer> h;
    
    static {
        h = new HashMap<String, Integer>();
        h.put("IX", 9);
        h.put("IV", 4);
        h.put("CD", 400);
        h.put("CM", 900);
        h.put("XL", 40);
        h.put("XC", 90);
        h.put("X", 10);
        h.put("V", 5);
        h.put("L", 50);
        h.put("D", 500);
        h.put("M", 1000);
        h.put("C", 100);
        h.put("I", 1);
    }
    
    public int romanToInt(String s) {
        if (s.length() == 0) return 0;

        char c = s.charAt(0);
        char c2 = s.length() > 1 ? s.charAt(1) : ' ';
        
        String k = new String(c + "" + c2).trim();
        
        // II becomes I, for instance
        if (!h.containsKey(k)) k = k.substring(0, 1);
        
        return h.get(k) + romanToInt(s.substring(k.length(), s.length()));
    }
}