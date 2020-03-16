/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public boolean isValidBST(TreeNode root) {
      if (root == null) return true;
      
      // A BST is valid if the inorder traversal
      // is sorted in ascending order. So we do
      // an iterative-inorder traversal.
      Stack<TreeNode> stk = new Stack<>();
      TreeNode curr = root;
      TreeNode prev = null;
      
      while (curr != null || !stk.isEmpty()) {
          while (curr != null) {
            stk.push(curr);
            curr = curr.left;
          }
          
          curr = stk.pop();
          // Look at curr's value, is it bigger then the prev?
          if (prev == null || prev.val < curr.val) {
              prev = curr;
          } else if (prev.val >= curr.val) {
              return false;
          }
          
          curr = curr.right;
      }
      return true;
  }
}


/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 /* 
 // Recursive solution
#include <climits> 
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        return isValid(root, NULL, NULL);
    }
    
    bool isValid(TreeNode* root, int* min, int* max) {
        if (root == NULL) return true;
        
        if ((min != NULL && root->val <= *min) || (max != NULL && root->val >= *max)) {
            return false;
        }
        
        return isValid(root->left, min, &root->val) && isValid(root->right, &root->val, max);
    }
};
*/