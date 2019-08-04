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
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        if (t.left == null && t.right == null) 
            return "" + t.val;
        
        return t.val + (t.left != null ? "(" + tree2str(t.left) + ")": t.right != null ? "()" : "") 
            + (t.right != null ? "(" + tree2str(t.right) + ")": "");
    }
}