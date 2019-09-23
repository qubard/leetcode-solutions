class Solution {
    public class QuickUnion
    {
        private int[] id;
        
        public QuickUnion(int N)
        {
            id = new int[N];
            for (int i = 0; i < N; i++) id[i] = i;
        }
        
        private int root(int i)
        {
            while (i != id[i]) i = id[i];
            return i;
        }
        
        public boolean find(int p, int q)
        {
            return root(p) == root(q);
        }
        
        public void unite(int p, int q)
        {
            int i = root(p);
            int j = root(q);
            id[i] = j;
        }
        
        public int distinct() {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i < id.length; i++) { 
                set.add(root(i));
            }
            return set.size();
        }
    }
    
    public int minimumCost(int N, int[][] connections) {
        QuickUnion union = new QuickUnion(N + 1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int[] conn: connections) {
            pq.add(conn);
        }
        
        int cost = 0;
        while (!pq.isEmpty()) {
            int[] conn = pq.poll();
            if (!union.find(conn[0], conn[1])) {
                union.unite(conn[0], conn[1]);
                cost += conn[2];
            }
        }
        
        return union.distinct() != 1 ? -1 : cost;
    }
}