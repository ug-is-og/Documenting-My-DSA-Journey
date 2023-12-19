//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<>();
                t1.add(u);
                t1.add(v);
                t1.add(w);
                edges.add(t1);
            }

            int S = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            int[] ptr = ob.bellman_ford(V, edges, S);

            for (i = 0; i < ptr.length; i++) System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
*   edges: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
// class Solution {
//     static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
//         int ans[]=new int[V];
//         Arrays.fill(ans,(int)1e8);
//         ans[S]=0;
//         for(int i=0;i<V-1;i++)
//         {
//             for(int j=0;j<edges.size();j++)
//             {
//                 int u=edges.get(j).get(0);
//                 int v=edges.get(j).get(1);
//                 int w=edges.get(j).get(2);
//                 if(ans[u]!=(int)1e8&&ans[u]+w<ans[v]) // ans[u]!=(int)1e8 wali condition ka khass dhyan rakhna
//                 {
//                     ans[v]=ans[u]+w;
//                 }
//             }
//         }
//         int tempAns[]=new int[1];
//         // do the Nth iteration for negative cycle detection
//         for(int j=0;j<edges.size();j++)
//         {
//             int u=edges.get(j).get(0);
//             int v=edges.get(j).get(1);
//             int w=edges.get(j).get(2);
//             if(ans[u]!=(int)1e8&&ans[u]+w<ans[v])
//             {
//                 tempAns[0]=-1;
//                 return tempAns;
//             }
//         }
//         return ans;
//     }
// }






class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
       int ans[]=new int[V];
       Arrays.fill(ans,(int)1e8);
       ans[S]=0;
       // do the relaxation of edges N-1 times
       for(int i=0;i<V-1;i++)
       {
           for(int j=0;j<edges.size();j++)
           {
               int u=edges.get(j).get(0);
               int v=edges.get(j).get(1);
               int w=edges.get(j).get(2);
               if(ans[u]!=(int)1e8&&ans[u]+w<ans[v])
               {
                   ans[v]=ans[u]+w;
               }
           }
       }
       // lets check for negative cycle
       int neg[]=new int[1];
       for(int j=0;j<edges.size();j++)
       {
           int u=edges.get(j).get(0);
           int v=edges.get(j).get(1);
           int w=edges.get(j).get(2);
           if(ans[u]!=(int)1e8&&ans[u]+w<ans[v])
           {
               neg[0]=-1;
               return neg;
           }
       }
       return ans;
    }
}
