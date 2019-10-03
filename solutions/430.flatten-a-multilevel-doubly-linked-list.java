/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        head.next = flatten(head.next);
        
        if (head.child != null) {
            head.child = flatten(head.child);
            
            // Go to the end of the flattened child and attach flattened head.next
            Node temp = head.child;
            while (temp.next != null) temp = temp.next;
            temp.next = head.next;
            
            // Update previous pointers
            if (head.next != null)
                head.next.prev = temp;
            head.child.prev = head;
            
            // Swap them
            head.next = head.child;
            head.child = null;
        }
        
        return head;
    }
}