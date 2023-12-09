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
            ArrayList<ArrayList<Integer>> adj =
                new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// class Solution {
//     // Function to return a list containing the DFS traversal of the graph.
//     public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
//         ArrayList<Integer> ans=new ArrayList<>();
//         boolean visited[]=new boolean[V];
//         dfsHelper(ans,adj,0,visited);
//         return ans;
//     }
//     public void dfsHelper(ArrayList<Integer> ans,ArrayList<ArrayList<Integer>> adj,int index,boolean visited[])
//     {
//         if(visited[index]==true) // isko avoid bhi kar sakte the, matlab jahan call laga re wahan directly 
//         // check karle agar ki yeh secific node already visited hai toh call hi mat lagaao
//          return;
//         visited[index]=true;
//         ans.add(index);
//         for(int i=0;i<adj.get(index).size();i++)
//         {
//             // if(visited[adj.get(index).get(i)]!=true)
//             dfsHelper(ans,adj,adj.get(index).get(i),visited);
//         }
//     }
// }



































class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans=new ArrayList<>();
        boolean visited[]=new boolean[V];
        helper(0,ans,visited,adj);
        return ans;
    }
    public void helper(int vertex,ArrayList<Integer> ans,boolean visited[],ArrayList<ArrayList<Integer>> adj)
    {
        visited[vertex]=true;
        ans.add(vertex);
        for(int i=0;i<adj.get(vertex).size();i++)
        {
            if(!visited[adj.get(vertex).get(i)])
            helper(adj.get(vertex).get(i),ans,visited,adj);
        }
    }
}