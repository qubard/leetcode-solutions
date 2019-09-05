class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] out = new int[N + 1];
        int[] in = new int[N + 1];
        for (int[] edge : trust) {
            int src = edge[0];
            int dst = edge[1];
            out[src]++;
            in[dst]++;
        }
        
        for (int i = 1; i <= N; i++) {
            if (out[i] == 0 && in[i] == N - 1)
                return i;
        }
        return -1;
    }
}