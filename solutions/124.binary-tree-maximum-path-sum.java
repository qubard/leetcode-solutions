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
    int maxSum = 0;
    public int max_gain(TreeNode root) {     
        if (root == null) return 0;
        
        int left = Math.max(max_gain(root.left), 0);
        int right = Math.max(max_gain(root.right), 0);
        
        int sum = root.val + left + right;
        
        if (sum > maxSum) {
            maxSum = sum;
        }
        
        return root.val + Math.max(left, right);
    }
    
    public int maxPathSum(TreeNode root) {
        maxSum = root.val;
        max_gain(root);
        return maxSum;
    }
}