/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        ArrayDeque<Node> stk = new ArrayDeque<>();
        while (curr != null) {
            stk.push(curr);
            curr = curr.next;
        }
        
        // I guess going depth first is not super necessary actually
        
        while (!stk.isEmpty()) {
            curr = stk.pop();
            if (curr != null) {
                Node copy = new Node(curr.val, map.getOrDefault(curr.next, null), curr.random);
                // We will fix the "copies" after
                map.put(curr, copy);
            }
            // copy from the last dependency so we go up the chain backwards
        }
        
        curr = map.get(head);
        
        // Copy random pointers
        while (curr != null) {
            curr.random = map.get(curr.random); // Get copy for random
            curr = curr.next;
        }
        
        return map.get(head);
    }
}