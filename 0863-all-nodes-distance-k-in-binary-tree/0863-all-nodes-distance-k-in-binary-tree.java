/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// pehla observation yeh tha ki yaar hame upar ki direction mein bhi travel karna padega par hamare pass toh kewal left, right hi hai hence hamne kiya level order traversal to build a hashmap that contains parent nodes as well uske baad hamne target ko start node maanke bfs chala diya

//bfs ka concept yaad rakho ki jab tum queue mein add kar re tab hi visited mark kardo

// class queueData{
//     TreeNode node;
//     int distance;
//     public queueData(TreeNode node,int distance)
//     {
//         this.node=node;
//         this.distance=distance;
//     }
// }
// class Solution {
//     public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//         HashMap<TreeNode,TreeNode> parentNode=new HashMap<>();
//         Queue<TreeNode> q=new LinkedList<>();
//         q.add(root);
//         while(!q.isEmpty()) // level order traversal to build parentNode hashmap that stores parent node of a node
//         {
//             TreeNode temp=q.remove();
//             if(temp.left!=null)
//             {
//                 q.add(temp.left);
//                 parentNode.put(temp.left,temp);
//             }
//             if(temp.right!=null)
//             {
//                 q.add(temp.right);
//                 parentNode.put(temp.right,temp);
//             }
//         }
//         Queue<queueData> traverse=new LinkedList<>();
//         traverse.add(new queueData(target,0));
//         HashMap<TreeNode,Boolean> visited=new HashMap<>();
//         visited.put(target,true);
//         List<Integer> ans=new ArrayList<>();
//         while(!traverse.isEmpty()) // bfs traversal starting from target node to find 
//         {
//             queueData temp=traverse.remove();
//             if(temp.distance==k)
//             {
//                 ans.add(temp.node.val);
//                 continue;
//             }
//             TreeNode node=temp.node;
//             if(temp.node.left!=null&&(!visited.containsKey(temp.node.left)))
//             {
//                 visited.put(temp.node.left,true);
//                 traverse.add(new queueData(temp.node.left,temp.distance+1));
//             }
//             if(temp.node.right!=null&&(!visited.containsKey(temp.node.right)))
//             {
//                 visited.put(temp.node.right,true);
//                 traverse.add(new queueData(temp.node.right,temp.distance+1));
//             }
//             if(parentNode.containsKey(temp.node)&&(!visited.containsKey(parentNode.get(temp.node))))
//             {
//                 visited.put(parentNode.get(temp.node),true);
//                 traverse.add(new queueData(parentNode.get(temp.node),temp.distance+1));
//             }
//         }
//         return ans;
//     }
// }
















class nodeData{
    TreeNode node;
    int dist;
    public nodeData(TreeNode node,int dist)
    {
        this.node=node;
        this.dist=dist;
    }
}

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans=new ArrayList<>();
       // we'll use a queue for finding parents
       Queue<TreeNode> parentQueue=new LinkedList<>();
       HashMap<TreeNode,TreeNode> parentMap=new HashMap<>(); // for storing parent links
       parentQueue.add(root);
       while(!parentQueue.isEmpty())
       {
           TreeNode parent=parentQueue.remove();
           if(parent.left!=null)
           {
               parentMap.put(parent.left,parent);
               parentQueue.add(parent.left);
           }
           if(parent.right!=null)
           {
               parentMap.put(parent.right,parent);
               parentQueue.add(parent.right);
           }
       }
       // we'll use a queue for bfs traversal
       Queue<nodeData> bfsQueue=new LinkedList<>();
       HashMap<TreeNode,Boolean> visited=new HashMap<>(); // for storing visited nodes
       bfsQueue.add(new nodeData(target,0));
       visited.put(target,true);
       while(!bfsQueue.isEmpty())
       {
           nodeData temp=bfsQueue.remove();
           if(temp.dist==k)
           {
               ans.add(temp.node.val);
               continue;
           }
           if(temp.node.left!=null&&!visited.containsKey(temp.node.left))
           {
               bfsQueue.add(new nodeData(temp.node.left,temp.dist+1));
               visited.put(temp.node.left,true);
           }
           if(temp.node.right!=null&&!visited.containsKey(temp.node.right))
           {
               bfsQueue.add(new nodeData(temp.node.right,temp.dist+1));
               visited.put(temp.node.right,true);
           }
           if(parentMap.containsKey(temp.node)&&!visited.containsKey(parentMap.get(temp.node)))
           {
               bfsQueue.add(new nodeData(parentMap.get(temp.node),temp.dist+1));
               visited.put(parentMap.get(temp.node),true);
           }
       }
       return ans;
    }
}