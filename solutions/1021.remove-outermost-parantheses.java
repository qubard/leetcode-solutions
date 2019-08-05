class Solution {
    public String removeOuterParentheses(String S) {
        Stack<Character> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == ')') {
                if (stk.size() != 1) sb.append(c);
                stk.pop();
            } else if (c == '(') {
                if (!stk.isEmpty()) sb.append(c);
                stk.push(c);
            }
        }
        return sb.toString();
    }
}