class Solution {
public:
    vector<int> tmp;
    int candy(vector<int>& ratings) {
        tmp = vector<int>(ratings.size(), 1);
        
        // Left pass
        for (int i = 1; i < ratings.size(); i++) {
            if (ratings[i] > ratings[i-1]) {
                tmp[i] = max(tmp[i-1]+1,tmp[i]);
            }
        }
        
        // Right pass
        for (int i = ratings.size()-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                tmp[i] = max(tmp[i+1]+1,tmp[i]);
            }
        }
        
        int sol = 0;
        for (int i: tmp) {
            sol += i;
        }
        
        return sol;
    }
};

/*
//Bruteforce solution (recursive)
class Solution {
public:
    vector<int> tmp;
    int candy(vector<int>& ratings) {
        tmp = vector<int>(ratings.size(), 0);
        recurse(ratings, 0, ratings.size() - 1);
        
        int sol = 0;
        for (int i: tmp) {
            sol += i;
        }
        
        return sol;
    }
    
    void recurse(vector<int>& ratings, int i, int j) {
        if (i > j) return;
        int s = i;
        
        for (int k = i; k <= j; k++) {
            if (ratings[k] < ratings[s]) {
                s = k;
            }
        }
        
        // Determine what we should put there
        bool left = s - 1 >= 0 && ratings[s] > ratings[s-1];
        bool right = s + 1 < ratings.size() && ratings[s] > ratings[s+1];
        tmp[s] = 1;
        if (left) {
            tmp[s] = tmp[s-1] + 1; 
        }
        if (right) {
            tmp[s] = max(tmp[s], tmp[s+1]+1);
        }
        
        recurse(ratings, i, s-1);
        recurse(ratings, s+1, j);
    }
};
*/