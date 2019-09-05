class Solution {
    public int[][] highFive(int[][] items) {
        int[] count = new int[1001];
        int[] avg = new int[1001];
        HashMap<Integer, PriorityQueue<Integer>> pqs = new HashMap<>();
        
        for (int[] pair : items) {
            if (!pqs.containsKey(pair[0])) {
                pqs.put(pair[0], new PriorityQueue());
            }
            PriorityQueue<Integer> pq = pqs.get(pair[0]);
            pq.add(pair[1]);
            if (pq.size() > 5) {  
                pq.remove();
            }
        }
        
        int[][] sol = new int[pqs.keySet().size()][2];
        int j = 0;
        for (Integer id : pqs.keySet()) {
            PriorityQueue<Integer> pq = pqs.get(id);
            int sum = 0;
            int i = 0;
            while (!pq.isEmpty()) {
                sum += pq.poll();
                i++;
            }
            sol[j][0] = id;
            sol[j][1] = (int) (sum / i);
            j++;
        }
        return sol;
    }
}