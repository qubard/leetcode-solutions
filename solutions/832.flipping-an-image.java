class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int y = 0; y < A.length; y++) {
            for (int x = 0; x < A[y].length / 2; x++) {
                int d = A[y].length - x - 1;
                int c = A[y][x];
                A[y][x] = A[y][d]; 
                A[y][d] = c;
            }
        }
        
        for (int y = 0; y < A.length; y++) {
            for (int x = 0; x < A[y].length; x++) {
                A[y][x] = A[y][x] == 0 ? 1 : 0;
            }
        }
        return A;
    }
}