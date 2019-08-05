class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] mappings = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> unique = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(mappings[(int)word.charAt(i) - 97]);
            }
            if (!unique.contains(sb.toString())) {
                unique.add(sb.toString());
            }
        }
        return unique.size();
    }
}