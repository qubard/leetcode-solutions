class Solution {
    public int fib(int N) {
        int a = 0;
        int b = 1;
        
        if (N == 0) return a;
        if (N == 1) return b;
        int c = 1;
        for (int i = 2; i < N; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}