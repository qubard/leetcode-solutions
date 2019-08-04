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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
        
        if (root == null) return ret;
        
        q.add(root);
        
        while (!q.isEmpty()) {
            int toRemove = q.size();
            ArrayList<Integer> nodes = new ArrayList<>();    
            
            while (toRemove > 0) {
                TreeNode n = q.remove();
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
                nodes.add(n.val);
                toRemove--;
            }
            
            ret.add(nodes);
        }
        
        Collections.reverse(ret);
        
        return ret;
    }
}