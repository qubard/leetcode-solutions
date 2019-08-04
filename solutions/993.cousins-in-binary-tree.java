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
    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, Integer> levels = new HashMap<>();
        Map<Integer, TreeNode> parents = new HashMap<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        
        q.add(root);
        
        int level = 0;
        while (!q.isEmpty()) {
            int toRemove = q.size();
            while (toRemove > 0) {
                TreeNode n = q.remove();
                levels.put(n.val, level);
                if (n.left != null) { 
                    q.add(n.left);
                    parents.put(n.left.val, n);
                }
                if (n.right != null) { 
                    q.add(n.right);
                    parents.put(n.right.val, n);
                }
                toRemove--;
            }
            level++;
        }
        
        return levels.get(x) == levels.get(y) && parents.get(x) != parents.get(y);
    }
}