/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) 
            return ",";
        List<String> list = new LinkedList<>();
        serializeHelper(root, list);
        return String.join(",", list);
    }
    
    public void serializeHelper(Node root, List<String> list) {
        list.add(String.valueOf(root.val));
        list.add(String.valueOf(root.children.size()));
        for (Node child : root.children) {
            serializeHelper(child, list);
        }
    }
    
    // This problem a lot less difficult if you encode your list as root.val, root.children.size, root.children (if they exist)
    
    public Node deserializeHelper(LinkedList<Integer> list) {
        Node root = new Node(list.poll());
        root.children = new ArrayList<>();
        int size = list.poll();
        for (int i = 0; i < size; i++) {
            root.children.add(deserializeHelper(list));
        }
        return root;
    }
    
    
    // Encode our tree as root.val,size of children,children...
    public Node deserialize(String data) {
        // Convert the data to a linked list
        LinkedList<Integer> list = new LinkedList<>();
        for (String s : data.split(",")) {
            list.add(Integer.parseInt(s));
        } // No idea how to one-line this
        
        if (list.isEmpty())
            return null;
        
        return deserializeHelper(list);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));