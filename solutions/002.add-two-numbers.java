/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr = l1;
        ListNode curr2 = l2;
        ListNode head = new ListNode(0);
        ListNode ret = head;
        ListNode zero = new ListNode(0);
        
        int carry = 0;
        while (curr != null || curr2 != null) {
            int val = head.val + (curr != null ? curr.val : 0) + (curr2 != null ? curr2.val : 0);

            carry = val >= 10 ? 1 : 0;
            head.val = val % 10;
            
            if (curr != null)
                curr = curr.next;
            if (curr2 != null)
                curr2 = curr2.next;
            
            if (carry > 0 || !(curr == null && curr2 == null)) {
                head.next = new ListNode(carry);
                head = head.next;
            }
        }
        
        return ret;
    }
}