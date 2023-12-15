class edgeData{
    int edgeHead;
    long edgeTime;
    public edgeData(int edgeHead,long edgeTime)
    {
        this.edgeHead=edgeHead;
        this.edgeTime=edgeTime;
    }
}
class nodeData{
    int node;
    long time;
    public nodeData(int node,long time)
    {
        this.node=node;
        this.time=time;
    }
}
class ordering implements Comparator<nodeData>{
    public int compare(nodeData a,nodeData b)
    {
        return (int)(a.time-b.time);
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<edgeData>> list=new ArrayList<>();
        buildList(list,roads,n);
        PriorityQueue<nodeData> pq=new PriorityQueue<>(new ordering());
        long time[]=new long[n];
        long numPaths[]=new long[n];
        int mod=1000000007;
        Arrays.fill(time,(long)1e18); // harr jagah 1e9 kam nahi karega, constraints dhyanse dekha karo bhaii
        time[0]=0;
        numPaths[0]=1;
        pq.add(new nodeData(0,0));
        while(!pq.isEmpty())
        {
            nodeData temp=pq.remove();
            if(temp.node==n-1)
            continue;
            for(int i=0;i<list.get(temp.node).size();i++)
            {
                int edgeHead=list.get(temp.node).get(i).edgeHead;
                long edgeTime=list.get(temp.node).get(i).edgeTime;
                if(time[edgeHead]==temp.time+edgeTime)
                {
                    numPaths[edgeHead]=(numPaths[edgeHead]+numPaths[temp.node])%mod;
                }
                else if(time[edgeHead]>temp.time+edgeTime)
                {
                    time[edgeHead]=temp.time+edgeTime;
                    numPaths[edgeHead]=numPaths[temp.node];
                    pq.add(new nodeData(edgeHead,time[edgeHead]));
                }
            }
        }
        return (int)numPaths[n-1]%mod;
    }
    public void buildList(List<List<edgeData>> list,int roads[][],int n)
    {
        for(int i=0;i<n;i++)
        {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++)
        {
            list.get(roads[i][0]).add(new edgeData(roads[i][1],roads[i][2]));
            list.get(roads[i][1]).add(new edgeData(roads[i][0],roads[i][2]));
        }
    }
}