class Solution {
    
    public Integer sol = null;
    
    public int[][] distance;
    
    public boolean valid(int[][] maze, int x, int y) {
        if (x < 0 || x >= maze[0].length || y < 0 || y >= maze.length) return false;
        return maze[y][x] == 0;
    }
    
    public void dfs(int[][] maze, int[] start, int[] dest, int cost) {
        int dir[][] = {
            { 0, 1}, { 0, -1}, {-1, 0}, {1, 0}
        };
        
        int x = start[1];
        int y = start[0];
        
        if (x == dest[1] && y == dest[0]) {
            // We found a solution, update it
            sol = sol == null ? cost : Math.min(cost, sol);
            return;
        }
        
        // I should have pruned the path by comparing the current distance, then this works
        // And we don't need a visited array (since monotonically increasing distances occur in loops)
        
        for (int[] move : dir) {
            int i = 0;
            int cx = x;
            int cy = y;
            while (valid(maze, x + move[0] * (i + 1), y + move[1] * (i + 1))) {
                i++;
            }
            cx = x + move[0] * i;
            cy = y + move[1] * i;
            
            // cx, cy is a valid posiiton
            if (valid(maze, cx, cy) && (cx != x || cy != y) && distance[cy][cx] > cost + i) {
                distance[cy][cx] = cost + i;
                dfs(maze, new int[]{cy, cx}, dest, cost + i);
            }
        }
    }
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        distance = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int y = 0; y < maze[i].length; y++) {
                distance[i][y] = Integer.MAX_VALUE;
            }
        }
        distance[start[0]][start[1]] = 0;
        dfs(maze, start, destination, 0);
        return sol == null ? -1 : sol;
    }
}