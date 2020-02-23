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
    int rootIdx = 0;
    TreeNode* buildTreeHelper(int i, int j, vector<int>& preorder, vector<int>& inorder, unordered_map<int,int>& mp) {
        if (i > j || i >= preorder.size() || i < 0 || rootIdx >= preorder.size()) {
            return NULL;
        }
        
        int root = preorder[rootIdx];
        TreeNode* node = new TreeNode(root);
        
        int k = mp[root];
      
        rootIdx++;
        node->left = buildTreeHelper(i, k - 1, preorder, inorder, mp);
        node->right = buildTreeHelper(k + 1, j, preorder, inorder, mp);
        
        return node;
    }
    
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if (!(preorder.size() > 0 && inorder.size() > 0)) {
            return NULL;
        }
        
        unordered_map<int, int> mp;
        
        for (int i = 0; i < inorder.size(); i++) {
            mp[inorder[i]] = i;
        }
        
        return buildTreeHelper(0, inorder.size() - 1, preorder, inorder, mp);
    }
};