class Solution {
public:
    int orientation(int x1, int y1, int x2, int y2, int x3, int y3) {
        // Similar to orientation() in the convex hull algorithm,
        // except we position the other two vertices relative
        // to the center one and so the value should always be
        // positive or negative with respect to the ratios
        return (x1 - x2) * (y3 - y2) - (y1 - y2) * (x3 - x2);
    }
    
    bool isConvex(vector<vector<int>>& points) {
        bool a = false;
        bool b = false;
        for (int i = 0; i < points.size(); i++) {
            vector<int> p1 = points[i];
            vector<int> p2 = points[(i+1) % points.size()];
            vector<int> p3 = points[(i+2) % points.size()];
        
            int j = orientation(p1[0], p1[1], p2[0], p2[1], p3[0], p3[1]);
            
            if (j < 0) {
                a = true;
            } else if (j > 0) {
                b = true;
            } 
            
            if (a && b) return false;
        }
        return true;
        
    }
};