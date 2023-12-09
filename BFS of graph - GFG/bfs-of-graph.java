//{ Driver Code Starts
// Initial Template for Java
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
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends

// 1st method of implementation 
// this is much better implementation

// class Solution {
//     // Function to return Breadth First Traversal of given graph.
//     public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
//         ArrayList<Integer> ans=new ArrayList<>();
//         boolean visited[]=new boolean[V];
//         Queue<Integer> q=new LinkedList<>();
//         q.add(0);
//         visited[0]=true;
//         while(!q.isEmpty())
//         {
//             int temp=q.remove();
//             ans.add(temp);
//             for(int i=0;i<adj.get(temp).size();i++)
//             {
//                 if(visited[adj.get(temp).get(i)]!=true)
//                 {
//                     visited[adj.get(temp).get(i)]=true;
//                     q.add(adj.get(temp).get(i));
//                 }
//             }
//         }
//         return ans;
//     }
// }

// 2nd method of implementation
// understand this soluton using this test case
// undirected graph with edges (0,1),(0,2),(1,3),(1,4),(2,3),(2,4),(3,5),(4,5) 

// class Solution {
//     // Function to return Breadth First Traversal of given graph.
//     public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
//         ArrayList<Integer> ans=new ArrayList<>();
//         boolean visited[]=new boolean[V];
//         Queue<Integer> q=new LinkedList<>();
//         q.add(0);
//         while(!q.isEmpty())
//         {
//             int temp=q.remove();
//             if(visited[temp]==false)
//             {
//                 visited[temp]=true;
//                 ans.add(temp);
//                 for(int i=0;i<adj.get(temp).size();i++)
//                 {
//                     if(visited[adj.get(temp).get(i)]!=true)
//                     {
//                         q.add(adj.get(temp).get(i));
//                     }
//                 }
//             }
//         }
//         return ans;
//     }
// }






































class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        boolean visited[]=new boolean[V];
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty())
        {
            int vertex=q.remove();
            // visited[vertex]=true;
            ans.add(vertex);
            for(int i=0;i<adj.get(vertex).size();i++)
            {
                if(!visited[adj.get(vertex).get(i)])
                {
                    q.add(adj.get(vertex).get(i));
                    visited[adj.get(vertex).get(i)]=true; // bhot dhyan se sochna visited[adj.get(vertex).get(i)] yahan pe kyu mark kar re and while ke pehle step mein nahi
                }
            }
        }
        return ans;
    }
}