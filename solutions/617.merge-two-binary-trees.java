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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        
        if (t1 != null && t2 != null) {
            t1.val = t1.val + t2.val;
            
            if (t1.left != null) {
                t1.left = mergeTrees(t1.left, t2.left); 
            } else {
                t1.left = t2.left;
            }
            
            if (t1.right != null) {
                t1.right = mergeTrees(t1.right, t2.right); 
            } else {
                t1.right = t2.right;
            }
        }
        
        if (t1 == null) {
            return t2; 
        }
        
        return t1;
    }
}