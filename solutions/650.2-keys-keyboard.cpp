class Solution {
public:
    int minSteps(int n) {
        vector<int> best(1001, 0);
        
        best[1] = 0;
        best[2] = 2;
        
        for (int x = 2; x <= n; x++) {
            for (int k = x - 1; k >= 1; k--) {
                if (x % k == 0) {
                    best[x] = (x-k)/k + best[k] + 1;
                    break;
                }
            }
        }
        
        return best[n];
    }
};