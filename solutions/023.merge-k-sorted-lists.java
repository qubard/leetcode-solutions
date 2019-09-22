/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // O(N Logk) solution
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for (ListNode node : lists) {
            ListNode curr = node;
            if (curr != null)
                pq.add(curr);
        }
        
        if (pq.isEmpty()) {
            return null;
        }
        
        ListNode root = new ListNode(0);
        ListNode curr = root;
        while (!pq.isEmpty()){ 
            ListNode node = pq.poll();
            curr.val = node.val;
            if (node.next != null) {
                pq.add(node.next);
            }
            
            if (!pq.isEmpty()) {
                curr.next = new ListNode(0);
                curr = curr.next;
            }
        }
        
        return root;
    }
}