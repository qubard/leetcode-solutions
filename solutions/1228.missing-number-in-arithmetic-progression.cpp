class Solution {
public:
    int missingNumber(vector<int>& arr) {
        int m = -1;
        for (int i = 0; i < arr.size() - 1; i++) {
            int d = arr[i + 1] - arr[i];
            if (m == -1 || abs(d) < abs(m)) {
                m = d;
            }
        }
        
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr[i] + m != arr[i + 1]) {
                return arr[i] + m;
            }
        }
                
        return 0;
    }
};