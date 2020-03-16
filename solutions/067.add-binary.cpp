class Solution {
public:
    string addBinary(string a, string b) {

        if (a.length() > b.length()) {
            int d = a.length() - b.length();
            while (d > 0) {
                b = "0" + b;
                d--;
            }
        } else {
            int d = b.length() - a.length();
            while (d > 0) {
                a = "0" + a;
                d--;
            }
        }
        
        string out = "";
        int carry = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int a1 = (int)((int)a[i] - (int)'0');
            int b1 = (int)((int)b[i] - (int)'0');
            
            int sum = (a1 + b1 + carry) % 2;
            out = (char)(sum + '0') + out;
            
            carry = (a1 + b1 + carry) / 2;
        }
        
        if (carry > 0) {
            out = "1" + out;
        }
        
        
        return out;
    }
};