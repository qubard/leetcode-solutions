/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Use a stack and unfold the last n nodes
        ArrayDeque<ListNode> stk = new ArrayDeque<>();
        ListNode curr = head;
        while (curr != null) {
            stk.push(curr);
            curr = curr.next;
        }
        
        ListNode last = null;
        while (n - 1 > 0) {
            last = stk.pop();
            n--;
        }
        stk.pop();
        if (stk.isEmpty()) 
            return head.next;
        stk.peek().next = last;
        return head;
        // Last is what we continue at, top of stk is what we remove
    }
}

// Another solution involves using two pointers one that is n nodes away from the first
// So that when one of the pointers reaches the end you have arrived at the position to
// remove the node