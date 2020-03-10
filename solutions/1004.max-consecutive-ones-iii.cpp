class Solution {
public:
    int longestOnes(vector<int>& A, int K) {
        
        int l = 0;
        int r = 0;
        int c = 0;
        int s = 0;
        while (r < A.size()) {
            if (A[r] == 0) {
                c++;
            }
            s = max(r - l, s);
            r++;
            
            while (c > K) {
                if (A[l] == 0) c--;
                l++;
            }
        }
        
        if (c <= K) {
            s = max(r-l, s);
        }
        
        return s;
    }
};