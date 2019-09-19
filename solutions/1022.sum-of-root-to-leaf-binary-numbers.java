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
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        sumRootToLeaf(root, 0);
        return sum;
    }
    
    public void sumRootToLeaf(TreeNode root, int acc) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            // binary string to number
            sum += acc * 2 + root.val; // shift to the left and add the first bit
            return;
        }

        acc = acc * 2 + root.val;
        sumRootToLeaf(root.left, acc);
        sumRootToLeaf(root.right, acc);
    }
}