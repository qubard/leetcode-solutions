class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        Integer sol = null;
        
        for (int i = 0; i < nums.length; i++) {     
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < nums.length && right > i) {
                int a = nums[left];
                int b = nums[right];
                
                int sum = a + b + nums[i];
                
                // Record solution
                if (left != right) {
                    int diff = Math.abs(target - sum);
                    if (sol == null || diff <= Math.abs(target - sol)) {
                        sol = sum;
                    }
                }
                
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return sol == null ? -1 : sol;
    }
}