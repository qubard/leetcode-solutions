class Solution {
    public int reverse2(int x) {
        int sum = 0;
        while (x > 0) {
            if (sum > Integer.MAX_VALUE/10 || (sum == Integer.MAX_VALUE / 10 && x % 10 > 7)) 
                return 0;
            sum = sum * 10 + x % 10;
            x /= 10;
        }
        
        return sum;
    }
    
    public int reverse(int x) {
        boolean neg = x < 0;
        return reverse2(Math.abs(x)) * (neg ? -1 : 1);
    }
}