class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String, Integer> dominos = new HashMap<>(); // frequencies of each domino
        int sol = 0;
        for (int i = 0; i < dominoes.length; i++) {
            int[] domino = dominoes[i];
            String key = Math.min(domino[0], domino[1]) + "," + Math.max(domino[0], domino[1]);
            if (dominos.containsKey(key)) {
                sol += dominos.get(key);
                dominos.put(key, dominos.get(key) + 1);
            } else {
                dominos.put(key, 1);
            }
        }

        return sol;
    }
}