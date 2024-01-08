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

// brute force approach

// class Solution {
//     public int rangeSumBST(TreeNode root, int low, int high) {
//         if(root==null)
//         return 0;
//         int totalSum=0;
//         int leftSum=rangeSumBST(root.left,low,high);
//         int rightSum=rangeSumBST(root.right,low,high);
//         if(root.val>=low&&root.val<=high)
//         totalSum=leftSum+rightSum+root.val;
//         else
//         totalSum=leftSum+rightSum;
//         return totalSum;
//     }
// }

// a better approach

// class Solution {
//     public int rangeSumBST(TreeNode root, int low, int high) {
//         if(root==null)
//         return 0;
//         int sum=0;
//         if(root.val>=low&&root.val<=high)
//         sum=root.val+rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
//         else if(root.val<low)
//         sum=rangeSumBST(root.right,low,high);
//         else
//         sum=rangeSumBST(root.left,low,high);
//         return sum;
//     }
// }
















// most optimal approach

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null)
        {
            return 0;
        }
        int sum=0;
        if(root.val>=low&&root.val<=high)
        sum=sum+root.val;
        if(root.val>low)
        {
            sum=sum+rangeSumBST(root.left,low,high);   
        }
        if(root.val<high)
        {
            sum=sum+rangeSumBST(root.right,low,high);
        }
        return sum;
    }
}