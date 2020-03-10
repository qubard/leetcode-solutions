class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        // The idea is to search for 1
        // then 2, then 3.. 
        // but do this in constant time..
        // we can use the original array to assist this
        // put negative arr[nums[i]], if this position is set to < 0 then we know
        // it's present in the array
        // then we do an O(N) scan and search for the missing number
        // just make sure the numbers are within the bounds of the array
        
        // The only tricky parts (consider all edge cases)
        // All out of bounds values become 1, or if they are 0
        // But this means we can't detect the value 1
        // so we check for it manually
        // Making them -1 is not a good idea because then when
        // we try to negate that index we have no idea what to do
        // for unaffected indexes. Does this mean there is a contained value there?
        // It is better to initialize all of them to be > 0 like 1
        // Finally, the max value gets mapped to index 0 in case we used all of the space
        // of the array
        
        if (nums.size() == 0) {
            return 1;
        }
        
        bool missing_one = true;
        for (int i : nums) {
            if (i == 1) {
                missing_one = false;
            }
        }
        
        if (missing_one) {
            return 1;
        }
        
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] <= 0 || nums[i] > nums.size()) {
                nums[i] = 1;
            }
        }

        for (int i = 0; i < nums.size(); i++) {
            int v = abs(nums[i]);
            if (v > 0 && v < nums.size()) {
                nums[v] = abs(nums[v]) * -1;
            } else if (v == nums.size()) {
                nums[0] = -1;
            }
        }

        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] >= 1) {
                return i;
            }
        }
                
        if (nums[0] >= 1) {
            return nums.size();
        }
        
        // When [1,2,3, ..., N]
        return nums.size() + 1;
    }
};  