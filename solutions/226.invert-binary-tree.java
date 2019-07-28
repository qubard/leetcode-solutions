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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        
        if (root.left != null) {
            root.left = invertTree(root.left);
        }
        
        if (root.right != null) {
            root.right = invertTree(root.right);
        }
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp; // swap em
        return root;
    }
}