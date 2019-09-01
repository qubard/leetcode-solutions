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
    public boolean equalTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        
        if ((s == null && t != null) || (t == null && s != null)) {
            return false;
        }
        
        if (s.left == null && t.left != null) {
            return false;
        }
        
        if (s.right == null && t.right != null) {
            return false;
        }
        
        if (t.val == s.val) {
            return equalTree(s.right, t.right) &&  equalTree(s.left, t.left);
        }
        
        return false;
    }
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // Find if the tree rooted at s is equal to t, if not try the left and right
        return equalTree(s, t) || (s.left != null ? isSubtree(s.left, t) : false) || (s.right != null ? isSubtree(s.right, t) : false);
    }
}