class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[]=new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(helper(0,cost,dp),helper(1,cost,dp));
    }
    public int helper(int index,int cost[],int dp[])
    {
        if(index>=cost.length)
        return 0;
        if(dp[index]!=-1)
        return dp[index];
        return dp[index]=cost[index]+Math.min(helper(index+1,cost,dp),helper(index+2,cost,dp));
    }
}