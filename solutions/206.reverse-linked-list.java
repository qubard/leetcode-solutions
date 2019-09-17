/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        if (head == null) return null;
        while (curr.next != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        curr.next = prev;
        return curr;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }

// Go down the stack to the last node and reverse pointers then return last node
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) 
            return head;
        ListNode ret = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }
}

*/