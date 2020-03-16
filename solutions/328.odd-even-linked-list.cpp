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
    ListNode* oddEvenList(ListNode* head) {
        if (head == NULL) return NULL;
        ListNode* curr = head;
        ListNode* even = head->next;
        // curr->next == even so even.next != NULL (observe that for the case when n <= 2 we don't need to run this loop)
        // so when we have 3 elements when there is no way to pair with the next odd element we stop
        // ie curr->next->next != NULL
        while (curr != NULL && curr->next != NULL && curr->next->next != NULL) {
            ListNode * tmp = curr->next->next;
            curr->next->next = curr->next->next != NULL ? curr->next->next->next : NULL;
            curr->next = tmp;
            curr = curr->next;
        }
        
        if (curr != NULL)
            curr->next = even;
        return head;
    }
};