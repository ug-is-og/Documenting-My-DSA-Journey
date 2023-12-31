class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][]=new int[prices.length][2];
        for(int temp[]:dp)
        {
            Arrays.fill(temp,-1);
        }
        return helper(prices,fee,0,1,dp); // 1 means buy and 0 means sell
    }
    public int helper(int prices[],int fee,int index,int status,int dp[][])
    {
        if(index>=prices.length)
        {
            return 0;
        }
        if(dp[index][status]!=-1)
        {
            return dp[index][status];
        }
        int ans=0;
        if(status==1)
        {
            ans=Math.max(-prices[index]+helper(prices,fee,index+1,0,dp),helper(prices,fee,index+1,1,dp));
        }
        else
        {
            ans=Math.max(prices[index]-fee+helper(prices,fee,index+1,1,dp),helper(prices,fee,index+1,0,dp));
        }
        return dp[index][status]=ans;
    }
}