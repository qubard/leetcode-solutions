class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        for (String token: tokens) {
            if (token.equals("+") || token.equals("*") || token.equals("/") || token.equals("-")) {
                int first = stk.pop();
                int second = stk.pop();
                if (token.equals("+")) {
                    stk.push(first + second);
                } else if (token.equals("*")) {
                    stk.push(first * second);
                } else if (token.equals("/")) {
                    stk.push(second / first);
                } else if (token.equals("-")) {
                    stk.push(second - first);
                }
            } else {
                stk.push(Integer.valueOf(token));
            }
        }
        return stk.peek();
    }
}