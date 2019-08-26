class Solution {
    public int findLowest(int[] nums, int target, int min, int max) {
        int mid = min + (max - min + 1)/2;
        
        if (min > max || mid >= nums.length ) return -1;
        
        int v = nums[mid];
        
        if (mid - 1 >= 0) {
            if (v == target && nums[mid - 1] != target) {
                return mid;
            }
        } else {
            if (v == target) {
                return mid;
            }
        }
        
        if (v >= target) {
            return findLowest(nums, target, min, mid - 1);
        }
        return findLowest(nums, target, mid + 1, max);
    }
    
    public int findHighest(int[] nums, int target, int min, int max) {
        int mid = min + (max - min + 1)/2;
        
        if (min > max || mid >= nums.length ) return -1;
        
        int v = nums[mid];
        
        if (mid + 1 < nums.length) {
            if (v == target && nums[mid + 1] != target) {
                return mid;
            }
        } else {
            if (v == target) {
                return mid;
            }
        }
        
        if (v > target) {
            return findHighest(nums, target, min, mid - 1);
        }
        return findHighest(nums, target, mid + 1, max);
    }
    
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            int ret[] = {-1, -1};
            return ret;
        }
        int l = findLowest(nums, target, 0, nums.length - 1);
        int h = findHighest(nums, target, 0, nums.length - 1);
        int ret[] = {l ,h};
        return ret;
    }
}