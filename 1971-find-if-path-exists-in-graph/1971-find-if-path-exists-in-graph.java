// class Solution {
//     public boolean validPath(int n, int[][] edges, int source, int destination) {
//         Map<Integer, List<Integer>> map = new HashMap<>();

//         for (int[] edge : edges) {
//             int vertex1 = edge[0];
//             int vertex2 = edge[1];
//             List<Integer> neighbors1 = map.getOrDefault(vertex1, new ArrayList<>());
//             neighbors1.add(vertex2);
//             map.put(vertex1, neighbors1);
//             List<Integer> neighbors2 = map.getOrDefault(vertex2, new ArrayList<>());
//             neighbors2.add(vertex1);
//             map.put(vertex2, neighbors2);
//         }
//         if(n==1)
//         return true;
//         // BFS traversal marke pata kar liya , destination wala visit ho pa ra using source
//         boolean visited[]=new boolean[n];
//         Queue<Integer> pending=new LinkedList<>();
//         pending.add(source);
//         while(!pending.isEmpty())
//         {
//             int a=pending.remove();
//             visited[a]=true;
//             for(int j=0;j<map.get(a).size();j++)
//             {
//                 if(visited[map.get(a).get(j)]!=true)
//                 {
//                     pending.add(map.get(a).get(j));
//                     visited[map.get(a).get(j)]=true;
//                 }
//             }
//         }
//         return visited[destination];
//     }
// }



// much much better solution

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // build adjacency list
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean visited[]=new boolean[n];
        return helper(adj,source,destination,visited);
    }
    public boolean helper(ArrayList<ArrayList<Integer>> adj,int source,int destination,boolean visited[])
    {
        visited[source]=true;
        if(source==destination)
        {
            return true;
        }
        boolean ans=false;
        for(int i=0;i<adj.get(source).size();i++)
        {
            if(!visited[adj.get(source).get(i)])
            ans=ans||helper(adj,adj.get(source).get(i),destination,visited);
        }
        return ans;
    }
}