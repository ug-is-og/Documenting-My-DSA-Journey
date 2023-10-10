//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class queueData{
    Node root;
    int distance;
    public queueData(Node root,int distance)
    {
        this.root=root;
        this.distance=distance;
    }
}
class Solution
{
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        // build the parent links
        HashMap<Node,Node> parentMap=new HashMap<>();
        buildParentLinks(root,parentMap);
        // Find the target with value target
        Node targetNode=findTarget(target,root);
        // bfs from target node and keep a variable call distance that keeps record of distance from source node
        Queue<queueData> q=new LinkedList<>();
        q.add(new queueData(targetNode,0));
        HashMap<Node,Boolean> visited=new HashMap<>();
        visited.put(targetNode,true);
        while(!q.isEmpty())
        {
            queueData temp=q.remove();
            if(temp.distance==k)
            {
                ans.add(temp.root.data);
            }
            if(temp.root.left!=null&&!visited.containsKey(temp.root.left))
            {
                visited.put(temp.root.left,true);
                q.add(new queueData(temp.root.left,temp.distance+1));
            }
            if(temp.root.right!=null&&!visited.containsKey(temp.root.right))
            {
                visited.put(temp.root.right,true);
                q.add(new queueData(temp.root.right,temp.distance+1));
            }
            if(parentMap.containsKey(temp.root)&&!visited.containsKey(parentMap.get(temp.root)))
            {
                visited.put(parentMap.get(temp.root),true);
                q.add(new queueData(parentMap.get(temp.root),temp.distance+1));
            }
        }
        Collections.sort(ans);
        return ans;
    }
    public static void buildParentLinks(Node root,HashMap<Node,Node> parentMap)
    {
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            Node temp=q.remove();
            if(temp.left!=null)
            {
                parentMap.put(temp.left,temp);
                q.add(temp.left);
            }
            if(temp.right!=null)
            {
                parentMap.put(temp.right,temp);
                q.add(temp.right);
            }
        }
    }
    public static Node findTarget(int target,Node root)
    {
        if(root==null)
        {
            return null;
        }
        if(root.data==target)
        {
            return root;
        }
        Node ans=null;
        ans=findTarget(target,root.left);
        if(ans!=null)
        return ans;
        ans=findTarget(target,root.right);
        return ans;
    }
};