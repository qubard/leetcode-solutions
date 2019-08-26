class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
    
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        StringBuilder[] strs = new StringBuilder[s.length()  + 1];
        for (int i = 0; i < strs.length; i++) strs[i] = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (freq.containsKey(c)) {
                int qty = freq.get(c);
                for (int j = 0; j < qty; j++)
                    strs[qty].append(c);
                freq.remove(c);
            }
        }
        
        // Instead of sorting just go down from the maximum frequency which is s.length()
        StringBuilder ret = new StringBuilder();
        for (int i = s.length(); i >= 1; i--) {
            StringBuilder str = strs[i];
            if (str.length() > 0) {
                ret.append(str.toString());
            }
        }
        return ret.toString();
    }
}