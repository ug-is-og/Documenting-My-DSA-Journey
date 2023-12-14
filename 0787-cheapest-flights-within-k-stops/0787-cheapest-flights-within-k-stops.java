// https://youtu.be/9XybHVqTHcQ
class edgeData
{
    int head,cost;
    public edgeData(int head,int cost)
    {
        this.head=head;
        this.cost=cost;
    }
}
class nodeData{
    int stops,node,distance;
    public nodeData(int stops,int node,int distance)
    {
        this.stops=stops;
        this.node=node;
        this.distance=distance;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int distance[]=new int[n];
        Arrays.fill(distance,(int)1e9);
        distance[src]=0;
        List<List<edgeData>> list=new ArrayList<>();
        buildList(list,flights,n);
        Queue<nodeData> q=new LinkedList<>();
        q.add(new nodeData(0,src,0));
        while(!q.isEmpty())
        {
            nodeData temp=q.remove();
            if(temp.stops>k)
            continue;
            for(int i=0;i<list.get(temp.node).size();i++)
            {
                int node=list.get(temp.node).get(i).head;
                int cost=list.get(temp.node).get(i).cost;
                if(distance[node]>cost+temp.distance)
                {
                    distance[node]=cost+temp.distance;
                    q.add(new nodeData(temp.stops+1,node,distance[node]));
                }
            }
        }
        if(distance[dst]==(int)1e9)
        return -1;
        return distance[dst];
    }
    public void buildList(List<List<edgeData>> list,int flights[][],int n)
    {
        for(int i=0;i<n;i++)
        {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++)
        {
            list.get(flights[i][0]).add(new edgeData(flights[i][1],flights[i][2]));
        }
    }
}