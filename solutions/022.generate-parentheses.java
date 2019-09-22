class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        generateParenthesisCore(res, "", 0, 0, n);
        return res;
    }
    
    public void generateParenthesisCore(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }
        
        if (open < max) {
            generateParenthesisCore(ans, cur+"(", open + 1, close, max);
        }
        
        if (close < open) {
            generateParenthesisCore(ans, cur+")", open, close + 1, max);
        }
    }
}