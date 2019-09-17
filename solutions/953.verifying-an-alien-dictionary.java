class Solution {
    HashMap<Character, Integer> ord = new HashMap<>();
        
    public int compare(String a, String b) {
        if (a.equals(b)) return 0;
        
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            int ordA = ord.get(a.charAt(i));
            int ordB = ord.get(b.charAt(i));
            if (ordA != ordB) {
                return ordA - ordB;
            }
        }
        
        return a.length() > b.length() ? 1 : -1;
    }
    
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) {
            ord.put(order.charAt(i), i);
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            if (compare(words[i], words[i + 1]) > 0) {
                return false;
            }
        }
        
        return true;
    }
}