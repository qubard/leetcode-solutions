class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> m;
        
        for (int i = 0; i < nums.size(); i++) {
            m.emplace(nums[i], i);
        }
        
        for (int i = 0; i < nums.size(); i++) {
            auto ff = m.find(target - nums[i]);
            if (ff != m.end() && m[target-nums[i]] != i) {
                return {i, m[target - nums[i]]};
            }
        }
        return {};
    }
};