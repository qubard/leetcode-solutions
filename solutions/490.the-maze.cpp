struct Pos {
    int row;
    int col;
};


class Solution {
public:
    vector<vector<int>> dirs = {{0,1}, {0,-1}, {1,0}, {-1, 0}};
    
    vector<Pos> getNeighbors(int srow, int scol, vector<vector<int>>& maze) {
        vector<Pos> poses;    
        
        for (vector<int> dir: dirs) {
            int row = srow + dir[0];
            int col = scol + dir[1];
                
            while (row >= 0 && row < maze.size() && col >= 0 && col < maze[0].size()) {
                if (maze[row][col] == 1) {
                    break;
                }
                
                row += dir[0];
                col += dir[1];
            }
            
            Pos pp;
            pp.row = row-dir[0];
            pp.col = col-dir[1];
            poses.push_back(pp);
        }
        
        return poses;
    }
    
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        vector<vector<bool>> visited(maze.size(), vector<bool>(maze[0].size(), false));
        
        queue<Pos> q;
        
        visited[start[0]][start[1]] = true;
        q.push({start[0], start[1]});
        
        while (!q.empty()) {
            Pos curr = q.front();
            q.pop();
            vector<Pos> neighbors = getNeighbors(curr.row, curr.col, maze);
            for (auto nn : neighbors) {
                if (!visited[nn.row][nn.col]) {
                    visited[nn.row][nn.col] = true;
                    q.push({nn.row,nn.col});
                }
            }
        }
        
        return visited[destination[0]][destination[1]];
        
    }
};