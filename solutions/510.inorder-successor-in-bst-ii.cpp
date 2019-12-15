/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* parent;
};
*/
class Solution {
public:
    Node* inorderSuccessor(Node* node) {
        Node* root = node;

        while (root->parent != NULL) root = root->parent;

        std::stack<Node*> stk;
        Node* curr = root;
        while (!stk.empty() || curr != NULL) {
            while (curr != NULL) {
                stk.push(curr);
                curr = curr->left;
            }

            curr = stk.top();
            stk.pop();
            // process curr
            if (curr->val > node->val) {
                return curr;
            }

            curr = curr->right;
        }

        return NULL;
    }
};
