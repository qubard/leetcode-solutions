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
        
        public int distinct(Set<Integer> ignore) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < id.length; i++) { 
                int ind = root(i);
                if (!ignore.contains(ind))
                    set.add(root(i));
            }
            return set.size();
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        
        QuickUnion union = new QuickUnion(grid.length * grid[0].length);
        Set<Integer> ignore = new HashSet<>();
        
        // BFS here is way better, because you can only reach a node
        // from another node in a BFS traversal if they're connected.
        // So the algo would be just to start a BFS traversal, mark nodes as visited,
        // once the set is empty increment count, and continue to do that looking for unvisited 
        // nodes with '1'
        
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                int ind = y * grid[0].length + x;
                if (grid[y][x] == '1') {
                    if (y == 0) {
                        if (x > 0) {
                            if (grid[y][x - 1] == '1') {
                                union.unite(ind, ind - 1);
                            }
                        }
                    } else if(x == 0) {
                        if (grid[y - 1][x] == '1') {
                            union.unite(ind, (y - 1) * grid[0].length + x);
                        }
                    } else {
                        if (grid[y][x - 1] == '1') {
                            union.unite(ind, ind - 1);
                        }
                        
                        if (grid[y - 1][x] == '1') {
                            union.unite(ind, (y - 1) * grid[0].length + x);
                        }
                    }
                } else {
                    ignore.add(ind);
                }
            }
        }
        return union.distinct(ignore);
    }
}