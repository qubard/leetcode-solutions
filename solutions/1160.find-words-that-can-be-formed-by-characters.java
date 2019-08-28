class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> freq = new HashMap<>(); // Frequency of each character in chars
        for (char c: chars.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        // Now I want the frequency of each word, and I go over each char in the word and check against map to see
        // if the char we have's freq is <= the map's availability
        int sum = 0;
        for (String s : words) {
            HashMap<Character, Integer> freq2 = new HashMap<>();
            for (char c: s.toCharArray()) {
                freq2.put(c, freq2.getOrDefault(c, 0) + 1);
            }
            
            boolean ok = true;
            for (char c: s.toCharArray()) {
                if (!freq.containsKey(c) || (freq.containsKey(c) && freq.get(c) < freq2.get(c))) {
                    ok = false;
                    break; // Cannot possibly fit
                }
            }
            
            if (ok) sum += s.length();
        }
        
        return sum;
    }
}