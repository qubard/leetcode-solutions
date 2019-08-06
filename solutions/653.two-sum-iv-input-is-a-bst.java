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
    public boolean findTarget(TreeNode root, int k) {
        // inorder traversal and then store the values in a set
        Set<Integer> s = new HashSet<Integer>();
        Stack<TreeNode> stk = new Stack<>();
        
        TreeNode curr = root;
        
        while (curr != null || !stk.isEmpty()) {
            while (curr != null) {
                stk.push(curr);
                curr = curr.left;
            }
            
            // curr we process
            curr = stk.pop();
            if (s.contains(k - curr.val))
                return true;
            s.add(curr.val);
            curr = curr.right;
        }
        return false;
    }
}