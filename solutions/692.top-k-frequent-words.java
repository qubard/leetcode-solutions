class Solution {
    HashMap<String, Integer> freq = new HashMap<>();
       
    public int compare(String a, String b) {
        int f = freq.get(a) - freq.get(b);
        if (f == 0) 
            return b.compareTo(a);
        return f;
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        for (String word: words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> compare(a, b));
        
        for (String word: freq.keySet()) {
            pq.add(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        ArrayList<String> sol = new ArrayList<>();
        
        while (!pq.isEmpty()) {
            sol.add(pq.poll());
        }
        
        Collections.reverse(sol);
        
        return sol;
    }
}