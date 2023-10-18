//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends

class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int visited[]=new int[V];
        Arrays.fill(visited,-1);
        boolean ans=true;
        for(int i=0;i<V;i++)
        {
            if(visited[i]==-1)
            {
                visited[i]=0; // for storing colors as well as keeping track that it ha sbeen visited
                ans=ans&&dfs(visited,adj,i,0); // o color bheja source node ka
            }
        }
        return ans;
    }
    public boolean dfs(int visited[],ArrayList<ArrayList<Integer>> adj,int source,int color)
    {
        int tempColor=0; // ab source ka baad jo bhi nodes hai unke liye tempColor
        if(color==0) 
        {
            tempColor=1;
        }
        boolean ans=true;
        for(int i=0;i<adj.get(source).size();i++)
        {
            if(visited[adj.get(source).get(i)]==-1)
            {
                visited[adj.get(source).get(i)]=tempColor;
                ans=ans&&dfs(visited,adj,adj.get(source).get(i),tempColor);
            }
            else
            {
                if(visited[adj.get(source).get(i)]!=tempColor)
                {
                    //System.out.println(tempColor+" "+source+" "+adj.get(source).get(i));
                    return false;
                }
            }
        }
        return ans;
    }
}