class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((b, a) -> {
            int x = points[a][0];
            int x2 = points[b][0];
            int y = points[a][1];
            int y2 = points[b][1];
            return (x * x + y * y) - (x2 * x2 + y2 * y2);
        });
        
        for (int i = 0; i < points.length; i++) {
            pq.add(i);
            // maxheap, so we remove all the big values and keep k lowest values
            if (pq.size() > K) pq.poll();
        }
        
        int[][] ret = new int[K][2];
        for (int i = 0; i < K; i++) {
            int closest = pq.poll();
            int x = points[closest][0];
            int y = points[closest][1];
            ret[i][0] = x;
            ret[i][1] = y;
        }
        return ret;
    }
}