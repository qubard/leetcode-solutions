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
        if (node->right != NULL) {
            node = node->right;
            while (node->left != NULL) node = node->left;
            return node;
        }
        
        while (node->parent != NULL && node->parent->right == node) {
            node = node->parent;
        }
        
        return node->parent;
    }
};
