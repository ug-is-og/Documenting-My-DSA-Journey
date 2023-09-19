// we are no where asked to build the complete trees so build a logic that focusses on simply finding minimum cost possible

class Solution {
    public int mctFromLeafValues(int[] arr) {
        int dp[][]=new int[arr.length][arr.length];
        for(int temp[]:dp)
        Arrays.fill(temp,-1);
        return helper(0,arr.length-1,arr,dp);
    }
    public int helper(int i,int j,int arr[],int dp[][])
    {
        if(i==j)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        int ans=0;
        for(int k=i;k<j;k++)
        {
            int leftMax=findMax(i,k,arr);
            int rightMax=findMax(k+1,j,arr);
            int leftSum=helper(i,k,arr,dp);
            int rightSum=helper(k+1,j,arr,dp);
            ans=leftSum+rightSum+leftMax*rightMax;
            min=Math.min(ans,min);
        }
        return dp[i][j]=min;
    }
    public int findMax(int i,int j,int arr[])
    {
        int max=Integer.MIN_VALUE;
        for(int k=i;k<=j;k++)
        max=Math.max(max,arr[k]);
        return max;
    }
}