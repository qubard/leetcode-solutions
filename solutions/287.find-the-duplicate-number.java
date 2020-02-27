class Solution {
    public int findDuplicate(int[] nums) {
        for (Integer i: nums) {
            if (nums[Math.abs(i) - 1] < 0) {
                return Math.abs(i);
            }
            nums[Math.abs(i) - 1] *= -1;
        }
        return 0;
    }
}

/*

// Tortoise and hare solution
class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int t = nums[0];
        int h = nums[0];
        
        // The only reason this question isn't uber complicated
        // is because there's guarnateed to be a duplicate
        // But it's all in the wording which makes it easy
        
        do {
            t = nums[t];
            h = nums[nums[h]];
        } while (t != h);
        
        t = nums[0];
        
        while (t != h) {
            t = nums[t];
            h = nums[h];
        }
        
        return t;
    }
};

*/