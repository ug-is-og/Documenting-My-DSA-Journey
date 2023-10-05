class Solution {
    public int maxProfit(int k, int[] prices) {
        int dp[][][]=new int[prices.length][2][k];
        for(int temp1[][]:dp)
        {
            for(int temp2[]:temp1)
            {
                Arrays.fill(temp2,-1);
            }
        }
        return helper(prices,0,1,0,k,dp);
    }
    public int helper(int prices[],int index,int status,int numTransactions,int k,int dp[][][])
    {
        if(numTransactions==k||index==prices.length)
        {
            return 0;
        }
        if(dp[index][status][numTransactions]!=-1)
        {
            return dp[index][status][numTransactions];
        }
        int profit=0;
        if(status==1) // 1 means buy
        {
            profit=Math.max(-prices[index]+helper(prices,index+1,0,numTransactions,k,dp),helper(prices,index+1,1,numTransactions,k,dp));
        }
        else
        {
            profit=Math.max(prices[index]+helper(prices,index+1,1,numTransactions+1,k,dp),helper(prices,index+1,0,numTransactions,k,dp));
        }
        return dp[index][status][numTransactions]=profit;
    }
}