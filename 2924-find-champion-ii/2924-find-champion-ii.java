class Solution {
    public int findChampion(int n, int[][] edges) {
        if(edges.length==0) // yeh wala segment bhot zaada zaruri hai dhyan rakhna, 5 baar code submit karna pada tha contest mein, jisse rank gir gayi kaafi zaada
        {
            if(n==1)
                return 0;
            else
                return -1;
        }
        Set<Integer> strong=new HashSet<>();
        Set<Integer> weak=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            strong.add(i);
        }
        for(int i=0;i<edges.length;i++)
        {
           strong.add(edges[i][0]);
            weak.add(edges[i][1]);
            strong.remove(edges[i][1]);
        }
        int ans=0,count=0;
        for(int a:strong)
        {
            if(!weak.contains(a))
            {
                ans=a;
                count++;
            }
        }
        if(count>1)
            return -1;
        return ans;
    }
}