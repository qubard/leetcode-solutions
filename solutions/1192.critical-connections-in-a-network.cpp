class Solution {
public:
    int id = 0;
            
    vector<vector<int>> ret;
    void dfs(int from, int parent, int n, vector<vector<int>>& edges, vector<bool>& visited, vector<int>& ids, vector<int>& low) {
        visited[from] = true;
        
        low[from] = ids[from] = id++;

        for (auto& to: edges[from]) {
            if (to == parent) continue;
            if (!visited[to]) {
                dfs(to, from, n, edges, visited, ids, low);

                low[from] = min(low[from], low[to]);
                // if the discovery time (ids[from]) is still smaller than the lowest value of to,
                // we know this has to be a bridge.
                // by definition  on an undirected graph we know components are connected if there ids
                // are smaller in increasing order
                if (ids[from] < low[to]) {
                    // Bridge
                    vector<int> bridge;
                    bridge.push_back(from);
                    bridge.push_back(to);
                    ret.push_back(bridge);
                }
            } else {
                low[from] = min(low[from], ids[to]);
            }
        }
        
    }
    
    vector<vector<int>> criticalConnections(int n, vector<vector<int>>& connections) {
        vector<bool> visited(n, false);
        vector<int> ids(n, -1);
        vector<int> low(n, -1);
        vector<vector<int>> edges(n, vector<int>());
        
        for (auto& connection: connections) {
            edges[connection[0]].push_back(connection[1]);
            edges[connection[1]].push_back(connection[0]);
        }
        
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                dfs(v, -1, n, edges, visited, ids, low);
            }
        }
        
        return ret;
    }
};