class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        unordered_map<int, int> map;
        unordered_set<int> set;
        for (int i: arr) { 
            if (!map.count(i)) map[i] = 0;
            map[i]++;
        }
        
        for (auto p: map) { 
            if (set.count(p.second)) return false;
            set.insert(p.second);
        }
        
        return true;
    }
};