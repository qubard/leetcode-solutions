class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length - 1;
        int c = 0;
        
        while (r >= 0 && c < matrix[0].length) {
            int v = matrix[r][c];
            if (v > target) {
                r--;
            } else if (v < target) {
                c++;
            } else {
                return true;
            }
        }
        return false;
    }
}