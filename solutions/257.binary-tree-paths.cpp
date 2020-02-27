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
    vector<string> sol;
    vector<string> binaryTreePaths(TreeNode* root) {
        if (root == NULL) return sol;
        
        dfs(root, "");
        return sol;
    }
    
    void dfs(TreeNode* root, string tmp) {
        if (root == NULL) return;
        
        if (tmp != "") tmp += "->";
        
        tmp += to_string(root->val);
        
        if (root->left == NULL && root->right == NULL) {
            sol.push_back(tmp);
            return;
        }
        
        dfs(root->left, tmp);
        dfs(root->right, tmp);
    }
};