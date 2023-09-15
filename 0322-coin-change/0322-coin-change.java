// Approach 1 (Completely recursive)

// TLE aa gaya matlab jeet gaye

// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int ans=helper(coins,amount,coins.length);
//         if(ans>=100000)
//         return -1;
//         return ans;
//     }
//     public int helper(int coins[],int amount,int n)
//     {
//         if(amount==0)
//         return 0;
//         if(n==0)
//         return 100000;
//         // if(amount==0)
//         // return 1;
//         int ways1=100000,ways2=100000;
//         if(amount>=coins[n-1])
//         ways1=Math.min(1+helper(coins,amount-coins[n-1],n),helper(coins,amount,n-1));
//         else
//         ways2=helper(coins,amount,n-1);
//         return Math.min(ways1,ways2);
//     }
// }

// Approach 2 (Memoization on approach 1(n to 0))

// class Solution{
//     public int coinChange(int coins[],int amount)
//     {
//         int dp[][]=new int[coins.length+1][amount+1];
//         for(int temp[]:dp)
//         Arrays.fill(temp,-1);
//         int ans=helper(dp,coins,amount,coins.length);
//         if(ans>=100000)
//         return -1;
//         return ans; 
//     }
//     public int helper(int dp[][],int coins[],int amount,int n)
//     {
//         if(amount==0)
//         return 0;
//         if(n==0)
//         return 100000;
//         if(dp[n][amount]!=-1)
//         return dp[n][amount];
//         int ways1=100000,ways2=100000;
//         if(amount>=coins[n-1])
//         ways1=Math.min(1+helper(dp,coins,amount-coins[n-1],n),helper(dp,coins,amount,n-1));
//         else
//         ways2=helper(dp,coins,amount,n-1);
//         return dp[n][amount]=Math.min(ways1,ways2);
//     }
// }

//  Approach 3 (Tabulation Approach) (n to 0)

//jeet gaye sirji

// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int dp[][]=new int[coins.length+1][amount+1];
//         //initialise (dhyan se dekho i=1 se kiya hai)
//         for(int i=1;i<amount+1;i++)
//         dp[0][i]=100000;
//         for(int i=1;i<coins.length+1;i++)
//         {
//             for(int j=1;j<amount+1;j++)
//             {
//                 if(j>=coins[i-1])
//                 dp[i][j]=Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
//                 else
//                 dp[i][j]=dp[i-1][j];
//             }
//         }
//         if(dp[coins.length][amount]>=100000)
//         return -1;
//         return dp[coins.length][amount];
//     }
// }































// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int dp[][]=new int[amount+1][coins.length+1];
//         for(int temp[]:dp)
//         Arrays.fill(temp,-1);
//         int ans=helper(coins,amount,coins.length,dp);
//         if(ans>10000)
//         return -1;
//         return ans;
//     }
//     public int helper(int coins[],int amount,int index,int dp[][])
//     {
//         if(index==0)
//         {
//             if(amount==0)
//             return 0;
//             else
//             return 100000;
//         }
//         if(dp[amount][index]!=-1)
//         {
//             return dp[amount][index];
//         }
//         int way1=Integer.MAX_VALUE,way2=Integer.MAX_VALUE,ans=Integer.MAX_VALUE;
//         if(amount>=coins[index-1])
//         {
//             way1=1+helper(coins,amount-coins[index-1],index,dp);
//             way2=helper(coins,amount,index-1,dp);
//             ans=Math.min(way1,way2);
//         }
//         else
//         {
//             ans=helper(coins,amount,index-1,dp);
//         }
//         return dp[amount][index]=ans;
//     }
// }






// solution using 1d array
// https://www.youtube.com/watch?v=A3FHNCAkhxE
class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[]=new int[amount+1];
        Arrays.fill(dp,-1);
        int ans=helper(coins,amount,dp);
        if(ans==Integer.MAX_VALUE)
        return -1;
        return ans;
    }
    public int helper(int coins[],int amount,int dp[])
    {
        if(amount==0)
        return 0;
        if(amount<0)
        return Integer.MAX_VALUE;
        if(dp[amount]!=-1)
        return dp[amount];
        int min=Integer.MAX_VALUE,res=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++)
        {
            res=helper(coins,amount-coins[i],dp);
            if(res!=Integer.MAX_VALUE)
            min=Math.min(min,1+res);
        }
        return dp[amount]=min;
    }
}


























