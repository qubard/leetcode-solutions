class Solution {
    public int mySqrt(int x) {
        double prev = x;
        double approx = 0;
        int i = 100;
        while (i > 0) {
            approx = prev - (prev * prev - x)/ (2 * prev);
            prev = approx;
            i--;
        }
        return (int) approx;
    }
}