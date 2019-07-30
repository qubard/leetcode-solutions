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

    // sum, count
    Map<Integer, Integer> h = new HashMap<>();
    
    public int subTreeSum(TreeNode root) {
        if (root == null) return 0;
        
        int sum = root.val + subTreeSum(root.left) + subTreeSum(root.right);
        int k = h.getOrDefault(sum, 0);
        h.put(sum, k + 1);
        return sum;
    }
    
    public int[] findFrequentTreeSum(TreeNode root) {
        subTreeSum(root);
        int maxSum = h.values().stream().max(Comparator.naturalOrder()).orElse(0);

        return h.keySet().stream().filter(k -> h.get(k) == maxSum).mapToInt(i -> i).toArray();
    }
}