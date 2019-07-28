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
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>(); // for bfs
        HashMap<TreeNode, TreeNode> parents = new HashMap<TreeNode, TreeNode>(); // parents
        HashSet<TreeNode> p_parents = new HashSet<TreeNode>();
        HashSet<TreeNode> q_parents = new HashSet<TreeNode>();
        
        TreeNode currNode;
        queue.add(root);
        
        while (queue.peek() != null) {
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
        
        TreeNode ancestor = parents.get(p);
        p_parents.add(p);
        
        while (ancestor != null) {
            p_parents.add(ancestor);
            ancestor = parents.get(ancestor);
        }
        
        ancestor = parents.get(q);
        q_parents.add(q);
        while (ancestor != null) {
            q_parents.add(ancestor);
            ancestor = parents.get(ancestor);
        }
        
        // The set with the larger amount of ancestors is the one we should look at
        Set<TreeNode> chosen = q_parents.size() > p_parents.size() ? p_parents : q_parents;
        TreeNode chosenNode = q_parents.size() > p_parents.size() ? q : p;
        
        ancestor = parents.get(chosenNode);
        while (ancestor != null) {
            if (chosen.contains(ancestor)) {
                return ancestor;
            }
            ancestor = parents.get(ancestor);
        }
        
        return root;
    }
}