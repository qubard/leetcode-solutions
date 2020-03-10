class Solution {
public:
    #define SWAP(x, y, T) do { T SWAP = x; x = y; y = SWAP; } while (0)
    int minSwapsCouples(vector<int>& row) {
        // Observe that there is at most N-1 swaps
        // For each group of 2 we can fix the group
        // by just swapping out one element in it with every other group
        // and continue that way
        // We fix at least one couple each time and in the case it's possible
        // to fix two couples they both get fixed in one swap (and that's the only way)
        
        // So really this is a simple greedy solution
        int sol = 0;
        for (int i = 0; i < row.size(); i += 2) {
            // Group starting at i
            int a = row[i];
            int a2 = row[i + 1];
            int a_ = row[i] % 2 == 0 ? a + 1 : a - 1; // row[i] ^ 1
            int a2_ = row[i + 1] % 2 == 0 ? a2 + 1 : a2 - 1; // row[i + 1] ^ 1
            // It's true you don't have to check a2, a2_ only a, a_ 
            // Because it should be by definition somewhere else in the array
            // Also neat trick: x ^ 1 is x's partner
            // You can also make this O(N) time with O(N) space with a hashmap instead of the second loop
            // since there are no duplicates values can be mapped to their indexes
            // and when swapped replaced then looked up in constant time
            
            for (int j = i + 2; j < row.size(); j += 2) {
                // If we find either a or a2s pair swap it
                int b = row[j];
                int b2 = row[j + 1];
                if (b == a_) {
                    // Swap row[j] with row[i + 1]
                    // Now the group `i` is valid
                    sol++;
                    SWAP(row[j], row[i+1], int);
                    break;
                } else if (b == a2_) {
                    // Swap row[j] with row[i]
                    sol++;
                    SWAP(row[j], row[i], int);
                    break;
                } else if (b2 == a_) {
                    // Swap row[j + 1] with row[i + 1]
                    sol++;
                    SWAP(row[j+1], row[i+1], int);
                    break;
                } else if (b2 == a2_) {
                    // Swap row[j + 1] with row[i]
                    sol++;
                    SWAP(row[j+1], row[i], int);
                    break;
                }
            }
        }
        
        return sol;
    }
};