class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
           return (a[0] - a[1]) - (b[0] - b[1]); 
        });
        
        int total = 0;
        int n = costs.length / 2;
        
        for (int i = 0; i < n; i++) {
            total += costs[i][0] + costs[costs.length - i - 1][1];
        }
        
        return total;
    }
}