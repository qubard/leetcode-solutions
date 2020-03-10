class Solution {
public:
    int maxA(int N) {
        // Cost of doubling (ctrl a, ctrl c, ctrl v) is 3 -> increases # chars by 2*chars
        // Cost of adding A is 1 -> increases # chars by 1
        // If we write out best[i] we can compute the max value based on the previous values being multiplied 
        // for k - x - 1 steps
        vector<int> best(N + 1, 0);

        // N >= 1
        
        if (N <= 5) { 
            return N;
        }
        
        best[1] = 1;
        best[2] = 2;
        best[3] = 3;
        best[4] = 4;
        best[5] = 5;
        
        /*
        1,1
        2,2
        3,3
        4,4,b=3
        5,5,b=3
        6,6,b=3
        7,9,b=5
        8,12
        9,16
        20
        27
        36
        48
        64
        81

        best[k] = if k - x >= 2 ? best[x] * ((k-(x + 2) + 1)) 
        k-x-2+1 = k-x-1

        k-(x + 2) + 1 >= 1
        k-x-1 >= 1
        k-x >= 2
        k >= 2 + x
        2 + x <= k
        x <= k - 2
        x < k - 1

        -> O(N^2)
        */
        
        
        for (int k = 6; k <= N; k++) {
            best[k] = max(best[k - 1] + 1, best[k]);
            for (int x = 1; x <= k - 3; x++ ) {
                if (x < k - 1) {
                    best[k] = max(best[k], best[x] * (k-x-1));
                }
            }
        }
        
        return best[N];
    }
    
    int helper(int N, int A, int B) {
        if (N == 0) {
            return A;
        }
        
        if (N < 0) return A;
        
        int sol = 0;
        sol = max(sol, helper(N - 2, A, A)); // CTRL A + CTRL C
        sol = max(sol, helper(N - 1, A + 1, B)); // PRESS A
        sol = max(sol, helper(N - 1, A + B, B)); // CTRL V
        
        
        // you can add in the # of characters at N - 3 for cost 3 ? (CTRL A, CTRL C, CTRL V) 
            
        // we cold use dijkstras algorithm? 
        
        // 1 -> 1
        // 2 -> 2
        // 3 -> 3
        // 6 -> 6
        // 12 -> 9
        // 24 -> 12
        // 48 -> 15
        // 96 -> 18
        // 
        // (50 - 12) / 3
        // When |A| >= 3 adding |A| characters costs 3
        // so we don't need the third variable
        return sol;
    }
};