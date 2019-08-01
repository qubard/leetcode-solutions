class Solution {
    // dp[i][j] = dp[i][j - 1] && k + nums[j] == k.. false always unless nums[j] = 0
    // i guess in each index we store the actual sum and then we just increment our
    // count if after we set it it equals k

    // bruteforce is to just go through all of them or whatever
    // for length n,
    // n + (n-1) + .. + 1 different continuous subarrays
    // n(n + 1)/2 -> O(n^2) bruteforce to go through all of them
    // plus the O(n) cost of iterating, so O(n^3 total)
    // the DP solution is O(n^2)
    // for some reason we're running out of memory

    // oh--we only need a 1 dimensional array
    // for all the sums up to j
    // and then the sum from j to index i is
    // -sum(j-1) + sum(j + i)
    // So when we get a memory constraint we should ask this question
    // its basically the split case thing
    // it helps to think of all the possible subarrays as (i, j) though
    // but yeah to solve it all we need is nums.length * 4 bytes
    public int subarraySum(int[] nums, int k) {
        int c = 0;
        
        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sums[i] = i == 0 ? nums[0] : sums[i - 1] + nums[i];
            if (sums[i] == k) c++;
        }
        
        for (int j = 0; j < nums.length; j++) {
            // then in O(1) time we can compute every single sum we need
            for (int l = 1; j + l < nums.length; l++) {
                int subsum = sums[j + l] - sums[j];
                if (subsum == k) {
                    c++;
                }
            }
        }
                                               
        return c;
    }
}
