/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;

    Node() {}

    Node(int _val) {
        val = _val;
        next = NULL;
    }

    Node(int _val, Node* _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
public:
    Node* insert(Node* head, int insertVal) {
        if (head == NULL) {
            head = new Node(insertVal);
            head->next = head;
            return head;
        }
        
        Node* curr = head;
        while (curr != NULL) {
            if ((curr->val <= insertVal && (curr->next->val > insertVal || curr->next->val < curr->val)) || curr->next == head || (curr->next->val < curr->val && insertVal <= curr->next->val)) {
                Node* tmp = curr->next;
                curr->next = new Node(insertVal);
                curr->next->next = tmp;
                break;
            }
            curr = curr->next;
        }
        
        return head;
    }
};