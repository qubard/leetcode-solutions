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
    boolean balanced = true;
    public int height(TreeNode root, int h) {
        if (root == null) {
            return h;
        }
        
        int left = height(root.left, h + 1);
        int right = height(root.right, h + 1);
        
        if (Math.abs(left - right) > 1) {
            balanced = false;
        }

        return Math.max(left, right);
    }
    
    public boolean isBalanced(TreeNode root) {
        height(root, 0);   
        return balanced;
    }
}