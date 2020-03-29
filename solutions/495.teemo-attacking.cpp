class Solution {
public:
    int findPoisonedDuration(vector<int>& timeSeries, int duration) {
        int x = -1;
        int s = 0;
        for (int t : timeSeries) {
            if (x < 0 || t >= x) {
                s += duration;
                x = t + duration;
            } else if (t < x) {
                s += (t + duration) - x;
                x = (t + duration);
            }
        }
        return s;
    }
};