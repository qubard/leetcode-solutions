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
    int len(ListNode* l1) {
        int l = 0;
        while (l1 != NULL) {
            l1 = l1->next;
            l++;
        }
        return l;
    }
    
    ListNode* end(ListNode* l1) {
        while (l1->next != NULL) {
            l1 = l1->next;
        }
        return l1;
    }
    
    int carry = 0;
    ListNode * res;
    
    void add(ListNode* a, ListNode* b) {
        if (a->next == NULL && b->next == NULL) {
            int sum = carry + a->val + b->val;
            carry = sum/10;
            
            ListNode* head = new ListNode(sum % 10);
            res = head;
            return;
        }
        
        // Add depth first
        // Prepend new values to res
        add(a->next, b->next);
        
        int sum = carry + a->val + b->val;
        ListNode* head = new ListNode(sum % 10);
        carry = sum >= 10 ? 1 : 0;
        head->next = res;
        res = head;
    }
    
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int l1_len = len(l1);
        int l2_len = len(l2);
        
        if (l1_len - l2_len != 0) {
            ListNode* pad = l1_len > l2_len ? l2 : l1;
            int diff = abs(l1_len - l2_len);
            
            while (diff > 0) {
                ListNode* p = new ListNode(0);
                p->next = pad;
                pad = p;
                diff--;
            }
            
            if (l1_len > l2_len) {
                l2 = pad;
            } else {
                l1 = pad;
            }
        }
        
        add(l1, l2);
        
        // Last carry bit
        if (carry > 0) {
            ListNode* p = new ListNode(carry);
            p->next = res;
            return p;
        }
        
        return res;
    }
};