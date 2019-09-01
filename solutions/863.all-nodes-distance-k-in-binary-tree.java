/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode, TreeNode> parents = new HashMap<>();
    
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (root.left != null) {
            parents.put(root.left, root);
        }
        
        if (root.right != null) {
            parents.put(root.right, root);
        }
        
        traverse(root.left);
        traverse(root.right);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        traverse(root);
        LinkedList<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        HashMap<TreeNode, Integer> distance = new HashMap<>();
        ArrayList<Integer> sol = new ArrayList<>();
        
        queue.add(target);
        distance.put(target, 0);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            visited.add(node);
            
            if (distance.get(node) == K) {
                sol.add(node.val);
            }
            
            TreeNode parent = parents.get(node);
            if (node.left != null && !visited.contains(node.left)) {
                queue.add(node.left);
                distance.put(node.left, distance.get(node) + 1);
            }
            
            if (node.right != null && !visited.contains(node.right)) {
                queue.add(node.right);
                distance.put(node.right, distance.get(node) + 1);
            }
            
            if (parent != null && !visited.contains(parent)) {
                queue.add(parent);
                distance.put(parent, distance.get(node) + 1);
            }
        }
        // Do DFS to label parents of each node, then run BFS and find all nodes with distance k
        return sol;
    }
}