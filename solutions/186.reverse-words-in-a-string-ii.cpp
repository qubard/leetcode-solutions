class Solution {
public:
    void reverseWords(vector<char>& s) {
        int startIndex = -1;
        
        reverse(s.begin(), s.end());
        
        for (int i = 0; i <= s.size(); i++) {
            if (i == s.size() || s[i] == ' ') {
                // (startIndex, i - 1) is a word
                int len = (i - startIndex) / 2;
                int j = 0;
                while (j < len) {
                    char c = s[startIndex+j];
                    s[startIndex+j] = s[i-j-1];
                    s[i-j-1] = c;
                    j++;
                }
                startIndex = -1;
            } else if (startIndex == -1) {
                startIndex = i;
            }
        }
    }
};