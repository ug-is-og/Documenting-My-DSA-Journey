class Solution {
    public int trap(int[] height) {
        int n=height.length;
        // move from left to right generating maximums
        long lRMax[]=new long[n];
        // move from right to left generating maximums
        long rLMax[]=new long[n];
        long max=Long.MIN_VALUE;
        long ans=0;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,height[i]);
            lRMax[i]=max;
        }
        max=Long.MIN_VALUE;
        for(int i=n-1;i>=0;i--)
        {
            max=Math.max(max,height[i]);
            rLMax[i]=max;
        }
        for(int i=1;i<n-1;i++)
        {
            ans=ans+Math.min(lRMax[i],rLMax[i])-height[i];
        }
        return (int)ans;
    }
}