class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            digits = new int[1];
            digits[0] = 1;
            return digits;
        }
        
        digits[digits.length - 1] += 1;
        int i = digits.length - 1;
        boolean carry = digits[i] == 10;
        while (carry && i > 0) {
            digits[i] = 0;
            i--;
            digits[i] += 1;
            carry = digits[i] == 10;
        }
        
        if (carry) {
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            return ret;
        }
        
        return digits;
    }
}