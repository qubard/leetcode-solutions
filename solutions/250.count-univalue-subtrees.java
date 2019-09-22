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
    int count = 0;
    // All the values in the left subtree are equal
    public boolean equal(TreeNode root) {
        if (root == null) return true;
        
        boolean left = equal(root.left);
        boolean right = equal(root.right);
        
        if (left && right) {
            if ((root.left != null ? root.left.val == root.val : true) && (root.right != null ? root.right.val == root.val : true)) {
                count++;
                return true;
            }
        }
        
        return false;
    }
    
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        equal(root);
        return count;
    }
}