// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int dp[]=new int[cost.length];
//         Arrays.fill(dp,-1);
//         return Math.min(helper(0,dp,cost),helper(1,dp,cost));
//     }
//     public int helper(int index,int dp[],int cost[])
//     {
//         if(index>=dp.length)
//         {
//             return 0;
//         }
//         if(dp[index]!=-1)
//         {
//             return dp[index];
//         }
//         return dp[index]=cost[index]+Math.min(helper(index+1,dp,cost),helper(index+2,dp,cost));
//     }
// }



// tabulaton approach

// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int dp[]=new int[cost.length];
//         int first=0,second=0;
//         for(int i=cost.length-1;i>=0;i--)
//         {
//             if(i+1>=cost.length)
//             first=0;
//             else
//             first=dp[i+1];
//             if(i+2>=cost.length)
//             second=0;
//             else
//             second=dp[i+2];
//             dp[i]=cost[i]+Math.min(first,second);
//         }
//         return Math.min(dp[0],dp[1]);
//     }
// }

// tabulation optimized O(1) space

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int firstNext=0;
        int secondNext=0;
        int temp=0;
        for(int i=cost.length-1;i>=0;i--)
        {
            if(i+1>=cost.length)
            firstNext=0;
            if(i+2>=cost.length)
            secondNext=0;
            temp=cost[i]+Math.min(firstNext,secondNext);
            secondNext=firstNext;
            firstNext=temp;
        }
        return Math.min(firstNext,secondNext);
    }
}