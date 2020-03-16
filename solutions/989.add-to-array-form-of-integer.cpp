class Solution {
public:
    vector<int> addToArrayForm(vector<int>& A, int K) {
        vector<int> res;
        int carry = 0;
        for (int j = A.size() - 1; j >= 0; j--) {
            int sum = (A[j] + (K % 10) + carry) % 10;
            res.push_back(sum);
            
            carry = (A[j] + (K % 10) + carry) / 10;
            
            K /= 10;
        }
        
        while (K > 0) {
            int sum = K % 10 + carry;
            res.push_back(sum%10);
            K /= 10;
            carry = sum / 10;
        }
        
        if (carry > 0) {
            res.push_back(carry);
        }
        
        reverse(res.begin(), res.end());
        return res;
    }
};