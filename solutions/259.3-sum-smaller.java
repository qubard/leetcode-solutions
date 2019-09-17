class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        
        int sol = 0;
        
        for (int i = 0; i < nums.length; i++) {     
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int a = nums[left];
                int b = nums[right];
                
                int sum = a + b + nums[i];
                
                // Record solution
                if (sum < target) {
                    sol += right - left;
                }
                
                // You find all indices where sorted.get(i) + a + b < target and then you know you can count right - left 
                // many solutions, then increment
                if (sum < target) {
                    left++;
                } else if (sum >= target) {
                    right--;
                }
            }
        }
        // -2, 0, 1, 3
        return sol;
    }
}