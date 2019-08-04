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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        ArrayList<Double> avgs = new ArrayList<>();
        // At each level we keep track of the size of the queue, pop off that many values, add them to the average
        // when it hits 0 we add to our list of averages
        q.add(root);
        
        while (!q.isEmpty()) {
            int toRemove = q.size();
            double div = (double)q.size();
            double avg = 0.0;
            while (toRemove > 0) {
                TreeNode n = q.remove();
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
                avg += n.val;
                toRemove--;
            }
            avg = avg / div;
            avgs.add(avg);
        }
        
        return avgs;
    }
}