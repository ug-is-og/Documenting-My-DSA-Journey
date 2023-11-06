// Extremely brute force approach, optimize it 

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int outdegree[]=new int[graph.length];
        Queue<Integer> q=new LinkedList<>();
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<graph.length;i++)
        {
            outdegree[i]=graph[i].length;
            for(int j=0;j<graph[i].length;j++)
            {
                List<Integer> temp=null;
                if(!map.containsKey(graph[i][j]))
                {
                    temp=new ArrayList<>();
                }
                else
                {
                    temp=map.get(graph[i][j]);
                }
                temp.add(i);
                map.put(graph[i][j],temp);
            }
            if(outdegree[i]==0)
            {
                q.add(i);
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty())
        {
            int temp=q.remove();
            ans.add(temp);
            if(map.containsKey(temp))
            {
                for(int i=0;i<map.get(temp).size();i++)
                {
                    outdegree[map.get(temp).get(i)]--;
                    if(outdegree[map.get(temp).get(i)]==0)
                    {
                        q.add(map.get(temp).get(i));
                    }
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
    public boolean check(int arr[],int temp)
    {
        for(int a:arr)
        {
            if(a==temp)
            return true;
        }
        return false;
    }
}