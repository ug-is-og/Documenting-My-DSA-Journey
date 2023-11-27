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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
        {
            return false;
        }
        return helper(root,targetSum);
    }
    public boolean helper(TreeNode root,int targetSum)
    {
        boolean ans1=false,ans2=false;
        if(root.left==null&&root.right==null&&targetSum-root.val==0)
        return true;
        if(root.left!=null)
        ans1=helper(root.left,targetSum-root.val);
        if(root.right!=null)
        ans2=helper(root.right,targetSum-root.val);
        return ans1||ans2;
    }
}