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
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int maxDepth = -1;
    
    public void dfs(TreeNode root, int depth) {
        if (!map.containsKey(depth)) {
            map.put(depth, new LinkedList<Integer>());
            maxDepth = Math.max(depth, maxDepth);
        }
        
        if (depth % 2 == 0) {
            map.get(depth).add(root.val); // O(1) add to end of linked list
        } else {
            map.get(depth).add(0, root.val); // O(1) add to front of linked list
        }
        
        if (root.left != null) {
            dfs(root.left, depth + 1);
        }
        
        if (root.right != null) {
            dfs(root.right, depth + 1);
        }
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> sol = new ArrayList<>();
        if (root != null) dfs(root, 0);
        for (int i = 0; i <= maxDepth; i++) {
            sol.add(map.get(i));
        }
        return sol;
    }
}