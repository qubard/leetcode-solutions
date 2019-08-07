class Solution {
    public int hammingDistance(int x, int y) {
        int n = (int) (Math.log(Math.max(x, y)) / Math.log(2)) + 1;
        int sol = 0;
        for (int i = 0; i < n; i++) {
            int mask = 1 << i;
            int b1 = x & mask;
            int b2 = y & mask;
            if (b1 != b2) {
                sol++;
            }
        }
        return sol;
    }
}