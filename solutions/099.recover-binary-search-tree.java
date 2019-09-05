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

    List<Integer> nodes = new ArrayList<>();
    
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        nodes.add(root.val);
        inorder(root.right);
    }
    
    public void replace(TreeNode root, int x, int y) {
        if (root == null) return;
        replace(root.left, x, y);
        if (root.val == x) {
            root.val = y;
        } else if (root.val == y) {
            root.val = x;
        }
        replace(root.right, x, y);
    }
    
    public void recoverTree(TreeNode root) {
        // Do an inorder traversal to make sorted
        // list and then check for swaps
        inorder(root);
        int x = -1;
        int y = -1;
        for (int i = 0; i < nodes.size() - 1; i++) {
            if (nodes.get(i) > nodes.get(i + 1)) {
                y = nodes.get(i + 1);
                if (x == -1) {
                    x = nodes.get(i);
                } else {
                    break;
                }
            }
        }
        replace(root, x, y);
    }
}