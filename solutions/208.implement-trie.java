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

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */