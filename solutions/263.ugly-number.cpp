class Solution {
public:
    int divide(int n, int k) {
        while (n % k == 0) {
            n /= k;
        }
        
        return n;
    }
    
    bool isUgly(int num) {
        if (num == 1) return true;
        if (num == 0) return false;
        // question is written very poorly
        // it wants the  factorization of a number
        // to have only 2, 3, 5
        // also -2^31 is an unfair test case it considers
        // the remainder of -1 as different from +1
        num = divide(num, 2);
        num = divide(num, 3);
        num = divide(num, 5);
        // 2 * 2
        // 2 * 3
        // 2 * 5
        // 3 * 5 ..
        // 5 * ..
        
        return num == 1;
    }
};