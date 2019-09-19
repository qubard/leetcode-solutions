class Solution {
    public String removeDuplicates(String S) {
        ArrayDeque<Character> stk = new ArrayDeque<>();
        
        for (Character c: S.toCharArray()) {
            if (!stk.isEmpty() && stk.peek().equals(c)) {
                stk.pop();
            } else {
                stk.push(c);
            }
        }
        
        // Print out the stack
        String ret = "";
        while (!stk.isEmpty()) {
            ret = stk.pop() + ret;
        }
        return ret;
    }
}