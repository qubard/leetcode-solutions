class Solution {
    public int monotoneIncreasingDigits(int N) {
        String s = N + "";
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        
        int i = 0;
        while (i < s.length()) {
            int val = s.charAt(i) - '0';
            if (!stk.isEmpty() && val < stk.peek()) {    
                int count = s.length() - i;
                // We need to replace the numbers up to this point
                while (!stk.isEmpty() && val < stk.peek()) {
                    val = stk.pop() - 1;
                    if (!stk.isEmpty()) {
                        count++;
                    }
                }
                
                if (val > 0) {
                    if (!stk.isEmpty()) {
                        count--; // Do not include current digit
                    }
                    stk.push(val);
                }
                
                while (count > 0) {
                    stk.push(9);
                    count--;
                }
                break;
            } else {
                stk.push(val);
                i++;
            }
        }
        
        String str = "";
        int ret = 0;
        i = 0;
        while (!stk.isEmpty()) {
            ret += Math.pow(10, i) * stk.pop();
            i++;
        }
        
        return ret;
    }
}
// From left to right find the index of the first number
// such that it's smaller than previous
// then decrease previous by 1
// and replace the remaining digits with 9
// but you use a stack because for 332 you have
// to replace the first 3
// stack: 3, 2
// Weird cases when the number is 110, or 100 but same thing