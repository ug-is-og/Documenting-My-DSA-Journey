// Complete Brute Force Approach

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        HashSet<Integer> colSet=new HashSet<>();
        HashSet<Integer> rowSet=new HashSet<>();
        Arrays.sort(hFences);
        Arrays.sort(vFences);
        for(int i=0;i<hFences.length;i++)
        {
            for(int j=0;j<=i;j++)
            rowSet.add(hFences[i]-hFences[j]);
            rowSet.add(hFences[i]-1);
        }
        for(int i=0;i<hFences.length;i++)
        {
            rowSet.add(m-hFences[i]);
        }
        
        rowSet.add(m-1);
        for(int i=0;i<vFences.length;i++)
        {
            for(int j=0;j<=i;j++)
            colSet.add(vFences[i]-vFences[j]);
            colSet.add(vFences[i]-1);
        }
        for(int i=0;i<vFences.length;i++)
        {
            colSet.add(n-vFences[i]);
        }
        colSet.add(n-1);
        HashSet<Integer> set=new HashSet<>();
        for(int i:colSet)
        {
            if(rowSet.contains(i))
            {
                set.add(i);
            }
        }
        long ans=0;
        long max=Long.MIN_VALUE;
        for(int k:set)
        {
            max=Math.max(max,(long)k);
        }
        ans=(max*max)%1000000007;
        if(ans==0)
            return -1;
        return (int)ans;
    }
}