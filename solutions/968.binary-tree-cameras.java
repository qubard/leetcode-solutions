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

    int ans = 0;
    HashSet<TreeNode> covered;
    public void dfs(TreeNode root, TreeNode parent) {
        if (root == null) return;
        
        dfs(root.left, root);
        dfs(root.right, root);
        
        // cover the node if the left and right aren't covered. 
        // if parent is null and we haven't covered the node yet recursing upward then cover too (root node)
        if (!covered.contains(root.left) || !covered.contains(root.right) || (parent == null && !covered.contains(root))) {
            covered.add(root);
            covered.add(parent);
            covered.add(root.left);
            covered.add(root.right);
            ans++;
        }
    }
    
    public int minCameraCover(TreeNode root) {
        covered = new HashSet<>();
        covered.add(null);
        dfs(root, null);
        return ans;
    }
}