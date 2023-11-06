//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


// CyCle Detection using BFS

// class Solution {
//     // Function to detect cycle in a directed graph.
//     public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
//         boolean visited[]=new boolean[V];
//         boolean pathVisited[]=new boolean[V];
//         boolean ans=false; // maanlo ki cycle nahi hai
//         for(int i=0;i<V;i++)
//         {
//             if(!visited[i])
//             {
//                 visited[i]=true;
//                 pathVisited[i]=true;
//                 ans=ans||dfs(visited,pathVisited,adj,i);// kisi bhi possibility se cycle aa gayi toh mark it as true
//                 pathVisited[i]=false;
//             }
//         }
//         return ans;
//     }
//     public boolean dfs(boolean visited[],boolean pathVisited[],ArrayList<ArrayList<Integer>> adj,int source)
//     {
//         boolean ans=false;
//         for(int i=0;i<adj.get(source).size();i++)
//         {
//             if(!visited[adj.get(source).get(i)])
//             {
//                 visited[adj.get(source).get(i)]=true;
//                 pathVisited[adj.get(source).get(i)]=true;
//                 ans=ans||dfs(visited,pathVisited,adj,adj.get(source).get(i));
//                 pathVisited[adj.get(source).get(i)]=false;
//             }
//             else
//             {
//                 if(pathVisited[adj.get(source).get(i)]==true)
//                 {
//                     return true;
//                 }
//             }
//         }
//         return ans;
//     }
// }

// cycle detection using BFS

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // build topo sort
        int indegree[]=new int[V];
        for(int i=0;i<adj.size();i++)
        {
            for(int j=0;j<adj.get(i).size();j++)
            {
                indegree[adj.get(i).get(j)]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
        while(!q.isEmpty())
        {
            int temp=q.remove();
            ans.add(temp);
            for(int i=0;i<adj.get(temp).size();i++)
            {
                indegree[adj.get(temp).get(i)]--;
                if(indegree[adj.get(temp).get(i)]==0)
                {
                    q.add(adj.get(temp).get(i));
                }
            }
        }
        if(ans.size()<V)
        {
            return true;
        }
        return false;
    }
}