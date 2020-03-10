class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int sol = 0;
        int z1 = 0;
        int z2 = -1;
        
        // We keep track of the positions of two
        // zeros and flip either z1 or z2
        // depending on if z1 is set or z2 is set
        // If both are set we just consider the sequence from z1 to z2
        // and flip z2
        
        for (int i = 0; i < nums.size(); i++) {
            // Update z1 and z2
            // Same as below except z1 lags behind
            if (nums[i] == 0) {
                z1 = z2 + 1;
                z2 = i;
            } 
            
            sol = max(i - z1 + 1, sol);
        }
        return sol;
    }
};

/*

class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int sol = 0;
        int z1 = -1;
        int z2 = -1;
        
        // We keep track of the positions of two
        // zeros and flip either z1 or z2
        // depending on if z1 is set or z2 is set
        // If both are set we just consider the sequence from z1 to z2
        // and flip z2
        
        for (int i = 0; i < nums.size(); i++) {
            // Update z1 and z2
            if (nums[i] == 0) {
                if (z1 == -1) {
                    z1 = i;
                } else {
                    if (z2 == -1) {
                        z2 = i;
                    } else {
                        z1 = i;
                    }
                }
            } 
            
            if (z2 == -1) {
                sol = max(i + 1, sol);
            } else {
                sol = max(i - z1, sol);
            }
        }
        return sol;
    }
};
*/