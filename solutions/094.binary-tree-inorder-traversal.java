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
    ArrayList<Integer> ret = new ArrayList<>();
    Stack<TreeNode> stk = new Stack<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return ret;

        TreeNode curr = root;

        while (curr != null || !stk.isEmpty()) {
            while (curr != null) {
                stk.push(curr);
                curr = curr.left;
            }
            
            curr = stk.pop();
            ret.add(curr.val);
            curr = curr.right;
        }
        
        return ret;
    }
}