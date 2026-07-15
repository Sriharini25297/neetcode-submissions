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
    int idx = 0;
    TreeNode getTree(int preorder[],Map<Integer,Integer> mp,int left,int right)
    {
        if(left>=right)
            return null;
        int val = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(val);
        int point = mp.get(val);
        root.left = getTree(preorder,mp,left,point);
        root.right = getTree(preorder,mp,point+1,right);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> mp = new HashMap<>();
        int n = inorder.length;
        for(int i=0;i<n;i++)
            mp.put(inorder[i],i);
        return getTree(preorder,mp,0,n);
    }
}
