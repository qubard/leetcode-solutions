class Solution {
public:
    
    vector<int> tmp;
    vector<vector<int>> res;
    
    void sum(vector<int>& candidates, int last, int target) {
        if (target == 0) {
            res.push_back(tmp); // make a copy of tmp
            return;
        } else if (target < 0) {
            return;
        }
        
        int i = last;
        // have to avoid cases where 
        // we are using two different values by index
        // but they are actually the same value 
        // although we are allowed to use more than one..
        while (i >= 0) {
            if (candidates[i] <= target) {
                // choose target
                tmp.push_back(candidates[i]);
                int t = candidates[i];
                sum(candidates, i - 1, target - t);
                tmp.pop_back();
                if (i >= 0 && candidates[i] == t) {
                    while (i >= 0 && candidates[i] == t) {
                        i--;
                    }
                    continue;
                }
            }
            i--;
        }
    }
    
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        sum(candidates, candidates.size() - 1, target);
        
        return res;
    }
};