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
    int count = 0;
    void findNodes(TreeNode root,int maxi)
    {
        if(root == null)
            return;
        if(root.val >= maxi){
            count++;
        }
        maxi = Math.max(maxi,root.val);
            findNodes(root.left,maxi);
            findNodes(root.right,maxi);
    }
    public int goodNodes(TreeNode root) {
        if(root == null)
            return 0;
       findNodes(root,root.val);
       return count;
    }
}
