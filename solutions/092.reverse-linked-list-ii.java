/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode rest = null;
    
    // The idea is to reverse from [m, n] recursively then 
    // just attach the rest at the end
    public ListNode reverse(ListNode head, int n) {
        if (head == null || head.next == null || n <= 1) {
            if (head != null) rest = head.next;
            return head;
        }
        ListNode ret = reverse(head.next, n - 1);
        head.next.next = head;
        head.next = rest;
        return ret;
    }
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m <= 1) {
            return reverse(head, n);
        }
        
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
}