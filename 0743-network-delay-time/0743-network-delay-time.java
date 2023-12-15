class edgeData{
    int head,time;
    public edgeData(int head,int time)
    {
        this.head=head;
        this.time=time;
    }
}
class nodeData{
    int node,time;
    public nodeData(int node,int time)
    {
        this.node=node;
        this.time=time;
    }
}
class ordering implements Comparator<nodeData>{
    public int compare(nodeData a,nodeData b)
    {
        return a.time-b.time;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<edgeData>> adj=new ArrayList<>();
        buildList(adj,times,n+1); // n+1 iss liye kyunki 1 se numbering chalu ho rahi nodes ki , 0 se nahi
        int time[]=new int[n+1];
        int ans=0;
        Arrays.fill(time,(int)1e9);
        time[k]=0;
        PriorityQueue<nodeData> pq=new PriorityQueue<>(new ordering());
        pq.add(new nodeData(k,0));
        while(!pq.isEmpty())
        {
            nodeData temp=pq.remove();
            for(int i=0;i<adj.get(temp.node).size();i++)
            {
                int edgeTime=adj.get(temp.node).get(i).time;
                int edgeHead=adj.get(temp.node).get(i).head;
                if(time[edgeHead]>edgeTime+time[temp.node])
                {
                    time[edgeHead]=edgeTime+time[temp.node];
                    pq.add(new nodeData(edgeHead,time[edgeHead]));
                }
            }
        }
        for(int i=1;i<time.length;i++)
        {
            int a=time[i];
            if(a==(int)1e9)
            return -1;
            ans=Math.max(ans,a);
        }
        return ans;
    }
    public void buildList(List<List<edgeData>> adj,int times[][],int n)
    {
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++)
        {
            adj.get(times[i][0]).add(new edgeData(times[i][1],times[i][2]));
        }
    }
}