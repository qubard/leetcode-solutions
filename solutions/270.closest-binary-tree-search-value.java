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
    Double minDist = null;
    int closest = -1;
    public int closestValue(TreeNode root, double target) {
        double dist = Math.abs((double)root.val - target);
        
        if (minDist == null || dist < minDist) {
            minDist = dist;
            closest = root.val;
        }
        
        if (root.left != null) {
            closestValue(root.left, target);
        }
            
        if (root.right != null) {
            closestValue(root.right, target);
        }
        
        return closest;
    }
}