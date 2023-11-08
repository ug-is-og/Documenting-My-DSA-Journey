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

// mein galat direction mein soch raha tha question ko, backtracking toh lagegi hi
// par tum yeh soch rahe the ki saari binary tree ki possibility nikla lete hai and then ham
// validate karle binary trees ko

// using recursion+backtracking in this question

// class Solution {
//     public List<TreeNode> generateTrees(int n) {
//         return helper(1,n);
//     }
//     public List<TreeNode> helper(int start,int end)
//     {
//         List<TreeNode> variations=new ArrayList<>();
//         if(start>end)
//         {
//             variations.add(null);
//             return variations;
//         }
//         for(int i=start;i<=end;i++)
//         {
//             List<TreeNode> leftSubTrees=helper(start,i-1);
//             List<TreeNode> rightSubTrees=helper(i+1,end);
//             for(TreeNode left:leftSubTrees)
//             {
//                 for(TreeNode right:rightSubTrees)
//                 {
//                     TreeNode root=new TreeNode(i,left,right);
//                     variations.add(root);
//                 }
//             }
//         }
//         return variations;
//     }
// }

// using memoization on above approach

// class Solution {
//     public List<TreeNode> generateTrees(int n) {
//         HashMap<Pair<Integer,Integer>,List<TreeNode>> map=new HashMap<>();
//         return helper(1,n,map);
//     }
//     public List<TreeNode> helper(int start,int end,HashMap<Pair<Integer,Integer>,List<TreeNode>> map)
//     {
//         List<TreeNode> variations=new ArrayList<>();
//         if(start>end)
//         {
//             variations.add(null);
//             return variations;
//         }
//         // pair class performs deep comparison that means only the 2 values will be checked
//         // whether they are equal or not toh reference check karne wali jhanjhat nahi hai
//         if(map.containsKey(new Pair<>(start,end)))
//         return map.get(new Pair<>(start,end));
//         for(int i=start;i<=end;i++)
//         {
//             List<TreeNode> leftSubTrees=helper(start,i-1,map);
//             List<TreeNode> rightSubTrees=helper(i+1,end,map);
//             for(TreeNode left:leftSubTrees)
//             {
//                 for(TreeNode right:rightSubTrees)
//                 {
//                     TreeNode root=new TreeNode(i,left,right);
//                     variations.add(root);
//                 }
//             }
//         }
//         map.put(new Pair<>(start,end),variations);
//         return variations;
//     }
// }





class Solution {
    public List<TreeNode> generateTrees(int n) {
        HashMap<String,List<TreeNode>> map=new HashMap<>();
        return helper(map,1,n,n);
    }
    public List<TreeNode> helper(HashMap<String,List<TreeNode>> map,int i,int j,int n)
    {
        List<TreeNode> list=new ArrayList<>();
        if(i>j)
        {
            list.add(null); // very very important line, agar nahi karoge toh jo neeche outer and inner loop lagaya hai left and right subtree ka woh kabhi execute hi nahi hoyega kyunki size 0 ja ra list ka bar bar
            return list;
        }
        if(map.containsKey(i+"_"+j))
        {
            return map.get(i+"_"+j);
        }
        for(int k=i;k<=j;k++)
        {
            List<TreeNode> leftTrees=helper(map,i,k-1,n);
            List<TreeNode> rightTrees=helper(map,k+1,j,n);
            for(TreeNode leftTree:leftTrees)
            {
                for(TreeNode rightTree:rightTrees)
                {
                    TreeNode root=new TreeNode(k);
                    root.left=leftTree;
                    root.right=rightTree;
                    list.add(root);
                }
            }
        }
        map.put(i+"_"+j,list);
        return list;
    }
}