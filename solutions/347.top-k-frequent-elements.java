class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) { 
            int v = nums[i];
            freq.put(v, freq.getOrDefault(v, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));
        
        for (int i : freq.keySet()) {
            pq.add(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        ArrayList<Integer> sol = new ArrayList<>();
        while (!pq.isEmpty()) sol.add(pq.poll());
        
        return sol;
    }
}