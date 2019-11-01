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
    bool isSymmetricHelper(TreeNode* root, TreeNode* other) {
        if (other == NULL && root == NULL) return true;
        if (!(other != NULL && root != NULL)) return false;
        
        if (other->val == root->val) {
            return isSymmetricHelper(root->left, other->right) && isSymmetricHelper(root->right, other->left);
        }
        
        return false;
    }
    
    bool isSymmetric(TreeNode* root) {
        if (root == NULL) return true;
        return isSymmetricHelper(root->left, root->right);
    }
};