class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int[] nodes = new int[numCourses];
        int[] indegree = new int[numCourses];
        
        int visited = 0;
        // check if there exist cycles on a dag
        boolean[][] edges = new boolean[numCourses][numCourses];
        
        for (int i = 0; i < prerequisites.length; i++) {
            int[] preq = prerequisites[i];
            int src = preq[0];
            int dest = preq[1];
            indegree[dest]++;
            edges[src][dest] = true;
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                deq.add(i);
            }
        }
        
        while (!deq.isEmpty()) {
            int vertex = deq.remove();
            visited++;
            for(int i = 0; i < numCourses; i++) {
                if (edges[vertex][i]) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        deq.add(i);
                    }
                    edges[vertex][i] = false;
                }
            }
        }
        
        return visited == numCourses;
    }
}