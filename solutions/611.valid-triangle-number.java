class Solution {
    
    private boolean validTriangle(int a, int b, int c){
        return a + b > c && a + c > b && b + c > a;
    }
    
    public int triangleNumber(int[] nums) {
        int valid = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (validTriangle(nums[i], nums[j], nums[k])) {
                        valid++;
                    }
                }
            }
        }
        return valid;
    }
}