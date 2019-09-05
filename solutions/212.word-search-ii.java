class Trie {
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean end;
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        int i = 0;
        while (i < word.length()) {
            char c = word.charAt(i);
            TrieNode child = curr.children[c - 'a'];
            if (child != null) {
                curr = child;
            } else {
                // index i does not contain a child, insert a new node for the character
                curr.children[c - 'a'] = new TrieNode();
                curr = curr.children[c - 'a'];
            }
            i++;
        }
        // The current node dictates the end of a word
        curr.end = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        int i = 0;
        while (i < word.length()) {
            char c = word.charAt(i);
            TrieNode child = curr.children[c - 'a'];
            if (child != null) {
                curr = child;
            } else {
                return false;
            }
            i++;
        }
        
        return curr.end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        int i = 0;
        while (i < prefix.length()) {
            char c = prefix.charAt(i);
            TrieNode child = curr.children[c - 'a'];
            if (child != null) {
                curr = child;
            } else {
                return false;
            }
            i++;
        }
        return true;
    }
}

class Solution {
    List<String> sol = new ArrayList<String>();
    HashSet<String> seen = new HashSet<>();
    public void dfs(Trie trie, char[][] board, int row, int col, String word) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        
        char c = board[row][col];
            
        if (c == ' ') {
            return;
        }
        
        // No point visiting neighbors, nothing starts with it
        if (!trie.startsWith(word)) {
            return;
        }
        
        word = word + c;
        
        if (!seen.contains(word) && trie.search(word)) {
            sol.add(word);
            seen.add(word);
        }
        
        board[row][col] = ' '; // avoid revisiting the node
        dfs(trie, board, row + 1, col, word);
        dfs(trie, board, row - 1, col, word);
        dfs(trie, board, row, col + 1, word);
        dfs(trie, board, row, col - 1, word);
        board[row][col] = c;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) trie.insert(word);
        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                dfs(trie, board, row, col, "");
            }
        }
        return sol;
    }
}