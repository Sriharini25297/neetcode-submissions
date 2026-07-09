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
    Map<TreeNode,Integer> mp = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        if(mp.containsKey(root))
            return mp.get(root);
        int res = root.val;
        if(root.left!=null)
            res += rob(root.left.left) + rob(root.left.right);
        if(root.right!=null)
            res += rob(root.right.left)+rob(root.right.right);
        res = Math.max(res,rob(root.left)+rob(root.right));
        mp.put(root,res);
        return res;
    }
}