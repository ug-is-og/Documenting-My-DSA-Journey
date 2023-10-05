class Solution {
    public int maxProfit(int[] prices) {
        int dp[][][]=new int[prices.length][2][2];
        for(int temp1[][]:dp)
        {
            for(int temp2[]:temp1)
            {
                Arrays.fill(temp2,-1);
            }
        }
        return helper(prices,0,1,0,dp);
    }
    public int helper(int prices[],int index,int status,int numTransactions,int dp[][][])
    {
        if(index==prices.length||numTransactions==2)
        {
            return 0;
        }
        if(dp[index][status][numTransactions]!=-1)
        {
            return dp[index][status][numTransactions];
        }
        int profit=0;
        if(status==1)
        {
            profit=Math.max(-prices[index]+helper(prices,index+1,0,numTransactions,dp),helper(prices,index+1,1,numTransactions,dp));
        }
        else
        {
            profit=Math.max(prices[index]+helper(prices,index+1,1,numTransactions+1,dp),helper(prices,index+1,0,numTransactions,dp));
        }
        return dp[index][status][numTransactions]=profit;
    }
}