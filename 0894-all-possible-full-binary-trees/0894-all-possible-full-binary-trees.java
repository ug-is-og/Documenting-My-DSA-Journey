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

// yeh solution bhi infact galat hi hai due to a wrong observation, tumne yeh socha ki harr ek row mein kewal or or two nodes reh sakte jo bilkul galat hai, question mein bola tha ki harr node ka 0 or two children ho sakta, both are different things

// class Solution {
//     public List<TreeNode> allPossibleFBT(int n) {
//         List<TreeNode> list=new ArrayList<>();
//         TreeNode root=new TreeNode(0);
//         List<TreeNode> temp=new ArrayList<>();
//         temp.add(root);
//         helper(root,n-1,temp,list);
//         return list;
//     }
//     public void helper(TreeNode root,int n,List<TreeNode> temp,List<TreeNode> list)
//     {
//         if(n==0)
//         {
//             List<TreeNode> newList=new ArrayList<>(temp);
//             // iss code mein kari hui galti ko smajho, ham final list mein kewal ek element add kar re newList ka and that is the reference of root, ab since tum refernce add kar re and root ka left and right constantly chnage ho ra iss liye galat ans aa ja raha , yeh tareeka nah laga sakte tum kyunki fir tumhe duplicate nodes banane padenge baar baar har ek possibility ke liye which is not feasible at all

//             // generally aese questons mein hame kewal ek list add kar deni hoti par yahan kame reference add karna pad ra..

//             list.add(newList.get(0));
//             return;
//         }
//         TreeNode leftNode=new TreeNode(0);
//         TreeNode rightNode=new TreeNode(0);
//         root.left=leftNode;
//         root.right=rightNode;
//         temp.add(leftNode);
//         temp.add(rightNode);
//         helper(leftNode,n-2,temp,list);
//         if(leftNode.left!=null)
//         {
//             temp.remove(temp.size()-1);
//             temp.remove(temp.size()-1);
//             leftNode.left=null;
//             leftNode.right=null;
//         }
//         helper(rightNode,n-2,temp,list);
//         if(rightNode.left!=null)
//         {
//             temp.remove(temp.size()-1);
//             temp.remove(temp.size()-1);
//             rightNode.left=null;
//             rightNode.right=null;
//         }
//     }
// }


// Let's look for the correct approach
// agar tum isko kewal recursively kar re tab tum fresh node references banaoge harr ek ke 
// but jaise hi tum memoize karoge , tum purane node references use karne lagoge
// hence iss question mein ham deep equals pe focus kar re

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

class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        HashMap<Integer,List<TreeNode>> map=new HashMap<>();
        return helper(n,map);
    }
    public List<TreeNode> helper(int n,HashMap<Integer,List<TreeNode>> map)
    {
        if(n%2==0)
        return new ArrayList<>();
        List<TreeNode> list=new ArrayList<>();
        if(n==1)
        {
            TreeNode root=new TreeNode(0);
            list.add(root);
            return list;
        }
        if(map.containsKey(n))
        return map.get(n);
        for(int i=2;i<=n;i+=2)
        {
            List<TreeNode> leftFBT=helper(i-1,map);
            List<TreeNode> rightFBT=helper(n-i,map);
            for(TreeNode leftNode:leftFBT)
            {
                for(TreeNode rightNode:rightFBT)
                {
                    TreeNode root=new TreeNode(0);
                    root.left=leftNode;
                    root.right=rightNode;
                    list.add(root);
                }
            }
        }
        map.put(n,list);
        return list;
    }
}
