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
    ListNode* midpoint(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        while (fast != NULL && fast->next != NULL) {
            slow = slow->next;
            fast = fast->next->next;
        }
        return slow;
    }
    // Stack frames let us do a deallocation so this is fast
    ListNode* merge(ListNode* a, ListNode* b) {
        ListNode* dummy = new ListNode(0);
        ListNode* hdummy = dummy;
        while (a != NULL || b != NULL) {
            if (a == NULL) {
                // append b to tail
                dummy->next = b;
                break;
            } else if (b == NULL) {
                // append a to tail
                dummy->next = a;
                break;
            } else {
                if (a->val <= b->val) {
                    // append a to dummy
                    // we're using the existing ->next pointer
                    // so this is still constant space
                    // we didn't allocate any new bytes
                    dummy->next = a;
                    a = a->next;
                    dummy->next->next = NULL;
                } else {
                    // b < a
                    // append b to dummy
                    dummy->next = b;
                    b = b->next;
                    dummy->next->next = NULL;
                }
            }
            
            dummy = dummy->next;
        }
        return hdummy->next;
    }
    ListNode* sortList(ListNode* head) {
        // 3 steps:
        // Split list into left and right halves O(N) time
        if (head == NULL || head->next == NULL) {
            return head; // Only one node
        }
        
        if (head->next->next == NULL) {
            // Two nodes
            if (head->val <= head->next->val)
                return head;

            head->next->next = head;
            ListNode* tmp = head->next;
            head->next = NULL;
            return tmp;
        }
        
        ListNode* slow = midpoint(head);
        
        // Slow is now at the midpoint
        ListNode* b = slow->next;
        slow->next = NULL;
        b = sortList(b);

        // This technically isn't O(1) space because
        // we do a tmp allocation each time when merging
        // a, b split
        // The irony here is mergesort is definitely never constant space 
        // if you allocate in merge()
        ListNode* a = sortList(head);

        // Sort them using a recursive call to sortList
        // Merge them
        return merge(a, b);
    }
};