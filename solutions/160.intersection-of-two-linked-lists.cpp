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
    void shift(int s, ListNode** a) {
        while (s > 0 && *a != NULL) {
            *a = (*a)->next;
            s--;
        }
    }
    
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode* tmpA = headA;
        
        int lenA = 1;
        int lenB = 1;
        
        if (headA == NULL || headB == NULL) return NULL;
        
        while (tmpA->next != NULL) {
            tmpA = tmpA->next;
            lenA++;
        }
        
        ListNode* tmpB = headB;
        while (tmpB->next != NULL) {
            tmpB = tmpB->next;
            lenB++;
        }
        
        if (tmpA != tmpB) {
            return NULL;
        }
        
        shift(abs(lenA - lenB), lenA > lenB ? &headA : &headB);
        
        while (headA != headB) {
            headA = headA->next;
            headB = headB->next;
        }
        
        return headA;
    }
};