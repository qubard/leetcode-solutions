class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        // use heap sort by start times, check if end of prev is > start of curr
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] a : intervals) pq.add(a);
        Integer start = null;
        while (!pq.isEmpty()) {
            int[] a = pq.remove();
            if (start == null) {
                start = a[1];
            } else if(a[0] < start) {
                return false;
            } else if(a[0] > start) {
                start = a[1];
            }
        }
        return true;
    }
}