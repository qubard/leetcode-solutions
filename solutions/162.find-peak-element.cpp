class Solution {
public:
    int search(vector<int>& nums, int left, int right) {
        if (left > right) return -1;
        if (left == right) return left;
        int mid = left + (right-left)/2;
        int v = nums[mid];
        
        bool l = mid - 1 < 0 || (mid - 1 >= 0 && v - nums[mid - 1] > 0);
        bool r = mid + 1 > nums.size() || (mid + 1 < nums.size() && v - nums[mid + 1] > 0);
        if (l && r) {
            return mid;
        }
        
        if (mid + 1 < nums.size() && nums[mid+1] - v > 0) {
            return search(nums, mid + 1, right);
        }
        return search(nums, left, mid - 1);
    }
    
    int findPeakElement(vector<int>& nums) {
        return search(nums, 0, nums.size() - 1);
    }
};