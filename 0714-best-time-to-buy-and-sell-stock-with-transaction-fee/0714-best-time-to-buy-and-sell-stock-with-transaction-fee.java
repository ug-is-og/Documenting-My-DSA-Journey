class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][]=new int[prices.length][2];
        // 1 denotes buy and 0 denotes sell
        // also true denotes buy and false denotes sell
        for(int temp[]:dp)
        Arrays.fill(temp,-1);
        return helper(prices,0,fee,true,dp);
    }
    public int helper(int prices[],int index,int fee,boolean buy,int dp[][])
    {
        if(index==prices.length)
        return 0;
        if(buy)
        {
            if(dp[index][1]!=-1)
            return dp[index][1];
        }
        else
        {
            if(dp[index][0]!=-1)
            return dp[index][0];
        }
        int way1=Integer.MIN_VALUE;
        int way2=Integer.MIN_VALUE;
        int way3=Integer.MIN_VALUE;
        int way4=Integer.MIN_VALUE;
        int ans=Integer.MIN_VALUE;
        if(buy)
        {
            way1=-prices[index]+helper(prices,index+1,fee,false,dp);
            way2=helper(prices,index+1,fee,buy,dp);
            ans=Math.max(way1,way2);
        }
        else
        {
            way3=prices[index]-fee+helper(prices,index+1,fee,true,dp);
            way4=helper(prices,index+1,fee,buy,dp);
            ans=Math.max(way3,way4);
        }
        if(buy)
        dp[index][1]=ans;
        else
        dp[index][0]=ans;
        return ans;
    }
}