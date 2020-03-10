    class Solution {
    public:
        int findShortestSubArray(vector<int>& nums) {
            unordered_map<int, int> left;
            unordered_map<int, int> right;
            unordered_map<int, int> freq;
            // We technically don't need these maps or more than one pass
            // But whatever, it greatly simplifies it and doesn't change runtime
            int maxFreq = -1;
            for (int i = 0; i < nums.size(); i++) {
                int v = nums[i];
                if (!freq.count(v)) {
                    freq[v] = 0;
                }
                if (!left.count(v)) {
                    left[v] = i;
                }
                if (!right.count(v)) {
                    right[v] = i;
                }
                left[v] = min(left[v], i);
                right[v] = max(right[v], i);
                freq[v]++;
                if (maxFreq < 0 || freq[v] > maxFreq) {
                    maxFreq = freq[v];
                }
            }

            int sol = -1;
            for (int v : nums) {
                if (freq[v] == maxFreq) {
                    if (sol < 0 || right[v] - left[v] + 1 < sol) {
                        sol = right[v] - left[v] + 1;
                    }
                }
            }

            return sol;
        }
    };