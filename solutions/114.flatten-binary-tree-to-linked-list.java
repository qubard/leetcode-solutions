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
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        if (root.left == null) {
            flatten(root.right);
            return;
        }
        
        flatten(root.left);
        TreeNode left = root.left;
        // Go to the end of the left using right pointers
        while (left.right != null) {
            left = left.right;
        }
        
        left.right = root.right;
        flatten(root.right);
        root.right = root.left;
        root.left = null;
    }
}