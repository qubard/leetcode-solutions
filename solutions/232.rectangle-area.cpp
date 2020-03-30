class Solution {
public:
    
    // We can invert whether or not rectangles don't overlap
    int overlaps(int a, int b, int c, int d, int e, int f, int g, int h) {
        if (c <= e || a >= g) {
            return false;
        }
        
        if (f >= d || h <= b) {
            return false;
        }
        
        return true;
    }
    
    int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        bool overlap = overlaps(A, B, C, D, E, F, G, H);
        int unionArea = overlap ? abs(min(C,G)-max(A,E)) * abs(min(D,H)-max(B,F)) : 0;
        
        unsigned long long a1 = abs(C-A)*abs(D-B);
        unsigned long long a2 = abs(G-E)*abs(H-F);
        
        return a1 + a2 - unionArea;
    }
};