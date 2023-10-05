class Solution {
    public int maxProfit(int[] prices) {
        int dp[][]=new int[prices.length][2];
        for(int temp[]:dp)
        {
            Arrays.fill(temp,-1);
        }
        return helper(prices,1,0,dp);
    }
    public int helper(int prices[],int status,int index,int dp[][])
    {
        if(index==prices.length)
        {
            return 0;
        }
        if(dp[index][status]!=-1)
        {
            return dp[index][status];
        }
        int profit=0;
        if(status==1) // means buy situation
        {
            profit=Math.max(-prices[index]+helper(prices,0,index,dp),helper(prices,1,index+1,dp)); // ya toh tum buy karoge ya fir buy nahi karoge
        }
        else //means sell situation
        {
            profit=Math.max(prices[index]+helper(prices,1,index+1,dp),helper(prices,0,index+1,dp));// ya toh sell karoge ya fir sell nahi karoge
        }
        return dp[index][status]=profit;
    }
}