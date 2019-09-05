class Trie {
    
    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        public TrieNode child(char c) {
            return children.getOrDefault(c, null);
        }
        public void setChild(char c, TrieNode node) {
            children.put(c, node);
        }
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
            TrieNode child = curr.child(c);
            if (child != null) {
                curr = child;
            } else {
                // index i does not contain a child, insert a new node for the character
                curr.setChild(c, new TrieNode());
                curr = curr.child(c);
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
            TrieNode child = curr.child(c);
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
            TrieNode child = curr.child(c);
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
    public boolean dfs(Trie trie, char[][] board, int row, int col, String word) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        
        char c = board[row][col];
            
        if (c == ' ') {
            return false;
        }
        
        // No point visiting neighbors, nothing starts with it
        if (!trie.startsWith(word)) {
            return false;
        }
        
        word = word + c;
        
        if (trie.search(word)) {
            return true;
        }
        
        board[row][col] = ' ';
        boolean ret = dfs(trie, board, row + 1, col, word) || dfs(trie, board, row - 1, col, word) || dfs(trie, board, row, col + 1, word) || dfs(trie, board, row, col - 1, word);
        board[row][col] = c;
        return ret;
    }
    
    public boolean exist(char[][] board, String word) {
        // Run dfs on each tile
        Trie trie = new Trie();
        trie.insert(word);
        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (dfs(trie, board, row, col, "")) {
                    return true;
                }
            }
        }
        return false;
    }
}

