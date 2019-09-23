class Solution {
    ArrayList<String> sol = new ArrayList<>();
    public void generatePalindromes(HashMap<Character, Integer> map, String s, String curr) { 
        int total = 0;
        for (Character c : map.keySet()) {
            int count = map.get(c);
            total += count;
            if (count > 0) {
                if (count % 2 == 0) {
                    int prev = map.get(c);
                    map.put(c, map.get(c) - 2);
                    generatePalindromes(map, s, c + curr + c);
                    map.put(c, prev);
                }

                if(count % 2 == 1 && curr.isEmpty()) { // count is 1
                    int prev = map.get(c);
                    map.put(c, prev - 1);
                    generatePalindromes(map, s, c + "");
                    map.put(c, prev);
                }
            }
        }
        
        if (total == 0) {
            // Add solution, return
            sol.add(curr);
            return;
        }
    }
    
    public List<String> generatePalindromes(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // If there's more than one character with odd frequency return (fail)
        int count = 0;
        for (Character c : map.keySet()) {
            if (map.get(c) % 2 == 1) count++;
            if (count > 1) return sol;
        }
        
        generatePalindromes(map, s, "");
        return sol;
    }
}