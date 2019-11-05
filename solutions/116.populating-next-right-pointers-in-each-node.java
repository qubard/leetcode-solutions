/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        for (Node head = root; head != null && head.left != null; head = head.left) {
            for (Node current = head; current != null; current = current.next) {
                current.left.next = current.right;
                if (current.next != null)
                    current.right.next = current.next.left;
            }
        }
        
        return root;
    }
}