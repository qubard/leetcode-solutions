class Solution {
    public void dfs(int y, int x, char[][] board, boolean[][] visited) {
        if (board[y][x] == 'O') {
            visited[y][x] = true;
        } else {
            return;
        }
        
        if (y - 1 >= 0) {
            if (!visited[y - 1][x]) {
                dfs(y - 1, x, board, visited);
            }
        }
        
        if (x - 1 >= 0) {
            if (!visited[y][x - 1]) {
                dfs(y, x - 1, board, visited);
            }
        }
        
        if (y + 1 < board.length) {
            if (!visited[y + 1][x]) {
                dfs(y + 1, x, board, visited);
            }
        }
        
        if (x + 1 < board[0].length) {
            if (!visited[y][x + 1]) {
                dfs(y, x + 1, board, visited);
            }
        }
    }
    
    public void solve(char[][] board) {
        // This problem is simple if we just
        // go from the border and try to do DFS
        // then mark each grid cell if we can reach it
        // in the DFS from the border, then replace all the unmarked O's with x
        
        // You can use union find here too if you make the border s_1, 
        // process each edge, and finally change all O's not in s_1 as X
        
        if (board.length == 0) return;
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (int x = 0; x < board[0].length; x++) {
            dfs(0, x, board, visited);
        } // top row
        
        for (int x = 0; x < board[0].length; x++) {
            dfs(board.length - 1, x, board, visited);
        } // bottom row
        
        for (int y = 1; y < board.length - 1; y++) {
            dfs(y, 0, board, visited);
            dfs(y, board[0].length - 1, board, visited);
        }
        
        for (int y = 1; y < board.length - 1; y++) {
            for (int x = 1; x < board[0].length - 1; x++) {
                if (board[y][x] == 'O' && !visited[y][x]) {
                    board[y][x] = 'X';
                }
            }
        }
    }
}