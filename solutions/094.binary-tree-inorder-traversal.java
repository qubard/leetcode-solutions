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
    ArrayList<Integer> ret = new ArrayList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        
        if (root == null) return ret;
        
        if (root.left != null)
        inorderTraversal(root.left);
        ret.add(root.val);
        if (root.right != null)
        inorderTraversal(root.right);
        
        return ret;
    }
}