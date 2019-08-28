class Solution {
    public int snakesAndLadders(int[][] board) {
        int N = board.length;
        // just use bfs? idk try it
        ArrayDeque<Integer> bfs = new ArrayDeque<>();
        int[] rows = new int[N * N + 1];
        int[] columns = new int[N * N + 1];
        
        int copy[][] = new int[N][N];
        
        int lastMax = 0;
        boolean reverse = false;
        for (int y = N - 1; y >= 0; y--) {
            lastMax = lastMax + N;
            for (int x = 1; x <= N; x++) {
                int id = lastMax - N + x;
                copy[y][reverse ? N - x : x - 1] = id;
                columns[id] = reverse ? N - x : x - 1;
                rows[id] = y;
            }
            reverse = !reverse;
        }
        
        bfs.add(1);
        int n = 0;
                    
        int[] dist = new int[N * N + 1];
        dist[1] = 0;
        
        for (int i = 2; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
        boolean visited[] = new boolean[N * N + 1];
        
        while (!bfs.isEmpty()) {
            int id = bfs.remove();
            if (id == N * N) {
                return dist[N * N];
            }
            
            int row = rows[id];
            int column = columns[id];
            
            for (int x = 1; x <= 6 && id + x <= N * N; x++) {
                int target = id + x;
                if (!visited[target]) {
                    int tr = rows[target];
                    int tc = columns[target];

                    if (board[tr][tc] != -1) {
                         // snake or ladder
                        int jump = board[tr][tc];
                        // add the tile it goes to
                        dist[jump] = Math.min(dist[jump], dist[id] + 1);
                        bfs.add(jump);
                    } else {
                        dist[id + x] = Math.min(dist[id + x], dist[id] + 1);
                        bfs.add(id + x);
                    }
                    visited[id + x] = true;
                }
            }
        }

        return -1;
    }
}