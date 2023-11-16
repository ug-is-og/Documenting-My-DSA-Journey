// class Solution {
//     public int maxProfit(int[] prices) {
//         int dp[][]=new int[prices.length][2];
//         for(int temp[]:dp)
//         {
//             Arrays.fill(temp,-1);
//         }
//         return helper(prices,0,1,dp); // 1 means buy and 0 means sell
//     }
//     public int helper(int prices[],int index,int status,int dp[][])
//     {
//         if(index>=prices.length)
//         {
//             return 0;
//         }
//         if(dp[index][status]!=-1)
//         {
//             return dp[index][status];
//         }
//         int ans=0;
//         if(status==1)
//         {
//             ans=Math.max(-prices[index]+helper(prices,index+1,0,dp),helper(prices,index+1,1,dp));
//         }
//         else
//         {
//             ans=Math.max(prices[index]+helper(prices,index+2,1,dp),helper(prices,index+1,0,dp));
//         }
//         return dp[index][status]=ans;
//     }
// }





















class Solution {
    public int maxProfit(int[] prices) {
        int dp[][]=new int[prices.length][2];
        for(int temp[]:dp)
        {
            Arrays.fill(temp,-1);
        }
       return helper(prices,0,1,dp); // 1 means I have to buy
    }
    public int helper(int prices[],int index,int buyStatus,int dp[][])
    {
        if(index>=prices.length)
        {
            return 0;
        }
        if(dp[index][buyStatus]!=-1)
        {
            return dp[index][buyStatus];
        }
        int profit=0;
        if(buyStatus==1)
        {
            profit=Math.max(-prices[index]+helper(prices,index+1,0,dp),helper(prices,index+1,1,dp));
        }
        else
        {
            profit=Math.max(prices[index]+helper(prices,index+2,1,dp),helper(prices,index+1,0,dp));
        }
        return dp[index][buyStatus]=profit;
    }
}