class Solution {
    class QuickUnion {
        
        private int id[];
        
        public QuickUnion(int N) {
            id = new int[N];
            for (int i = 0; i < id.length; i++) id[i] = i;
        }
        
        public int root(int i) {
            while (i != id[i]) i = id[i];
            return i;
        }
                
        public boolean find(int p, int q)
        {
            return root(p) == root(q);
        }
        
        public void unite(int p, int q) {
            int i = root(p);
            int j = root(q);
            id[i] = id[j];
        }
        
        public int distinct() {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < id.length; i++) { 
                set.add(root(i));
            }
            return set.size();
        }
    }
    
    public int countComponents(int n, int[][] edges) {
        QuickUnion union = new QuickUnion(n);
        
        for (int[] edge: edges) {
            union.unite(edge[0], edge[1]);
        }
        
        return union.distinct();
    }
}