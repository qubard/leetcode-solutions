class Solution {
    public int mincost(int[] days, int[] costs) {
        int[] offset = {1, 7, 30};
        int[] dp = new int[days[days.length - 1] + 1];
        
        boolean[] travel = new boolean[dp.length];
        
        for (int i = 0; i < days.length; i++) {
            travel[days[i]] = true;
        }
        
        for (int day = days[days.length - 1]; day >= days[0]; day--) {
            dp[day] = Integer.MAX_VALUE;
            if (!travel[day]) {                    
                // When we have a "travel" day it makes no sense 
                // to buy anything on that day, so our min cost for everything is the past travel day's cost
                dp[day] = dp[day + 1];
            } else {
                for (int c = 0; c < 3; c++) {
                    int val = costs[c];
                    int next = day + offset[c];
                    dp[day] = Math.min(dp[day], (next > days[days.length - 1] ? 
                                       0 : dp[next]) + val);
                }
            }
        }
        // We can solve this using a DAG method when we realize this is literally shortest path
        // to the end of array with 3 possible costs
        // So it's just a DAG with at most 3 edges to the next node
        // Apply the shortest path on a DAG
        // Start from the beginning, shortest path from that node 
        // is by definition the min of the shortest path of its predecessors
        
        // We don't need to do a DAG shortest path though because there's only 3 edges
        // and only 3 places the previous node is connected to which is always the same (it would be overkill)
        // but once you realize it's a DAG shortest path algorithm it's very easy to solve
        return dp[days[0]];
    }
    
    public int mincostTickets(int[] days, int[] costs) {
        return mincost(days, costs);
    }
}