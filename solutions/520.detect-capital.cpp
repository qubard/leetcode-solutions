class Solution {
public:
    bool capital(char c) {
        return c >= (int)'A' && c <= (int)'Z';
    }
    
    bool detectCapitalUse(string word) {
        int c = 0;
        for (int i = 0; i < word.length(); i++) {
            if (capital(word[i])) {
                c++;
            }
        }
        
        
        return c == 0 || (c == 1 && capital(word[0])) || c == word.size();
    }
};