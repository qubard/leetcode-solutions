class Solution {
public:
    double angle(int x1, int y1, int x2, int y2, int x3, int y3) {
            // p1->p2
            // p1->p3
            // (x2-x1, y2-y1), (x3-x1,y3-y1)
            //
        double dot = (double)(x2-x1)*(double)(x3-x1) + (double)(y3-y1)*(double)(y2-y1);
        double mag1 = (double)(x2-x1)*(double)(x2-x1) + (double)(y2-y1)*(double)(y2-y1);
        double mag2 = (double)(x3-x1)*(double)(x3-x1) + (double)(y3-y1)*(double)(y3-y1);
        
        double ang = dot/((double)sqrt(mag1)*(double)sqrt(mag2));
        
        return ang;
    }
    
    bool validSquare(vector<int>& p1, vector<int>& p2, vector<int>& p3, vector<int>& p4) {
        // Take maximum width and height different between
        // any point
        // To get wxh
        // Then compute the area of (p1, p2, p3) and (p1, p4, p3) (two triangles)
        // If they are equal to lxw we have a square
        // Also this works no matter the order of the points
        
        // Actually no, because we can't account for diamonds
        // So let's use dot product and if both angles are 45 deg
        // or 90 deg we have our answer.
        
        // I should have gotten the center point and compared
        // the angle to all the other corners however

        double a1 = angle(p1[0], p1[1], p2[0], p2[1], p4[0], p4[1]);
        double a2 = angle(p1[0], p1[1], p3[0], p3[1], p2[0], p2[1]);
        double a3 = angle(p1[0], p1[1], p4[0], p4[1], p3[0], p3[1]);
        
        double a4 = angle(p3[0], p3[1], p1[0], p1[1], p4[0], p4[1]);
        double a5 = angle(p3[0], p3[1], p1[0], p1[1], p2[0], p2[1]);
        double a6 = angle(p3[0], p3[1], p2[0], p2[1], p4[0], p4[1]);
        
        double a7 = angle(p2[0], p2[1], p1[0], p1[1], p4[0], p4[1]);
        double a8 = angle(p2[0], p2[1], p1[0], p1[1], p3[0], p3[1]);
        double a9 = angle(p2[0], p2[1], p3[0], p3[1], p4[0], p4[1]);
      
        double a10 = angle(p4[0], p4[1], p3[0], p3[1], p1[0], p1[1]);
        double a11 = angle(p4[0], p4[1], p2[0], p2[1], p1[0], p1[1]);
        double a12 = angle(p4[0], p4[1], p3[0], p3[1], p2[0], p2[1]);

        
        double d = a1+a2+a3+a4+a5+a6+a7+a8+a9+a10+a11+a12;

        return abs(d - (double)8/sqrt(2)) < 0.0001;
    }
};