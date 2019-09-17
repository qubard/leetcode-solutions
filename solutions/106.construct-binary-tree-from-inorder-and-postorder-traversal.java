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
    int postRight;
    public TreeNode buildTree(int[] inorder, int[] postorder, int iLeft, int iRight) {
        // Using postorder we can determine root of tree, using in order we can determine left/right nodes
        // We just look for the first root 
        // When our inorder list is one nodee we stop
        if (iRight < iLeft || iLeft > iRight) return null;
        
        TreeNode root = new TreeNode(postorder[postRight]);
        postRight--;
        
        // Can use a hashmap here
        int i = iLeft;
        while(i < iRight) {
            if (inorder[i] == root.val) {
                break;
            }
            i++;
        }
        
        root.right = buildTree(inorder, postorder, i + 1, iRight);
        root.left = buildTree(inorder, postorder, iLeft, i - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postRight = postorder.length - 1;
        return buildTree(inorder, postorder, 0, postRight);
    }
}