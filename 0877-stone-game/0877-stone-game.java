// tumne somewhat thoda bhot dimaag lagane ki koshish kari but the mistake that you've made is ki tum Bob ke choices consider karna bhul gaye ho, tumne bas alice ki hi baat kari apne solution mein, pa yaar mein na newplayer wali cheez consider nahi karna chah raha toh pata kaise chalega fir ki alice khel ya ya bob ek specific point pe 

// class Solution {
//     public boolean stoneGame(int[] piles) {
//         int dp[][]=new int[piles.length][piles.length];
//         for(int newTemp[]:dp)
//         {
//             Arrays.fill(newTemp,-1);
//         }
//         int finalAliceScore=helper(piles,0,piles.length-1,dp);
//         int sum=0;
//         for(int a:piles)
//         sum+=a;
//         if(finalAliceScore>(sum/2))
//         return true;
//         return false;
//     }
//     public int helper(int piles[],int i,int j,int dp[][])
//     {
//         if(i>j)
//         {
//             return 0;
//         }
//         if(dp[i][j]!=-1)
//         return dp[i][j];
//         int way1=piles[i]+helper(piles,i+1,j,dp);
//         int way2=piles[j]+helper(piles,i,j-1,dp);
//         return dp[i][j]=Math.max(way1,way2);
//     }
// }

//  Best is Neetcode solution , https://www.youtube.com/watch?v=uhgdXOlGYqE
// also understand O(1) approach


class Solution {
    public boolean stoneGame(int[] piles) {
        int dp[][]=new int[piles.length][piles.length];
        for(int newTemp[]:dp)
        {
            Arrays.fill(newTemp,-1);
        }
        int finalAliceScore=helper(piles,0,piles.length-1,dp);
        int sum=0;
        for(int a:piles)
        sum+=a;
        if(finalAliceScore>(sum/2))
        return true;
        return false;
    }
    public int helper(int piles[],int i,int j,int dp[][])
    {
        if(i>j)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        return dp[i][j];
        int way1=0,way2=0;
        if(j-i%2==0) // bob turn
        { 
            way1=helper(piles,i+1,j,dp);
            way2=helper(piles,i,j-1,dp);
        }
        else // alice turn
        {
            way1=piles[i]+helper(piles,i+1,j,dp);
            way2=piles[j]+helper(piles,i,j-1,dp);
        }
        return dp[i][j]=Math.max(way1,way2);
    }
}

// 3d dp approach mein TLE aa raha hai so tum 2d dp approach ko hi prefer karo

// class Solution {
//     public boolean stoneGame(int[] piles) {
//         int dp[][][]=new int[piles.length][piles.length][2];
//         for(int temp[][]:dp)
//         {
//             for(int newTemp[]:temp)
//             {
//                 Arrays.fill(newTemp,-1);
//             }
//         }
//         int finalAliceScore=helper(piles,0,piles.length-1,1,dp); // 1 denotes alice and 0 denotes bob
//         int sum=0;
//         for(int a:piles)
//         sum+=a;
//         if(finalAliceScore>(sum/2))
//         return true;
//         return false;
//     }
//     public int helper(int piles[],int i,int j,int player,int dp[][][])
//     {
//         if(i>j)
//         {
//             return 0;
//         }
//         if(dp[i][j][player]!=-1)
//         return dp[i][j][player];
//         int newPlayer=0;
//         if(player==0)
//         newPlayer=1;
//         int way1=0,way2=0;
//         if(j-i%2==0) // bob turn
//         { 
//             way1=helper(piles,i+1,j,newPlayer,dp);
//             way2=helper(piles,i,j-1,newPlayer,dp);
//         }
//         else // alice turn
//         {
//             way1=piles[i]+helper(piles,i+1,j,newPlayer,dp);
//             way2=piles[j]+helper(piles,i,j-1,newPlayer,dp);
//         }
//         return dp[i][j][newPlayer]=Math.max(way1,way2);
//     }
// }