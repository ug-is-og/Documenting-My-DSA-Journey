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

// Using 1 stack 

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        helper(root,st);
        int size=st.size();
        for(int i=0;i<size;i++)
        {
            ans.add(st.pop());
        }
        return ans;
    }
    public void helper(TreeNode root,Stack<Integer> stack)
    {
        if(root==null)
        {
            return;
        }
        stack.push(root.val);
        helper(root.right,stack);
        helper(root.left,stack);
    }
}