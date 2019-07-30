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

        while (true) {
            while (curr != null) {
                stk.push(curr);
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    break;
                }
            }
            
            if (curr != null) {
                if (curr.right != null) {
                    curr = stk.pop();
                    ret.add(curr.val);
                } else {
                    while (curr.right == null && !stk.isEmpty()) {
                        curr = stk.pop();
                        ret.add(curr.val);
                    }
                }
                
                curr = curr.right;
            } else {
                break;
            }
            
        }
        
        return ret;
    }
}