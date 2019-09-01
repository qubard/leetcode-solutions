class Solution {
    public String removeKdigits(String num, int k) {
        if (k <= 0)
            return num;
        
        // This problem is cool because it shows how
        // you can solve this in O(n) if you consider
        // one character at a time and determine whether or not
        // it should be removed. Starting at teh far left, we
        // know a digit should be removed if its > the digit to
        // its immediate right. Otherwise, we know that it's smaller
        // and if we remove it the number will become larger than just
        // removing the second digit. So, we can iterate over each digit
        // and do k removals then finish.
        // You keep a stack of teh digits
        // and you compare the number you look at to the number on teh stack
        // If it's smaller, pop the number off the stack
        
        // We use a stack because we have situations like 99641 where if we remove 3 digits
        // it should be 41 left but we push 9, 9, 6 onto the stack and we see 6 is smaller
        // so we continue decreasing k until it consumes all the digits bigger than it
        
        // At the end if you still have k > 0 you just pop off k numbers
        
        LinkedList<Integer> stk = new LinkedList<Integer>();
        
        for (int i = 0; i < num.length(); i++) {
            int curr = num.charAt(i) - '0';

            while (!stk.isEmpty() && curr < stk.peek() && k > 0) {
                stk.pop();
                k--;
            }

            stk.push(curr);
        }
        
        // Need to be at least 2 digits
        if (stk.size() > 1) {
            // Remove leading zeros
            while (!stk.isEmpty() && stk.get(stk.size() - 1) == 0) {
                stk.remove(stk.size() - 1);
            }
        }
        
        // Sorted in ascending order, or remaining k (corner case)
        while (k > 0 && !stk.isEmpty()) {
            stk.pop();
            k--;
        }
        
        if (stk.isEmpty()) return "0";
        
        String s = "";
        while (!stk.isEmpty()) {
            s = stk.pop() + s;
        }
        
        return s;
    }
}