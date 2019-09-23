class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        // Longest path from src in a DAG
        // or just do dfs and sum all the weights until the end yes
        // largest min path, run dfs
        // do dijkstras shortest path
        int weights[][] = new int[N + 1][N + 1];
        int dist[] = new int[N + 1];        
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                weights[i][j] = -1;
            }
        }
        
        for (int i = 0; i < times.length; i++) {
            int[] time = times[i];
            weights[time[0]][time[1]] = time[2];
        }
        
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
        dist[K] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> dist[a] - dist[b]);
        
        pq.add(K);
        
        for (int i = 1; i <= N; i++) {
            if (i != K) pq.add(i);
        }
        
        // If you have negative weights you need the visited set
        while (!pq.isEmpty()) {
            int u = pq.remove();
            
            for (int i = 1; i <= N; i++) {
                if (weights[u][i] >= 0 && i != u) {
                    int alt = dist[u] + weights[u][i];
                    if (alt < dist[i]) {
                        dist[i] = alt;
                        pq.remove(i);
                        pq.add(i);
                    }
                }
            }
        }
        
        int sol = -1;
        for (int i = 1; i <= N; i++) {
            if (i != K && dist[i] != Integer.MAX_VALUE) {
                sol = Math.max(dist[i], sol);
            }
            
            if (dist[i] == Integer.MAX_VALUE) return -1;
        }
        
        return sol;
    }
}