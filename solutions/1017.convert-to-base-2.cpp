class Solution {
public:
    string baseNeg2(int N) {
        string result = "";
        
        if (N == 0) return "0";
        
        while (N != 0) {
            int remainder = N % -2;
            N /= -2;
            
            if (remainder < 0) {
                remainder += 2;
                N++;
            }
            
            result = to_string(remainder) + result;
        }
        
        return result;
    }
};