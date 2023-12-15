class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // build the adjacency matrix
        int distance[][]=new int[n][n];
        buildAdj(distance,edges);
        for(int via=0;via<n;via++)
        {
            for(int i=0;i<distance.length;i++)
            {
                for(int j=0;j<distance[0].length;j++)
                {
                    distance[i][j]=Math.min(distance[i][j],distance[i][via]+distance[via][j]);
                }
            }
        }
        int min=Integer.MAX_VALUE,ans=-1;
        for(int i=0;i<distance.length;i++)
        {
            int count=0;
            for(int j=0;j<distance[0].length;j++)
            {
                if(i!=j&&distance[i][j]<=distanceThreshold)
                {
                    count++;
                }
            }
            if(min>=count) // yahan pe aesa bhi ho sakta ki count=0 ho matlab a node is not connected to any other node and in such case it has 0 neighbour cities (minimum no of reachable cities=0), so it is a possible answer
            {
                min=count;
                ans=i;
            }
        }
        return ans;
    }
    public void buildAdj(int distance[][],int edges[][])
    {
        for(int i=0;i<distance.length;i++)
        {
            for(int j=0;j<distance[0].length;j++)
            {
                if(i!=j)
                {
                    distance[i][j]=(int)1e9;
                }
            }
        }
        for(int i=0;i<edges.length;i++)
        {
            distance[edges[i][0]][edges[i][1]]=edges[i][2];
            distance[edges[i][1]][edges[i][0]]=edges[i][2];
        }
    }
}