/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new ArrayDeque<>();
        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
        
        if (root == null) return ret;
        
        q.add(root);
        
        while (!q.isEmpty()) {
            int toRemove = q.size();
            ArrayList<Integer> nodes = new ArrayList<>();    
            
            while (toRemove > 0) {
                Node n = q.remove();
                for (Node child : n.children) {
                    q.add(child);
                }
                nodes.add(n.val);
                toRemove--;
            }
            
            ret.add(nodes);
        }
        
        return ret;
    }
}