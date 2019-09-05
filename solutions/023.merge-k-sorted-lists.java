/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode node : lists) {
            ListNode curr = node;
            while (curr != null) {
                pq.add(curr.val);
                curr = curr.next;
            }
        }
        
        if (pq.isEmpty()) {
            return null;
        }
        
        ListNode root = new ListNode(0);
        ListNode curr = root;
        while (!pq.isEmpty()){ 
            curr.val = pq.poll();
            if (!pq.isEmpty()) {
                curr.next = new ListNode(0);
                curr = curr.next;
            }
        }
        
        return root;
    }
}