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
            for (int i = 0; i < id.length; i++) { 
                set.add(root(i));
            }
            return set.size();
        }
    }
    
    public int findCircleNum(int[][] M) {
        // N^2 edges total to look at for triangles
        QuickUnion union = new QuickUnion(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union.unite(i, j);
                }
            }
        }
        
        return union.distinct();
    }
}