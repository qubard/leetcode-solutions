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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root != null) {
            if (sum == root.val && root.left == null && root.right == null) {
                return true;
            }
            return (root.left != null ? hasPathSum(root.left, sum - root.val) : false) || (root.right != null ? hasPathSum(root.right, sum - root.val) : false);
        } else {
            return false;
        }
    }
}