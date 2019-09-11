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
    List<TreeNode> sol = new ArrayList<>();
    
    public TreeNode delNodes(TreeNode root, Set<Integer> to_delete, int d) {
        if (root == null) return root;
        
        if (!to_delete.contains(root.val)) {
            // don't delete this node
            if (d == 0)
                sol.add(root);
            root.left = delNodes(root.left, to_delete, d + 1);
            root.right = delNodes(root.right, to_delete, d + 1);
            return root;
        }
        // We deleted the current node, traverse and add the roots of the left and right
        delNodes(root.left, to_delete, 0);
        delNodes(root.right, to_delete, 0);
        return null;
    }
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> del = new HashSet<>();
        for (int i : to_delete) del.add(i);
        delNodes(root, del, 0);
        return sol;
    }
}