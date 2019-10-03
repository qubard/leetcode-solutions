class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sol = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < Math.max(num2.length(), num1.length()); i++) {
            int a = 0;
            int b = 0;
            if (i < num2.length()) 
                a = num2.charAt(num2.length() - i - 1) - '0';
            if (i < num1.length())
                b = num1.charAt(num1.length() - i - 1) - '0';
            int sum = a + b + carry;
            carry = sum / 10;
            int rest = sum % 10;
            
            sol.insert(0,  (char)(rest + (int)'0'));
        }
        
        if (carry > 0) {
            sol.insert(0, carry);
        }
        
        return sol.toString();
    }
}