class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stk.push(c);
            } else {
                if (stk.empty()) return false;
                char e = stk.pop();
                if ((c == '}' && e != '{') || (c == ')' && e != '(') || (c == ']' && e != '[')) {
                    return false;
                }
            }
        }
        return stk.empty();
    }
}