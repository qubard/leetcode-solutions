class Solution {
    
    // My big mistake with this problem was not checking if dist.get(curr) + 1 == dist.get(next)
    // after doing the BFS to get the distances along the shortest path from beginWord to endWord.
    // Other than that it's simply BFS then DFS to get the paths. We do BFS first because we can only
    // get more than one shortest path with DFS, but BFS helps us optimize the DFS traversal anyway

    HashMap<String, List<String>> edges = new HashMap<>();
    Set<List<String>> sol = new HashSet<>();
    
    public void dfs(String curr, String end, int length, ArrayList<String> lis) {
        if (curr.equals(end)) {
            ArrayList<String> cpy = new ArrayList<>();
            for (String s : lis) {
                cpy.add(s);
            }
            sol.add(cpy);
            return;
        }
        
        if (edges.containsKey(curr)) {
            for (String neighbor : edges.get(curr)) {
                // Prevents us from going backwards/cycling/not taking the shortest path
                if (dist.get(neighbor) == dist.get(curr) + 1) {
                    lis.add(neighbor);
                    dfs(neighbor, end, length + 1, lis);
                    lis.remove(lis.size() - 1);
                }
            }
        }
    }
    
    HashMap<String, Integer> dist = new HashMap<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>();
        for (String s : wordList) wordSet.add(s);
        
        wordList.add(beginWord);
        for (String s : wordList) { 
            for (int idx = 0; idx < s.length(); idx++) { 
                for (int i = 0; i <= 25; i++) {
                    StringBuilder sb = new StringBuilder(s);
                    sb.setCharAt(idx, (char)((int)'a' + i));
                    if (wordSet.contains(sb.toString()) && !sb.toString().equals(s)) {
                        if (!edges.containsKey(s))
                            edges.put(s, new ArrayList<String>());
                        edges.get(s).add(sb.toString());
                    }
                }
            }
        }
        wordList.remove(beginWord);
        
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        dist.put(beginWord, 0);
        
        int minDist = Integer.MAX_VALUE;
        
        while (!queue.isEmpty()) {
            String curr = queue.remove();
            
            if (!curr.equals(endWord) && edges.containsKey(curr)) {
                for (String neighbor : edges.get(curr)) {
                    if (!dist.containsKey(neighbor)) {
                        dist.put(neighbor, dist.get(curr) + 1);
                        queue.add(neighbor);
                    } else {
                        if (dist.get(neighbor) > dist.get(curr) + 1) {
                            dist.put(neighbor, dist.get(curr) + 1);
                            queue.add(neighbor);
                        }
                    }
                }
            }
        }
        
        if (dist.containsKey(endWord)) {
            ArrayList<String> lis = new ArrayList<>();
            lis.add(beginWord);
            dfs(beginWord, endWord, 0, lis);
        }
        
        return new ArrayList<>(sol);
    }
}