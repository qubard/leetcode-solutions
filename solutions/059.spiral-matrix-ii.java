class Solution {
    public void spiral(int[][] matrix, int n, int i, int j, int start) {
        for (int x = j; x < n; x++) {
            matrix[i][x] = start++;
        }

        for (int x = i + 1; x <= n - 1; x++) {
            matrix[x][n - 1] = start++;
        }
        
        for (int x = n - 2; x >= j; x--) {
            matrix[n - 1][x] = start++;
        }
        
        for (int x = n - 2; x > i; x--) {
            matrix[x][j] = start++;
        }
        
        if (n > 1) {
            spiral(matrix, n - 1, i + 1, j + 1, start);
        }
    }
    
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        spiral(matrix, n, 0, 0, 1);
        return matrix;
    }
}