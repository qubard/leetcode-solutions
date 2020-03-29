class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        
        vector<vector<int>> res;
        int i = 0;
        while (i < nums.size()) {
            int target = -nums[i];
            int left = i + 1;
            int right = nums.size() - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    res.push_back({nums[i], nums[left], nums[right]});
                    int t = nums[left]; // skip duplicates
                    while (left < nums.size() && nums[left] == t) left++;
                }
            }
            // skip duplicates starting at i (we don't want to repeat the same work)
            while (i + 1 < nums.size() && nums[i] == nums[i + 1]) i++;
            i++;
        }
        return res;
    }
};