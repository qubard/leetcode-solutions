class Solution {
public:
    bool stoneGame(vector<int>& piles) {
        int dp[piles.size() + 1][piles.size() + 1];
        for (int i = 0; i <= piles.size(); i++) {
            for (int j = 0; j <= piles.size(); j++) {
                dp[i][j] = 0;
            }
        }
        
        
        for (int s = 0; s < piles.size(); s++) {
            for (int i = 0; s + i < piles.size(); i++) {
                int j = s + i;
                if (s == 0) {
                    dp[i][j] = piles[i];
                } else {
                    // s > 0
                    int parity = (j-i) % 2; // 0 -> Alex, 1 -> Lee
                    int a = (parity == 0 ? piles[i]: -piles[i]) + dp[i + 1][j];
                    int b = (parity == 0 ? piles[j]: -piles[j]) + dp[i][j - 1];
                    dp[i][j] = max(a,b);
                }
            }
        }
        
        return dp[0][piles.size() - 1] > 0;
    }
};

// return true is also another solution
// because Alex can always take the odd or even 
// piles and one sum has to be > than the other