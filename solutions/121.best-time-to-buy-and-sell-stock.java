class Solution {
    public int maxProfit(int[] prices) {
        // Keep track of min from left to right
        // compute against min the profit
        int maxProfit = 0;
        if (prices.length == 0)
            return 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            int val = prices[i];
            min = Math.min(val, min);
            maxProfit = Math.max(maxProfit, val - min);
        }
        return maxProfit;
    }
}