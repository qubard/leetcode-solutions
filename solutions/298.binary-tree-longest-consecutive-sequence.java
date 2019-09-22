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
    int maxLength = 0;
    
    public int longestConsecutive(TreeNode root) {
        longestConsecutive(root, null, 0);
        return maxLength;
    }
    
    public void longestConsecutive(TreeNode root, TreeNode parent, int length) {
        if (root == null) return;
        int l = parent != null && root.val == parent.val + 1 ? length + 1 : 1;
        maxLength = Math.max(l, maxLength);
        longestConsecutive(root.left, root, l);
        longestConsecutive(root.right, root, l);
    }
}