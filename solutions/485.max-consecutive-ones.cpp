class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int ans = 0;
        int c = 0;
        for (int i: nums) {
            c = (c + 1) * i;
            ans = max(ans, c);
        }
        return ans;
    }
};