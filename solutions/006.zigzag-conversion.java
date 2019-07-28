class Solution {
    public String convert(String s, int numRows) {
        String[] rows = new String[numRows];
        
        for (int i = 0; i < numRows; i++) rows[i] = "";
        
        if (numRows == 1) {
            return s;
        }
        
        boolean zigzag = false;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (row >= numRows - 1) {
                zigzag = true;
            } else if (row == 0) {
                zigzag = false;
            }
            
            rows[row] += c;
            row += zigzag ? -1 : 1;
        }
        
        return String.join("", rows);
    }
}