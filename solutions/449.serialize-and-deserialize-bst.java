/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Idea is to encode nulls as "-" and just do a pre-order traversal
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        LinkedList<String> list = new LinkedList<>();
        serializeHelper(root, list); // dfs to add to list
        return String.join(",", list);
    }
    
    public void serializeHelper(TreeNode root, List<String> list) {
        if (root == null) { 
            list.add("-");
            return;
        }
        list.add(String.valueOf(root.val));
        serializeHelper(root.left, list);
        serializeHelper(root.right, list);
    }
    
    public TreeNode deserializeHelper(LinkedList<String> list) {
        String rootVal = list.poll();
        if (rootVal.equals("-"))
            return null; // null node
        
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        root.left = deserializeHelper(list);
        root.right = deserializeHelper(list);
        
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        LinkedList<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(list);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));