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
    public int minDiffInBST(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();

        TreeNode curr = root;
        TreeNode last = null;
        
        int sol = Integer.MAX_VALUE;

        while (curr != null || !stk.isEmpty()) {
            while (curr != null) {
                stk.push(curr);
                curr = curr.left;
            }

            // curr we process
            curr = stk.pop();
            if (last != null)
                sol = Math.min(sol, curr.val - last.val);
            last = curr;
            curr = curr.right;
        }
        
        return sol;
    }
}