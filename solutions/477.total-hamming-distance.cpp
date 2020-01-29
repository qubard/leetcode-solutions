class Solution {
public:
    int totalHammingDistance(vector<int>& nums) {
        // Observation: we can compute the hamming distance between pairs
        // easily (0, 0, 1) since we see two 0 and one 1 we know that at the time we see
        // 1 we have to accumulate hamming distance 2
        // If we count the # of ones then # of 0s is nums.size() - # of ones 
        // From # of zeros we can then pair 
        // # of ways to draw linse between two groups (combinatorically)
        // So that's just the # of elements in each group multiplied by each other
        
        // 2-> 4
        // 0 0 = 2
        // 1 1 1 1 = 4
        
        
        // 0, 1, 0 -> 2
        // (0, 1), (0, 0), (1, 0)
        // still n^2 pairs 0 + 1 + 1 + 0 = 2
        // if we consider every 3 pairs and our answers our correct the overall answer
        // for n bits will be correct
        
        // 1, 1, 0 -> (1, 1), (1, 0), (1, 0) -> 2
        // 1, 1, 1 -> 0
        // 0, 0, 0 -> 0
        // 0, 0, 1 -> 2
        // So our solution thinking in terms of # elements is actually correct
        // so we do a XOR sum
        // 0100
        // 1110
        // 0010
        int sum = 0;
        for (int i = 0; i <= 32; i++) {
            int one_count = 0;
            for (int j = 0; j < nums.size(); j++) {
                one_count += nums[j] & 1;
                nums[j] >>= 1;
            }
            std::cout << "one_count" << one_count << "\n";
            sum += one_count * (nums.size() - one_count);
        }
        return sum;
    }
};