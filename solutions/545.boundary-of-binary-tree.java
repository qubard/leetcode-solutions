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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        // Comptue left boundary, leaves and then right boundary :)
        // You can get leaves using pre-order traversal, kind of annoying but w.e
        
        TreeNode curr = root;
        ArrayList<Integer> sol = new ArrayList<>();
        if (root == null) return sol;
        
        ArrayDeque<TreeNode> stk = new ArrayDeque<>();
        
        if (curr.left == null) {
            sol.add(curr.val);
        } else {
            while (curr != null) {
                if (!(curr.left == null && curr.right == null))
                    sol.add(curr.val);
                if (curr.left == null && curr.right != null) {
                    curr = curr.right;
                } else {
                    curr = curr.left;
                }
            }
        }
        
        // do dfs preorder traversal again
        // find leaves
        curr = root;
        
        stk.push(curr);
        while (!stk.isEmpty()) {
            curr = stk.pop();
            if (curr != null && curr.right != null)
                stk.push(curr.right);
            
            if (curr != null &&  curr.left != null)
                stk.push(curr.left);
            
            if (curr != root && curr != null && curr.left == null && curr.right == null) {
                sol.add(curr.val);
            }
        }
        
        curr = root;
        ArrayDeque<TreeNode> stk2 = new ArrayDeque<>();
        while (curr != null) {
            if (curr != root && !(curr.left == null && curr.right == null))
                stk2.push(curr);
            if (curr != root && curr.right == null && curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        
        while (!stk2.isEmpty()) sol.add(stk2.pop().val);
        
        return sol;
    }
}