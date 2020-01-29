class Solution {
public:
    int maxNumberOfBalloons(string text) {
        unordered_map<char, int> map;
        int sol = -1;
        for (auto c : text) {
            if (!map.count(c)) map[c] = 0;
            map[c]++;
        }
        
        for (auto c: {'b', 'a', 'l', 'o', 'n'}) {
            int cnt = map[c];
            if (c == 'l' || c == 'o') {
                cnt /= 2;
            }
            if (sol == -1) sol = cnt;
            sol = min(sol, cnt);
        }
        return sol;
    }
};