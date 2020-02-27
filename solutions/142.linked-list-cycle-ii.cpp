/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        ListNode* slow = head;
        ListNode* fast = head;
        
        if (head == NULL || fast->next == NULL) return NULL;
        
        do {
            slow = slow->next;
            fast = fast->next->next;
        } while (slow != fast && slow != NULL && fast != NULL && fast->next != NULL);
        
        // No cycle
        if (slow == NULL || fast == NULL || fast->next == NULL || fast->next->next == NULL) return NULL;
        
        // From the point of intersection and beginning of list we have them 
        // iterate one node at a time
        // This will give us the start of the cycle when they intersect again
        slow = head;
        
        while (slow != fast) {
            slow = slow->next;
            fast = fast->next;
        }
        
        return slow;
    }
};