class Solution {
public:
    pair<int, int> best;
    int treeDiameter(vector<vector<int>>& edges) {
        vector<vector<int>> adj;
        adj.assign(edges.size() + 1, vector<int>());
        
        for (auto & e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        
        // we start at 0 up to edges.size()
        best = { -1, -1 };
        dfs(0, -1, adj, 0);
        dfs(best.second, -1, adj, 0);
        
        return best.first;
    }
    
    void dfs(int src, int parent, vector<vector<int>>& adj, int depth) {
        for (int& child: adj[src]) {
            if (child != parent) {
                dfs(child, src, adj, depth + 1);
            }
        }
                        
        if (depth > best.first) {
            best = make_pair(depth, src);
        }
    }
};
