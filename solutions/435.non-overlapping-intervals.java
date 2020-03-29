class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        
        int removed = 0;
        int[] prev = null;
        
        for (int[] curr : intervals) {
            if (prev == null) {
                prev = curr;
            } else if (prev[1] > curr[0] && curr[1] <= prev[1]) {
                // inside
                // Remove the larger endpoint
                if (curr[1] < prev[1]) {
                    prev = curr;
                }
                removed++; 
            } else if (prev[1] > curr[0]) {
                // inside partly
                removed++;
            } else {
                // not inside
                prev = curr;
            }
        }
        
        return removed;
    }
}