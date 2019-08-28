class Solution {
    public int orangesRotting(int[][] grid) {
        boolean ok = true;
        int n = 0;
        while (ok) {
            ok = false;
            int[][] copy = new int[grid.length][grid[0].length];
            for (int y = 0; y < grid.length; y++) {
                for (int x = 0; x < grid[y].length; x++) {
                    copy[y][x] = grid[y][x];
                    int val = grid[y][x];
                    if (val == 1) {
                        // not rotting, at least 1 fresh orange
                        // check adjacent
                        boolean up = y - 1 >= 0 ? grid[y - 1][x] == 2 : false;
                        boolean left = x - 1 >= 0 ? grid[y][x - 1] == 2 : false;
                        boolean right = x + 1 < grid[y].length ? grid[y][x + 1] == 2 : false;
                        boolean down = y + 1 < grid.length ? grid[y + 1][x] == 2 : false;
                        boolean rot = up || down || left || right;
                        if (rot) {
                            copy[y][x] = 2; // rot the orange
                            ok = true;
                        }
                    }
                }
            }
            
            for (int y = 0; y < grid.length; y++) {
                for (int x = 0; x < grid[y].length; x++) {
                    grid[y][x] = copy[y][x];       
                }
            }
            
            if (!ok) break;
            n++;
        }
        
        boolean noFresh = true;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] == 1) {
                    noFresh = false;
                    break;
                }    
            }
        }
        
        return !noFresh ? -1 : n;
    }
}