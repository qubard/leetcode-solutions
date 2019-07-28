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
    
    public int pathSumS(TreeNode root, int sum, boolean chosen) {
        if (root == null) 
            return 0;
        
        // they have to be contiguous paths, which it doesnt say in the QUESTION
        
        if (!chosen) {
            return (sum == root.val ? 1 : 0) + (root.left != null ? pathSumS(root.left, sum - root.val, true) 
                + pathSumS(root.left, sum, chosen)
                : 0) + (root.right != null ? pathSumS(root.right, sum - root.val, true) + pathSumS(root.right, sum, chosen) : 0);
        }
        
        return (sum == root.val ? 1 : 0)  + (root.left != null ? pathSumS(root.left, sum - root.val, chosen)
                : 0) + (root.right != null ? pathSumS(root.right, sum - root.val, chosen) : 0);
    }
    
    public int pathSum(TreeNode root, int sum) {
        return pathSumS(root, sum, false);
    }
}