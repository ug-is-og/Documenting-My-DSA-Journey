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

// class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder()); // concept of max heap...pehle galti se min heap laga diya tha
//         int a[]=new int[1]; // count ka dhyan rakhne ke liye
//         helper(root,pq,k,a);
//         return pq.peek();
//     }
//     public void helper(TreeNode root,PriorityQueue<Integer> pq,int k,int count[])
//     {
//         if(root==null)
//         return;
//         if(count[0]!=k)
//         {
//             pq.add(root.val);
//             count[0]=count[0]+1;
//         }
//         else
//         {
//             if(root.val<pq.peek())
//             {
//                 pq.remove();
//                 pq.add(root.val);
//             }
//         }
//         helper(root.left,pq,k,count);
//         helper(root.right,pq,k,count);
//     }
// }

















// Brute approach

// class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
//         int count[]=new int[1];
//         fillPQ(root,k,pq,count);
//         return pq.peek();
//     }
//     public void fillPQ(TreeNode root,int k,PriorityQueue<Integer> pq,int count[])
//     {
//         if(root==null)
//         {
//             return;
//         }
//         pq.add(root.val);
//         count[0]++;
//         if(count[0]>k)
//         {
//             pq.remove();
//             count[0]--;
//         }
//         fillPQ(root.left,k,pq,count);
//         fillPQ(root.right,k,pq,count);
//     }
// }


// Most optimal approach
// we'll use inorder traversal

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int temp[]=new int[2]; // temp[0] for count, temp[1] for ans
     inorder(root,k,temp);
     return temp[1];
    }
    public void inorder(TreeNode root,int k,int temp[])
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left,k,temp);
        if(temp[0]!=k)
        {
            temp[0]++;
            temp[1]=root.val;
        }
        else
        {
            return;
        }
        inorder(root.right,k,temp);
    }
}