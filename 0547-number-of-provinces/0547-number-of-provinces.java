class Solution {
    public int findCircleNum(int[][] isConnected) {
        // build the adjacency list
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        int n=isConnected.length;
        for(int i=0;i<n;i++)
        {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i!=j&&isConnected[i][j]==1)
                {
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        int count=0;
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(visited[i]!=true)
            {
                visited[i]=true;
                dfs(visited,list,i);
                count++;
            }
        }
        return count;
    }
    public void dfs(boolean visited[],ArrayList<ArrayList<Integer>> list,int source)
    {
        for(int i=0;i<list.get(source).size();i++)
        {
            if(!visited[list.get(source).get(i)])
            {
                visited[list.get(source).get(i)]=true;
                dfs(visited,list,list.get(source).get(i));
            }
        }
    }
}