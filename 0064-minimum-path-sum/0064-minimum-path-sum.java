// yeh recursion wala solution chal raha tha, ab isko memoize karke dekhte hai

// class Solution {
//     public int minPathSum(int[][] grid) {
//         int ans=helper(0,0,grid);
//         return ans;
//     }
//     public int helper(int i,int j,int grid[][])
//     {
//         if(i==grid.length-1&&j==grid[0].length-1)
//         return grid[i][j];
//         if(i<0||j<0||i>=grid.length||j>=grid[0].length)
//         return 4000000;
//         int way1=helper(i,j+1,grid);
//         int way2=helper(i+1,j,grid);
//         int min=Math.min(way1,way2);
//         return grid[i][j]+min;
//     }
// }

// upar wali recursive approach ko memoize karke dekhte hai
// par wrong answer aa raha hai
// yeh aa rahi dp array end mein
// 0 0 0 
// 0 0 0 
// 0 0 0 

// class Solution {
//     public int minPathSum(int[][] grid) {
//         int dp[][]=new int[grid.length][grid[0].length];
//         for(int temp[]:grid)
//         Arrays.fill(temp,-1);
//         int ans=helper(0,0,grid,dp);
//         for(int i=0;i<dp.length;i++)
//         {
//             for(int j=0;j<dp[0].length;j++)
//             System.out.print(dp[i][j]+" ");
//             System.out.println();
//         }
//         return ans;
//     }
//     public int helper(int i,int j,int grid[][],int dp[][])
//     {
//         if(i==grid.length-1&&j==grid[0].length-1)
//         return grid[i][j];
//         if(i<0||j<0||i>=grid.length||j>=grid[0].length)
//         return 4000000;
//         if(dp[i][j]!=-1)
//         return dp[i][j];
//         int way1=helper(i,j+1,grid,dp);
//         int way2=helper(i+1,j,grid,dp);
//         int min=Math.min(way1,way2);
//         return dp[i][j]=grid[i][j]+min;
//     }
// }

// ab samajhte hai ki dikkat kyaa aa rahi exactly
// tumne grid ke saare elements ko -1 kar diya tha iss liye dikkat ho ri
// hame dp array initialize karna tha
// faltu ke print statements lagane se beats kharab hota hai

class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][]=new int[grid.length][grid[0].length];
        for(int temp[]:dp)
        Arrays.fill(temp,-1);
        int ans=helper(0,0,grid,dp);
        return ans;
    }
    public int helper(int i,int j,int grid[][],int dp[][])
    {
        if(i==grid.length-1&&j==grid[0].length-1)
        return grid[i][j];
        if(i<0||j<0||i>=grid.length||j>=grid[0].length)
        return 4000000;
        if(dp[i][j]!=-1)
        return dp[i][j];
        int way1=helper(i,j+1,grid,dp);
        int way2=helper(i+1,j,grid,dp);
        int min=Math.min(way1,way2);
        return dp[i][j]=grid[i][j]+min;
    }
}