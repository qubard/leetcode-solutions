class Solution {
public:
    int brokenCalc(int X, int Y) {
        if (X == Y) return 0;
        if (X > Y)
            return X-Y;
        // X < Y
        if (Y % 2 == 1) {
            // Make (Y+1)/2, multiply by 2 and subtract 1
            return brokenCalc(X, (Y + 1) / 2) + 1 + 1;
        }
        // Make Y / 2, multiply by 2
        return  brokenCalc(X, Y / 2) + 1;
    }
};