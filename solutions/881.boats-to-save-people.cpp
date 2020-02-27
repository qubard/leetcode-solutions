class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
        // two sum
        // find all a,b s.t a + b <= limit (we need all pairs)
        // with a minor adjustment
        // two pointer method and if right pointer doesn't
        // fit we count as an extra boat
        int b = 0; // # boats
        int l = 0;
        int r = people.size()-1;
        // Need to sort for 2-sum to work
        sort(people.begin(), people.end());
        while (l < r) {
            int sum = people[l] + people[r];
            if (sum <= limit) {
                b++;
                l++;
                r--;
            } else {
                b++;
                r--;
            }
            
            if (l == r) {
                b++;
            }
            
        }
        return b;
    }
};