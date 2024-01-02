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
// matlab yaar tumhe ek for loop lagake harr connected componene tmein jaba hoga, pehlke tum kewal 0 ko source maanke chala de re the
// toh agar koi aur component connected hua ans usme cycle huii toh tumhe pata hi nahi chalega

// class data{
//     int child;
//     int parent;
//     public data(int child,int parent){
//         this.child=child;
//         this.parent=parent;
//     }
// }
// class Solution {
//     // Function to detect cycle in an undirected graph.
//     public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
//       boolean visited[]=new boolean[V];
//       boolean ans=false;
//       for(int i=0;i<V;i++)
//       {
//           if(!visited[i])
//           {
//               visited[i]=true;
//               ans=ans||helper(visited,adj,i);
//           }
//       }
//       return ans;
//     }
//     public boolean helper(boolean visited[],ArrayList<ArrayList<Integer>> adj,int source)
//     {
//         Queue<data> q=new LinkedList<>();
//         q.add(new data(source,-1));
//         while(!q.isEmpty())
//         {
//             data temp=q.remove();
//             for(int i=0;i<adj.get(temp.child).size();i++)
//             {
//                 if(!visited[adj.get(temp.child).get(i)])
//                 {
//                     visited[adj.get(temp.child).get(i)]=true;
//                     q.add(new data(adj.get(temp.child).get(i),temp.child));
//                 }
//                 else
//                 {
//                     if(adj.get(temp.child).get(i)!=temp.parent)
//                     {
//                         return true;
//                     }
//                 }
//             }
//         }
//         return false;
//     }
// }























// // yahan pe firse connected components wala case bhul gaye the

// class node{
//     int child;
//     int parent;
//     public node(int child,int parent)
//     {
//         this.child=child;
//         this.parent=parent;
//     }
// }

// class Solution {
//     // Function to detect cycle in an undirected graph.
//     public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
//       Queue<node> q=new LinkedList<>();
//       boolean visited[]=new boolean[V];
//       for(int i=0;i<V;i++)
//       {
//           if(!visited[i])
//           {
//               visited[i]=true;
//               if(helper(q,visited,i,adj))
//               return true;
//           }
//       }
//       return false;
//     }
//     public boolean helper(Queue<node> q,boolean visited[],int src,ArrayList<ArrayList<Integer>> adj)
//     {
//       q.add(new node(src,-1));
//       while(!q.isEmpty())
//       {
//           node temp=q.remove();
//           for(int i=0;i<adj.get(temp.child).size();i++)
//           {
//               if(adj.get(temp.child).get(i)!=temp.parent&&visited[adj.get(temp.child).get(i)])
//               {
//                   return true;
//               }
//               if(!visited[adj.get(temp.child).get(i)])
//               {
//                   q.add(new node(adj.get(temp.child).get(i),temp.child));
//                   visited[adj.get(temp.child).get(i)]=true;
//               }
//           }
//       }
//       return false;
//     }
// }




































// lets go with DFS approach first

// class Solution {
//     // Function to detect cycle in an undirected graph.
//     public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
//         boolean visited[]=new boolean[V];
//         for(int i=0;i<V;i++)
//         {
//             if(!visited[i]&&dfs(V,adj,visited,i,-1))
//             {
//                 return true;
//             }
//         }
//         return false;
//     }
//     public boolean dfs(int V,ArrayList<ArrayList<Integer>> adj,boolean visited[],int child,int parent)
//     {
//         visited[child]=true;
//         for(int i=0;i<adj.get(child).size();i++)
//         {
//             int node=adj.get(child).get(i);
//             if(visited[node]&&node!=parent)
//             {
//                 return true;
//             }
//             else if(!visited[node]&&dfs(V,adj,visited,node,child))
//             {
//                 return true;
//             }
//         }
//         return false;
//     }
// }




































// let's go ahead with bfs approach now

class node{
    int child;
    int parent;
    public node(int child,int parent)
    {
        this.child=child;
        this.parent=parent;
    }
}

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<node> q=new LinkedList<>();
        boolean visited[]=new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                visited[i]=true;
                q.add(new node(i,-1));
                if(bfs(visited,V,adj,q))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean bfs(boolean visited[],int V,ArrayList<ArrayList<Integer>> adj,Queue<node> q)
    {
        while(!q.isEmpty())
        {
            node temp=q.remove();
            for(int i=0;i<adj.get(temp.child).size();i++)
            {
                int connectedNode=adj.get(temp.child).get(i);
                if(visited[connectedNode]&&connectedNode!=temp.parent)
                {
                    return true;
                }
                else if(!visited[connectedNode])
                {
                    visited[connectedNode]=true;
                    q.add(new node(connectedNode,temp.child));
                }
            }
        }
        return false;
    }
}