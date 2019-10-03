class Solution {
    ArrayList<String> sol = new ArrayList<>();
    public void helper(String digits, String curr) {
        if (digits.isEmpty()) {
            sol.add(curr);
            return;
        }
        
        int digit = (int)digits.charAt(0) - '0';
        int start = (digit - 2) * 3;
        if (digit == 9) start = 22;
        if (digit == 8) start = 19;
        for (int j = 0; j < (digit == 7 || digit == 9 ? 4 : 3); j++) {
            char neighbor = (char)('a' + j + start);
            helper(digits.substring(1, digits.length()), curr + neighbor + "");
        }
    }
    
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return sol;
        helper(digits, "");
        return sol;
    }
}