//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

// using BFS approach

// you didn't keep in mind the connected components case

class data{
    int child;
    int parent;
    public data(int child,int parent){
        this.child=child;
        this.parent=parent;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
       boolean visited[]=new boolean[V];
       boolean ans=false;
       for(int i=0;i<V;i++)
       {
           if(!visited[i])
           {
               visited[i]=true;
               ans=ans||helper(visited,adj,i);
           }
       }
       return ans;
    }
    public boolean helper(boolean visited[],ArrayList<ArrayList<Integer>> adj,int source)
    {
        Queue<data> q=new LinkedList<>();
        q.add(new data(source,-1));
        while(!q.isEmpty())
        {
            data temp=q.remove();
            for(int i=0;i<adj.get(temp.child).size();i++)
            {
                if(!visited[adj.get(temp.child).get(i)])
                {
                    visited[adj.get(temp.child).get(i)]=true;
                    q.add(new data(adj.get(temp.child).get(i),temp.child));
                }
                else
                {
                    if(adj.get(temp.child).get(i)!=temp.parent)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}