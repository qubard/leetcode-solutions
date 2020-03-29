class Solution {
public:
    int fourSumCount(vector<int>& A, vector<int>& B, vector<int>& C, vector<int>& D) {
        unordered_map<int, int> f1;
        
        for (int& a: A) {
            for (int& b: B) {
                int s = a + b;
                if (!f1.count(s)) f1[s] = 0;
                f1[s]++;
            }
        }
        
        int ans = 0;
        
        for (int& c: C) {
            for (int& d: D) {
                int s = -(c+d);
                if (f1.count(s)) { 
                    ans += f1[s];
                }
            }
        }
        return ans;
    }
};