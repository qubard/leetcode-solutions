class Solution {
public:
    bool checkStraightLine(vector<vector<int>>& coordinates) {
        if (coordinates.size() <= 1) return false;
        if (coordinates.size() == 2) {
            return true;
        }
        
        auto a = coordinates[0];
        auto b = coordinates[1];
        
        double m = abs((double)(b[1]-a[1])/(double)(b[0]-a[0]));
        
        for (int i = 1; i < coordinates.size()-1; i++) {
            a = coordinates[i];
            b = coordinates[i+1];
            
            double m_ = abs((double)(b[1]-a[1])/(double)(b[0]-a[0]));
            if (m_ != m) {
                return false;
            }
            m = m_;
        }
        
        return true;
    }
};