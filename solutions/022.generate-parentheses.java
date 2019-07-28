class Solution {
    public static boolean validSolution(String s) {
        Stack<Character> s1 = new Stack<Character>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                s1.push(c);
            }
            else if(c == ')') {
                if (s1.empty()) return false;
                s1.pop();
            }
        }
        
        return s1.empty();
    }
    
    public void backtrack(String curr, int open, int closed, List<String> ret) {
        if (open > 0 && curr.length() > 0) {
            backtrack(curr + ")", open - 1, closed, ret);
        }
        
        if (closed > 0) {
            backtrack(curr + "(", open, closed - 1, ret);
        }
        
        if (open == 0 && closed == 0) {
            // Check solution
            ret.add(curr);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ret = new ArrayList<String>();
        backtrack("", n, n, ret);
        return ret.stream().distinct().filter(Solution::validSolution).collect(Collectors.toList());
    }
}