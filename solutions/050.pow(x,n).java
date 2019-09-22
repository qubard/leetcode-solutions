class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        boolean neg = n < 0;
        
        if (n == Integer.MIN_VALUE && x > 1)
            return 0.0;
        
        n = Math.abs(n);
        while (n > 0) {
            if (n % 2 == 1) {
                res = res * x;
            }
            x = x * x;
            n /= 2;
        }
        
        if (neg) {
            return 1.0 / res;
        }
        
        return res;
    }
}