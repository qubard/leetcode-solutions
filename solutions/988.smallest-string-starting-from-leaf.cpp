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
    string sol;
    string smallestFromLeaf(TreeNode* root) {
        string tmp;
        dfs(root, tmp);

        return sol;
    }
    
    void dfs(TreeNode* node, string& tmp) {
        if (node == NULL) return;
        
        tmp += node->val + 'a';
        
        if (node->left == NULL && node->right == NULL) {
            // leaf;
            // check solution against currsol
            reverse(tmp.begin(), tmp.end());
            if (sol.size() == 0 || tmp < sol) {
                sol = tmp;
            }
            reverse(tmp.begin(), tmp.end());
        }
        
        dfs(node->left, tmp);
        dfs(node->right, tmp);
        
        tmp.pop_back();
    }
};