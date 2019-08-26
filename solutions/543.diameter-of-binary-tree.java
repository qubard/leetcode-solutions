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
    int solution = 0;
    
    public int diameter(TreeNode root) {
        if (root == null) return 0;
        
        int left = root.left != null ? 1 + diameter(root.left) : 0;
        int right = root.right != null ? 1 + diameter(root.right) : 0; 
        
        solution = Math.max(solution, left + right);
        return Math.max(left, right);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return solution;
    }
}