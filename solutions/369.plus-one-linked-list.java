/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean carry = false;
    public ListNode plus(ListNode head) {
        ListNode curr = head;
        
        if (curr.next == null) {
            curr.val = (curr.val + 1) % 10;
            carry = curr.val == 0;
            return curr;
        }
        plus(curr.next);
        if (carry) {
            curr.val = (curr.val + 1) % 10;
            carry = curr.val == 0;
        }
        return curr;
    }
    
    public ListNode plusOne(ListNode head) {
        ListNode ret = plus(head);
        if (ret.val == 0) {
            ListNode h = new ListNode(1);
            h.next = ret;
            return h;
        }
        return ret;
    }
}