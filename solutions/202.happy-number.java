class Solution {
public:
    int next(int n) {
        int c = 0;
        while (n > 0) {
            c += (n % 10) * (n % 10);
            n /= 10;
        }
        return c;
    }
    bool isHappy(int n) {
        set<int> seen;
        
        while (n != 1) {
            seen.insert(n);
            n = next(n);
            if (seen.find(n) != seen.end()) {
                return false; // cycle
            }    
        }
        
        return true;
    }
};