//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root){
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
	    	Node root = buildTree(s);
	    	
            Solution ob = new Solution();
    		System.out.println(ob.dupSub(root));
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/* A Binary Tree node

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 */

class Solution {
    int dupSub(Node root) {
        // simple trversal to all nodes
        List<Node> nodes=new ArrayList<>();
        inorder(root,nodes);
        boolean check=false;
        for(int i=0;i<nodes.size();i++){
            for(int j=i+1;j<nodes.size();j++)
            {
                check=check||duplicate(nodes.get(i),nodes.get(j),0);
            }
        }
        if(check==true)
        return 1;
        return 0;
    }
    void inorder(Node root,List<Node> nodes)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left,nodes);
        nodes.add(root);
        inorder(root.right,nodes);
    }
    boolean duplicate(Node node1,Node node2,int count)
    {
        if(node1==null&&node2==null)
        {
            if(count>=2)
            return true;
            return false;
        }
        if((node1==null&&node2!=null)||(node1!=null&&node2==null))
        {
            return false;
        }
        if(node1.data!=node2.data)
        {
            return false;
        }
        count++;
        return duplicate(node1.left,node2.left,count)&&duplicate(node1.right,node2.right,count);
        
    }
}