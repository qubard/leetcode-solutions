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
    List<List<Integer>> paths = new ArrayList<List<Integer>>();
    
    public void pathSum(TreeNode root, int sum, ArrayList<Integer> acc) {
        if (root == null) return;
        
        if (root.left != null) {
            acc.add(root.val);
            pathSum(root.left, sum - root.val, acc);
            acc.remove(acc.size() - 1);
        }
        
        if (root.right != null) {
            acc.add(root.val);
            pathSum(root.right, sum - root.val, acc);
            acc.remove(acc.size() - 1);
        }
        
        if (root.right == null && root.left == null) {
            if (sum == root.val) {
                acc.add(root.val);
                paths.add((ArrayList<Integer>)acc.clone());
                acc.remove(acc.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<Integer> stk = new ArrayList<Integer>();
        pathSum(root, sum, stk);
        return paths;
    }
}