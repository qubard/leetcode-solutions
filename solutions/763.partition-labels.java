class Solution {
    public List<Integer> partitionLabels(String S) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            map.put(c, i);
        } // store max indexes for each char
        ArrayList<Integer> sol = new ArrayList<>();
        // From left to right keep active set of chars not at max index
        int lastIndex = 0;
        // you can also not use a set but instead use an integer representing the last end position
        int j = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int ind = map.get(c);
            j = Math.max(ind, j);
            if (i == j) {
                sol.add(i - lastIndex + 1);
                lastIndex = i + 1;
            }
        }
        return sol;
    }
}