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
    int solution = 0;
    HashMap<Integer, Integer> depths = new HashMap<>();
    // The trick to this problem is to label each node with an id
    // and then map the id to depth, then lookup the leftmost value for that depth
    // and whenever we see rightmost values update the depth
    // Doing this it doesn't matter if we use DFS or BFS
    
    // If we use BFS the first node is leftmost and the furthest right is rightmost
    // But just keep track of the id (position) again
    
    public void traverse(TreeNode root, int id, int depth) {
        if (!depths.containsKey(depth)) {
            depths.put(depth, id);
            solution = Math.max(solution, 1);
        } else {
            solution = Math.max(solution, id - depths.get(depth) + 1);      
        }
        // Leftmost value in depths[i]
        if (root.left != null) {
            traverse(root.left, 2 * id + 1, depth + 1);
        }
        
        if (root.right != null) {
            traverse(root.right, 2 * id + 2, depth + 1);
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        traverse(root, 0, 0);
        return solution;
    }
}