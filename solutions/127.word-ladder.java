class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> intermediate = new HashMap<>(); // d*g, *og, etc (list of words which match)
        wordList.forEach(word -> {
           for (int i = 0; i < word.length(); i++) {
               String s = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
               if (!intermediate.containsKey(s)) {
                   intermediate.put(s, new ArrayList<>());
               }
               intermediate.get(s).add(word);
           }
        });
        
        LinkedList<String> queue = new LinkedList<>(); // BFS queue
        HashSet<String> visited = new HashSet<>();
        queue.add(beginWord);
        HashMap<String, Integer> distance = new HashMap<>();
        distance.put(beginWord, 1);
        
        // Given a word like hot, we know we look at *ot, h*t, and ho* then find all of the other words we can make
        // by changing the character there
        while (!queue.isEmpty()) {
            String current = queue.remove();
            if (current.equals(endWord)) {
                return distance.get(current);
            }
            
            visited.add(current);
            for (int i = 0; i < current.length(); i++) {
               String s = current.substring(0, i) + "*" + current.substring(i + 1, current.length());
               // Lookup the word, get its adjacent nodes
               if (intermediate.containsKey(s)) {
                   List<String> neighbors = intermediate.get(s);
                   neighbors.forEach(neighbor -> {
                      if (!visited.contains(neighbor)) {
                          queue.add(neighbor);
                          int dist = distance.getOrDefault(current, 0) + 1;
                          if (!distance.containsKey(neighbor) || dist < distance.get(neighbor)) {
                            distance.put(neighbor, dist);
                          }
                      }
                   });
               }
           }
        }
        
        return 0;
    }
}