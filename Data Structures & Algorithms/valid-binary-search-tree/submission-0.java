/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    boolean isValid(TreeNode root,int maxi,int mini)
    {
        if(root == null)
            return true;
        if(root.val>=maxi || root.val<=mini)
            return false;
        return isValid(root.left,root.val,mini) && isValid(root.right,maxi,root.val);
    }
    public boolean isValidBST(TreeNode root) {
        return isValid(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
}
