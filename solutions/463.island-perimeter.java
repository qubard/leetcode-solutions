class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int x = 0; x < grid[i].length; x++) {
                if (grid[i][x] == 1) {
                    perimeter += i - 1 >= 0 ? grid[i - 1][x] == 0 ? 1 : 0 : 1;
                    perimeter += x + 1 < grid[0].length ? grid[i][x + 1] == 0 ? 1 : 0 : 1;
                    perimeter += x - 1 >= 0 ? grid[i][x - 1] == 0 ? 1 : 0 : 1;
                    perimeter += i + 1 < grid.length ? grid[i + 1][x] == 0 ? 1 : 0 : 1;
                }
            }
        }
        return perimeter;
    }
}