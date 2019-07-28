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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new ArrayDeque<>(); // for bfs
        Map<TreeNode, TreeNode> parents = new HashMap<>(); // parents
        Set<TreeNode> q_parents = new HashSet<>();
        
        TreeNode currNode;
        queue.add(root);
        
        while (queue.peek() != null && (!parents.containsKey(p) || !parents.containsKey(q))) {
            currNode = queue.remove();
            
            if (currNode.left != null) {
                parents.put(currNode.left, currNode);
                queue.add(currNode.left);    
            }

            if (currNode.right != null) {
                parents.put(currNode.right, currNode);
                queue.add(currNode.right);    
            }
        }
        
        TreeNode ancestor = parents.get(q);
        q_parents.add(q);
        while (ancestor != null) {
            q_parents.add(ancestor);
            ancestor = parents.get(ancestor);
        }
        
        ancestor = p;
        while (!q_parents.contains(ancestor)) {
            ancestor = parents.get(ancestor);
        }
        
        return ancestor;
    }
}