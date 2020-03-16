class Solution(object):
    def neighbors(self, node, maze):
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        row = node[0]
        col = node[1]
        res = []
        for d in dirs:
            srow = row
            scol = col
            while srow >= 0 and srow < len(maze) and scol >= 0 and scol < len(maze[0]):                  
                if maze[srow][scol] == 1:
                    break
                    
                srow =  srow + d[0]
                scol = scol + d[1]
            res.append((srow-d[0], scol-d[1]))
            
        return res
        
    def hasPath(self, maze, start, destination):
        q = collections.deque()
        q.append((start[0], start[1]))
        
        visited = {}
        visited[(start[0],start[1])] = True
        
        while len(q) > 0:
            curr = q.pop()
            nn = self.neighbors(curr, maze)
            for n in nn:
                if n not in visited:
                    visited[n] = True
                    q.append(n)
            
        return (destination[0],destination[1]) in visited
            
            
            
        