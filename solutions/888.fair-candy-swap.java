class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        HashSet<Integer> s = new HashSet<>();
        int sa = 0;
        int sb = 0;
        for (int i: A) { 
            sa += i;
            s.add(i);
        }
        
        for (int i: B) { 
            sb += i;
        }
        
        // Look for y = (sa - sb) / 2 + x
        // This equation comes from the observation S_a + x - y = S_b + y - x
        for (int x: B) {
            int y = (sa - sb) / 2 + x;
            if (s.contains(y)) {
                return new int[]{y, x};
            }
        }
        
        return new int[]{};
    }
}