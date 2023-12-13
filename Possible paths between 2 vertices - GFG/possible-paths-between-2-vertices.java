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
            String[] S1 = br.readLine().trim().split(" ");
            int source = Integer.parseInt(S1[0]);
            int destination = Integer.parseInt(S1[1]);
            Solution obj = new Solution();
            System.out.println(obj.countPaths(V, adj, source, destination));
        }
    }
}

// } Driver Code Ends

// Let's use DFS in this question

// iski complexity O(v^v) ya fir O(V!) yeahi sahi hai bhai, actually na ham baar baar vis=false kar re iss liye harr node 
// ke liye uske saare neighbours tak ja rahe hai hum

// class Solution {
//     // Function to count paths between two vertices in a directed graph.
//     public int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source,
//                   int destination) {
//       boolean visited[]=new boolean[V];
//       int a[]=new int[1];
//       helper(adj,source,destination,a,visited);
//       return a[0];
//     }
//     public void helper(ArrayList<ArrayList<Integer>> adj,int source,int destination,int a[],boolean visited[])
//     {
//         if(source==destination)
//         {
//             a[0]++;
//             return;
//         }
//         if(visited[source]==true)
//         {
//             return;
//         }
//         visited[source]=true;
//         for(int i=0;i<adj.get(source).size();i++)
//         {
//             helper(adj,adj.get(source).get(i),destination,a,visited);
//             visited[adj.get(source).get(i)]=false;
//         }
//     }
// }































class Solution {
    // Function to count paths between two vertices in a directed graph.
    public int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source,
                   int destination) {
                       return helper(adj,source,destination);
                   }
    public int helper(ArrayList<ArrayList<Integer>> adj,int source,int destination)
    {
        if(source==destination)
        {
            return 1;
        }
        int count=0;
        for(int i=0;i<adj.get(source).size();i++)
        {
            count+=helper(adj,adj.get(source).get(i),destination);
        }
        return count;
    }
}