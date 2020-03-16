class Solution {
public:
    int change(int amount, vector<int>& coins) {
       int dp[amount + 1][coins.size() + 1];
        
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j <= coins.size(); j++) {
                dp[i][j] = i == 0 ? 1 : 0;
            }
        }
        
        for (int a = 1; a <= amount; a++) {
            for (int i = coins.size() - 1; i >= 0; i--) {
                if (a - coins[i] >= 0) {
                    dp[a][i] += dp[a - coins[i]][i];
                }
                if (i + 1 < coins.size()) {
                    dp[a][i] += dp[a][i + 1];
                }
            }
        }
        
        return dp[amount][0];
    }
    
    int recurse(int amount, int i, vector<int>& coins) {
        if (amount == 0) return 1;
        if (amount < 0) return 0;
        if (i >= coins.size()) return 0;
        int s = 0;
        // Compute bottom up first
        s = ((amount - coins[i] >= 0) ? recurse(amount - coins[i], i, coins) : 0) + recurse(amount, i + 1, coins);
            
        return s;
    }
};