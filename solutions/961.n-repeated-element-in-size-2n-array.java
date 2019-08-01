class Solution {
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> m = new HashMap<>();
        
        for (Integer i : A) {
            m.put(i, m.getOrDefault(i, 0) + 1);
        }
        
        for (Integer i : A) {
            if (m.get(i) == A.length / 2) 
                return i;
        }
        return -1;
    }
}
