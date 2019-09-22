class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for (int stick : sticks) {
            pq.add(stick);
        }
        
        int first = 0;
        int second = 0;
        int cost = 0;
        while (!pq.isEmpty()) {
            first = pq.poll();
            if (pq.isEmpty()) return cost;
            second = pq.poll();
            cost += first + second;
            pq.add(first + second);
        }
        
        return cost;
    }
}