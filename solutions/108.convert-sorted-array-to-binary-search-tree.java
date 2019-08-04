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
    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (nums.length == 0) return null;
        
        int mid = start + (end - start) / 2;
        if (end == start) return new TreeNode(nums[mid]);
        if (end - start == 1) {
            TreeNode root;
            root = new TreeNode(nums[end]);
            root.left = new TreeNode(nums[start]);
            return root;
        }
            
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
}