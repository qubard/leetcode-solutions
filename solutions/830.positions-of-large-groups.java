class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        int i = 0;
        char c = S.charAt(i);
        ArrayList<List<Integer>> sol = new ArrayList<>();
        for (int j = 0; j < S.length(); j++) {
            if (j == S.length() - 1 || S.charAt(j) != S.charAt(j + 1)) {
                int dist = j - i + 1;
                if (dist >= 3) {
                    ArrayList<Integer> a = new ArrayList<>();
                    a.add(i);
                    a.add(j);
                    sol.add(a);
                }
                i = j + 1;
            }
        }
        return sol;
    }
}