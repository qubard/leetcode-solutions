class Node {
    
    public Node left;
    public Node right;
    public int val;
    
    Node(int val) {
        this.val = val;
    }
    
}
// I regret this solution, lmao. It's not easy to convert the ids to parents.
// Just instead do DFS next time with the node array
class Solution {
    public int pathSum(Node root, int acc) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return root.val + acc;
        }
        return (root.left != null ? pathSum(root.left, root.val + acc) : 0) +
           (root.right != null ? pathSum(root.right, root.val + acc) : 0 );
    }
    
    public int pathSum(int[] nums) {
        // you need at most 48 nodes
        // with left and right children
        if (nums.length == 0) return 0;
        Node nodes[] = new Node[49];
        Node root = null;
        // technically our nodes start at 11 but whatever
        int[] idmap = new int[49];
        idmap[11] = 1;
        idmap[21] = 2;
        idmap[22] = 3;
        idmap[31] = 4;
        idmap[32] = 5;
        idmap[33] = 6;
        idmap[34] = 7;
        idmap[41] = 8;
        idmap[42] = 9;
        for (int i = 43; i <= 48; i++) {
            idmap[i] = i - 42 + 9;
        }
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int actualval = nums[i] % 10;
            int id = (nums[i] - actualval) / 10;
            int depth = (id - id % 10) / 10;
            int position = id % 10;
            id = idmap[id];
            nodes[id] = new Node(actualval);
            if (root == null) root = nodes[id];
            if (depth > 1) {
                int parent = id / 2;
                boolean right = position % 2 == 0;
                if (right) {
                    nodes[parent].right = nodes[id];
                } else {
                    nodes[parent].left = nodes[id];
                }
            }
        }
        
        // Now we've built the graph in linear time
        // Let's traverse it for the solution
        if (root == null) return 0;
        
        return pathSum(root, 0);
    }
}