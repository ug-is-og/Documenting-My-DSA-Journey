// class data{
//     int node;
//     int color; // let's take 2 color codes 0,1
//     public data(int node,int color){
//         this.node=node;
//         this.color=color;
//     }
// }
// class Solution {
//     public boolean isBipartite(int[][] graph) {
//         int visited[]=new int[graph.length];
//         // further optimization, you don't even need this color array, take visited as int
//         // int color[]=new int[graph.length];
//         Arrays.fill(visited,-1);
//         boolean ans=true; // maanlo bipartite hai
//         for(int i=0;i<graph.length;i++)
//         {
//             if(visited[i]==-1)
//             {
//                 visited[i]=0;
//                 ans=ans&&bfs(graph,i,visited); // harr connected component se bipartite hi aana chahiye tabhi true return karunga
//             }
//         }
//         return ans;
//     }
//     public boolean bfs(int graph[][],int source,int visited[])
//     {
//         Queue<data> q=new LinkedList<>();
//         q.add(new data(source,0));
//         while(!q.isEmpty())
//         {
//             data temp=q.remove();
//             for(int i=0;i<graph[temp.node].length;i++)
//             {
//                 int tempColor=0;
//                 if(temp.color==0)
//                 {
//                     tempColor=1;
//                 }
//                 if(visited[graph[temp.node][i]]==-1)
//                 {
//                     visited[graph[temp.node][i]]=tempColor;
//                     q.add(new data(graph[temp.node][i],tempColor));
//                 }
//                 else
//                 {
//                     if(visited[graph[temp.node][i]]!=tempColor)
//                     {
//                         return false;
//                     }
//                 }
//             }
//         }
//         return true;
//     }
// }

















// class Solution {
//     public boolean isBipartite(int[][] graph) {
//         int visited[]=new int[graph.length];
//         Queue<Integer> q=new LinkedList<>();
//         Arrays.fill(visited,-1);
//         for(int i=0;i<graph.length;i++)
//         {
//             if(visited[i]==-1)
//             {
//                 visited[i]=1;
//                 q.add(i);
//                 if(!bfs(graph,visited,q))
//                 {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
//     public boolean bfs(int graph[][],int visited[],Queue<Integer> q)
//     {
//         while(!q.isEmpty())
//         {
//             int i=q.remove();
//             int color=-1;
//             if(visited[i]==1)
//             color=0;
//             else
//             color=1;
//             for(int j=0;j<graph[i].length;j++)
//             {
//                 if(visited[graph[i][j]]==color)
//                 {
//                     continue;
//                 }
//                 else if(visited[graph[i][j]]==-1)
//                 {
//                     visited[graph[i][j]]=color;
//                     q.add(graph[i][j]);
//                 }
//                 else
//                 {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
// }














// let's solve using DFS

// class Solution {
//     public boolean isBipartite(int[][] graph) {
//         int visited[]=new int[graph.length];
//         Arrays.fill(visited,-1);
//         for(int i=0;i<graph.length;i++)
//         {
//             if(visited[i]==-1&&!dfs(visited,i,graph,1))
//             {
//                 return false;
//             }
//         }
//         return true;
//     }
//     public boolean dfs(int visited[],int i,int graph[][],int color)
//     {
//         System.out.println(i+" "+color);
//         visited[i]=color;
//         int nextColor=-1;
//         if(color==0)
//         {
//             nextColor=1;
//         }
//         else
//         {
//             nextColor=0;
//         }
//         for(int k=0;k<graph[i].length;k++)
//         {
//             if(visited[graph[i][k]]==color)
//             {
//                 return false;
//             }
//             else if(visited[graph[i][k]]==-1&&!dfs(visited,graph[i][k],graph,nextColor))
//             {
//                 return false;
//             }
//         }
//         return true;
//     }
// }






// let's solve using BFS


class Solution {
    public boolean isBipartite(int[][] graph) {
        int visited[]=new int[graph.length];
        Arrays.fill(visited,-1);
        Queue<Pair<Integer,Integer>> q=new LinkedList<>();
        for(int i=0;i<graph.length;i++)
        {
            if(visited[i]==-1)
            {
                visited[i]=1;
                q.add(new Pair<>(i,1));
                if(!bfs(q,graph,visited))
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bfs(Queue<Pair<Integer,Integer>> q,int graph[][],int visited[])
    {
        while(!q.isEmpty())
        {
            Pair<Integer,Integer> temp=q.remove();
            int nextColor=-1;
            if(temp.getValue()==0)
            {
                nextColor=1;
            }
            else
            {
                nextColor=0;
            }
            for(int i=0;i<graph[temp.getKey()].length;i++)
            {
                if(visited[graph[temp.getKey()][i]]==temp.getValue())
                {
                    return false;
                }
                else if(visited[graph[temp.getKey()][i]]==-1)
                {
                    visited[graph[temp.getKey()][i]]=nextColor;
                    q.add(new Pair<>(graph[temp.getKey()][i],nextColor));
                }
            }
        }
        return true;
    }
}