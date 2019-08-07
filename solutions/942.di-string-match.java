class Solution {
    public int[] diStringMatch(String S) {
        int[] sol = new int[S.length() + 1];
        
        int min = 0;
        int max = min;
        int smallest = 0;
        
        sol[0] = 0;
        
        for (int i = 1; i < sol.length; i++) {
            char c = S.charAt(i - 1);
            if (c == 'I') {
                max = max + 1;
                sol[i] = max;
            } else if (c == 'D') {
                min = min - 1;
                sol[i] = min;
            }
            smallest = Math.min(sol[i], smallest);
        }
        
        for (int i = 0; i < sol.length; i++) sol[i] += Math.abs(smallest);
        
        return sol;
    }
}