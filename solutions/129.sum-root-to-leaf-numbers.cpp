/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int sumNumbers(TreeNode* root) {
        return recurse(root);
    }
    
    int recurse(TreeNode* root, int s=0) {
        if (root == NULL) return 0;
        if (root->left == NULL && root->right == NULL) return s * 10 + root->val;
        
        return recurse(root->left, s * 10 + root->val) + recurse(root->right, s * 10 + root->val);
    }
};