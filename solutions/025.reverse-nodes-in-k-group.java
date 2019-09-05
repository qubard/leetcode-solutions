/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            n++;
        }
        
        if (n < k || n == 1) {
            return head;
        }
        
        // We count the number of nodes
        // swap curr node next to previous node
        // but keep the curr node next for next iteration
        // Do it recursively so the end gets reversed first
        // (dependency graph)
        curr = head;
        
        ListNode ret = null;
        ListNode tail = curr;
        ListNode prev = curr;
        ListNode next = curr.next;
        int tk = k;
        while (tk > 0) {
            curr = next;
            // if this is the last iteration point tail
            if (tk == 1) {
                // Reverse the next group
                tail.next = next == null ? null : reverseKGroup(next, k);
                return prev;
            }
            next = curr.next;
            curr.next = prev;
            prev = curr;
            tk--;
        }
        return curr;
    }
}