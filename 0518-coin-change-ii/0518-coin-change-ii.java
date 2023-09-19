class Solution {
    public int change(int amount, int[] coins) {
        int dp[][]=new int[amount+1][coins.length+1];
        for(int temp[]:dp)
        Arrays.fill(temp,-1);
        return helper(amount,coins,coins.length,dp);
    }
    public int helper(int amount,int coins[],int index,int dp[][])
    {
        if(amount==0)
        return 1;
        if(amount<0)
        return 0;
        if(index==0) // obviously means amount>0 nahi toh upar hi return ho jata
        return 0;
        if(dp[amount][index]!=-1)
        return dp[amount][index];
        return dp[amount][index]=helper(amount-coins[index-1],coins,index,dp)+helper(amount,coins,index-1,dp);
    }
}