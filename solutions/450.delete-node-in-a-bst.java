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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.right != null) {
                TreeNode node = root.right;
                
                while (node.left != null) {
                    node = node.left;
                }
                
                node.left = root.left;
                return root.right;
            }
            return root.left;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        
        root.right = deleteNode(root.right, key);
        return root;
    }
}