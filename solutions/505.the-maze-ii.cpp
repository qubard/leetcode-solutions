struct Pos {
    int row;
    int col;
    int d;
};

class Solution {
public:
    vector<vector<int>> dirs = {{0,1}, {0,-1}, {1,0}, {-1, 0}};
    
    vector<Pos> getNeighbors(int srow, int scol, vector<vector<int>>& maze) {
        // Going down
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
            pp.d = 0;
            poses.push_back(pp);
        }
        
        return poses;
    }
    
    int shortestDistance(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        int distances[maze.size()][maze[0].size()];
        
        auto cmp = [&](Pos left, Pos right) {
            return left.d >right.d;
        };
        
        priority_queue<Pos, vector<Pos>, decltype(cmp)> queue(cmp);

        for (int i = 0; i < maze.size(); i++) {
            for (int j = 0; j < maze[0].size(); j++)
                distances[i][j] = (1 << 30) - 1; // max value
        }
        
        distances[start[0]][start[1]] = 0;
        
        vector<Pos> neighbors1 = getNeighbors(start[0], start[1], maze);

        queue.push({ start[0], start[1] });
            
        while (!queue.empty()) {
            Pos curr = queue.top();
            queue.pop();
            vector<Pos> neighbors = getNeighbors(curr.row, curr.col, maze);
            //cout << curr.row << "," << curr.col << ":" << curr.d << "\n";
            if (curr.row == destination[0] && curr.col == destination[1]) {
                return curr.d;
            }
            
            for (auto n : neighbors) {
                if (n.row != curr.row || n.col != curr.col) {
                    int alt = distances[curr.row][curr.col] + abs(curr.row - n.row) + abs(curr.col - n.col);
                    if (alt < distances[n.row][n.col]) {
                        distances[n.row][n.col] = alt;
                        // push n to q
                        queue.push({n.row, n.col, alt});
                    }
                }
            }
        }
        
        return -1;
    }
};

/*
struct Pos {
    int row;
    int col;
    int d;
};

// DFS insanely slow solution

class Solution {
public:
    vector<vector<int>> dirs = {{0,1}, {0,-1}, {1,0}, {-1, 0}};
    
    vector<Pos> getNeighbors(int srow, int scol, vector<vector<int>>& maze) {
        // Going down
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
            pp.d = 0;
            poses.push_back(pp);
        }
        
        return poses;
    }
              
    int dfs(vector<vector<int>>& maze, int srow, int scol, vector<int>& destination, vector<vector<int>>& distances) {
        vector<Pos> neighbors = getNeighbors(srow, scol, maze);

        for (auto n : neighbors) {
            if (n.row != srow || n.col != scol) {
                int alt = distances[srow][scol] + abs(srow - n.row) + abs(scol - n.col);
                if (distances[n.row][n.col] < 0 || alt < distances[n.row][n.col]) {
                    distances[n.row][n.col] = alt;
                    dfs(maze, n.row, n.col, destination, distances);
                }
            }
        }
        
        return distances[destination[0]][destination[1]];
    }
    
    int shortestDistance(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        vector<vector<int>> distances(maze.size(), vector<int>(maze[0].size(), 0));
        
        for (int i = 0; i < maze.size(); i++) {
            for (int j = 0; j < maze[0].size(); j++)
                distances[i][j] = -1;
        }
        distances[start[0]][start[1]] = 0;
        
        return dfs(maze, start[0], start[1], destination, distances);   
    }

};
*/