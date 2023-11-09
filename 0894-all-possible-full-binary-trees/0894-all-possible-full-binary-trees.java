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

// Let's look for the correct approach
// agar tum isko kewal recursively kar re tab tum fresh node references banaoge harr ek ke 
// but jaise hi tum memoize karoge , tum purane node references use karne lagoge
// hence iss question mein ham deep equals pe focus kar re
// basically hamara code checker kewal values compare karega jaake that is 0

// class Solution {
//     public List<TreeNode> allPossibleFBT(int n) {
//         if(n%2==0)
//         return new ArrayList<>();
//         List<TreeNode> list=new ArrayList<>();
//         if(n==1)
//         {
//             TreeNode root=new TreeNode(0);
//             list.add(root);
//             return list;
//         }
//         for(int i=2;i<=n;i+=2)
//         {
//             //TreeNode root=new TreeNode(0); // yeh bhot badi blunder kari hai dekho, tumhe baar naye treenode root banane padenge kyunki root.left and root.right is getitng changed, toh agar naye nahi banaoge toh saari possibilities store hi nahi ho payengi
//             List<TreeNode> leftFBT=allPossibleFBT(i-1);
//             List<TreeNode> rightFBT=allPossibleFBT(n-i);
//             for(TreeNode leftNode:leftFBT)
//             {
//                 for(TreeNode rightNode:rightFBT)
//                 {
//                     TreeNode root=new TreeNode(0);
//                     root.left=leftNode;
//                     root.right=rightNode;
//                     list.add(root);
//                 }
//             }
//         }
//         return list;
//     }
// }

// Recursive approach done, now let's memoize this

// class Solution {
//     public List<TreeNode> allPossibleFBT(int n) {
//         HashMap<Integer,List<TreeNode>> map=new HashMap<>();
//         return helper(n,map);
//     }
//     public List<TreeNode> helper(int n,HashMap<Integer,List<TreeNode>> map)
//     {
//         if(n%2==0)
//         return new ArrayList<>();
//         List<TreeNode> list=new ArrayList<>();
//         if(n==1)
//         {
//             TreeNode root=new TreeNode(0);
//             list.add(root);
//             return list;
//         }
//         if(map.containsKey(n))
//         return map.get(n);
//         for(int i=2;i<=n;i+=2)
//         {
//             List<TreeNode> leftFBT=helper(i-1,map);
//             List<TreeNode> rightFBT=helper(n-i,map);
//             for(TreeNode leftNode:leftFBT)
//             {
//                 for(TreeNode rightNode:rightFBT)
//                 {
//                     TreeNode root=new TreeNode(0);
//                     root.left=leftNode;
//                     root.right=rightNode;
//                     list.add(root);
//                 }
//             }
//         }
//         map.put(n,list);
//         return list;
//     }
// }



// yeh hai similar hi approach bas hamne isme i,j do variables ke saath khel re that decides boundaries, upar waale mein ham kewal no of nodes ke saath khel re, upar wala is a bit more efficient

class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        if(n%2==0)
        {
            return new ArrayList<>();
        }
        HashMap<Pair<Integer,Integer>,List<TreeNode>> map=new HashMap<>();
        return helper(1,n,map);
    }
    public List<TreeNode> helper(int i,int j,HashMap<Pair<Integer,Integer>,List<TreeNode>> map)
    {
        List<TreeNode> list=new ArrayList<>();
        if(i==j)
        {
           list.add(new TreeNode(0));
           return list;
        }
        Pair<Integer,Integer> key=new Pair<>(i,j);
        if(map.containsKey(key))
        {
            return map.get(key);
        }
        for(int k=i;k<=j;k++)
        {
            if(k%2!=0)
            continue;
            List<TreeNode> leftTrees=helper(i,k-1,map);
            List<TreeNode> rightTrees=helper(k+1,j,map);
            for(TreeNode leftTree:leftTrees)
            {
                for(TreeNode rightTree:rightTrees)
                {
                    TreeNode root=new TreeNode(0,leftTree,rightTree);
                    list.add(root);
                }
            }
        }
        map.put(key,list);
        return list;
    }
}
