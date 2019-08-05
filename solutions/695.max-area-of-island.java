class Solution {
    public class QuickUnion
    {
        private int[] id;
        private int[] dp;
        public QuickUnion(int N)
        {
            id = new int[N];
            dp = new int[N];
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
        
        public int unite(int p, int q)
        {
            int i = root(p);
            int j = root(q);
            id[i] = j;
            if (i != j) // they were not previously connected
                dp[j] += dp[i];
            return dp[j];
        }
        
        public int getDP(int index) {
            return dp[root(index)];
        }
        
        public void setDP(int index, int v) {
            dp[index] += 1;
        }
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        int sol = 0;
        QuickUnion union = new QuickUnion(grid.length * grid[0].length);
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                int ind = y * grid[0].length + x;
                if (grid[y][x] == 1) {
                    if (sol == 0) sol = 1;
                    union.setDP(ind, 1);
                    if (y == 0) {
                        if (x - 1 >= 0) {
                            if (grid[y][x - 1] == 1) {
                                sol = Math.max(union.unite(ind, ind - 1), sol);
                            }
                        }
                    } else if (x == 0) {
                        if (y - 1 >= 0) {
                            if (grid[y - 1][x] == 1) {
                                sol = Math.max(union.unite(ind, (y - 1) * grid[0].length + x), sol);
                            }
                        }
                    } else {
                        if (grid[y - 1][x] == 1) {
                            sol = Math.max(union.unite(ind, (y - 1) * grid[0].length + x), sol);
                        }
                        
                        if (grid[y][x - 1] == 1) {
                            sol = Math.max(union.unite(ind, y * grid[0].length + x - 1), sol);
                        }
                    }
                }
            }
        }
        return sol;
    }
}