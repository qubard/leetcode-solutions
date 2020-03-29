class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        
        vector<vector<int>> res;
        int i = 0;
        // if we have duplicates 
        // for 2sum, 3sum and 4sum outer loop we skip over
        // until the next non-duplicate to avoid doing duplicate work
        while (i < nums.size()) {
            int j = i + 1;
            while (j < nums.size()) {
                int targ = target - nums[i] - nums[j];
                int left = j + 1;
                int right = nums.size() - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];

                    if (sum > targ) {
                        right--;
                    } else if (sum < targ) {
                        left++;
                    } else {
                        res.push_back({nums[i], nums[j], nums[left], nums[right]});
                        // skip duplicates
                        while (left + 1 < nums.size() && nums[left] == nums[left + 1]) left++;
                        left++;
                    }
                }
                // skip duplicates
                while (j + 1 < nums.size() && nums[j] == nums[j + 1]) j++;
                j++;
            }
            // skip duplicates
            while (i + 1 < nums.size() && nums[i] == nums[i + 1]) i++;
            i++;
        }
        return res;
    }
};