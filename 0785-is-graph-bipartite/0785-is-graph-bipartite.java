class data{
    int node;
    int color; // let's take 2 color codes 0,1
    public data(int node,int color){
        this.node=node;
        this.color=color;
    }
}
class Solution {
    public boolean isBipartite(int[][] graph) {
        int visited[]=new int[graph.length];
        // further optimization, you don't even need this color array, take visited as int
        // int color[]=new int[graph.length];
        Arrays.fill(visited,-1);
        boolean ans=true; // maanlo bipartite hai
        for(int i=0;i<graph.length;i++)
        {
            if(visited[i]==-1)
            {
                visited[i]=0;
                ans=ans&&bfs(graph,i,visited); // harr connected component se bipartite hi aana chahiye tabhi true return karunga
            }
        }
        return ans;
    }
    public boolean bfs(int graph[][],int source,int visited[])
    {
        Queue<data> q=new LinkedList<>();
        q.add(new data(source,0));
        while(!q.isEmpty())
        {
            data temp=q.remove();
            for(int i=0;i<graph[temp.node].length;i++)
            {
                int tempColor=0;
                if(temp.color==0)
                {
                    tempColor=1;
                }
                if(visited[graph[temp.node][i]]==-1)
                {
                    visited[graph[temp.node][i]]=tempColor;
                    q.add(new data(graph[temp.node][i],tempColor));
                }
                else
                {
                    if(visited[graph[temp.node][i]]!=tempColor)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}