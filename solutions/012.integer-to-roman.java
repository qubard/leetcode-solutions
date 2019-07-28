class Solution {
    
    static HashMap<Integer, String> h;
    
    static ArrayList<Integer> vals;
    
    static {
        h = new HashMap<Integer, String>();
        h.put(9, "IX");
        h.put(4, "IV");
        h.put(400, "CD");
        h.put(900, "CM");
        h.put(40, "XL");
        h.put(90, "XC");
        h.put(10, "X");
        h.put(5, "V");
        h.put(50, "L");
        h.put(500, "D");
        h.put(1000, "M");
        h.put(100, "C");
        h.put(1, "I");
        
        vals = new ArrayList<Integer>();
        vals.addAll(h.keySet());
        Collections.sort(vals, Collections.reverseOrder());
    }
    
    
    public String intToRoman(int num) {
        if (h.containsKey(num)) {
            return h.get(num);
        }
        
        int closest = vals.stream().filter(x -> num - x > 0).findFirst().orElse(-1);
        return h.get(closest) + intToRoman(num - closest);
    }
}