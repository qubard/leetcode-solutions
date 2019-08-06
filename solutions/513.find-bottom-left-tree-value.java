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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        
        queue.add(root);
        int leftmost = 0;
        
        // You can also do DFS in-order traversal and use a global variable to keep track of
        // the maxDepth node (first visiting left, then right, updating if depth > maxDepth),
        // by definition the leftmost node at any depth i is updated first
        
        while (!queue.isEmpty()) {
            int toRemove = queue.size();
            
            if (toRemove > 0) {
                TreeNode node = queue.remove();
                leftmost = node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                toRemove--;
            }
            
            while (toRemove > 0) {
                TreeNode node = queue.remove();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                toRemove--;
            }
        }
        return leftmost;
    }
}