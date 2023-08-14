// tumne recursive solution mein logic sahi build kiya hai par bhot zaada complicate kar diya hai matlab i==-1 bhejna fir i+2 pe call lagana wagera
// let's optimize this thing uske baad ham memoize karenge

// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//         return helper(-1,0,matrix);
//     }
//     public int helper(int i,int j,int matrix[][])
//     {
//         if(j<0||j>=matrix[0].length)
//         return 10000;
//         if(i==matrix.length-1)
//         return matrix[i][j];
//         if(i>=matrix.length-1)
//         return 0;
//         int localMin=Integer.MAX_VALUE;
//         int ans=Integer.MAX_VALUE;
//         int localAns=Integer.MAX_VALUE;
//         int ans=Integer.MAX_VALUE;
//         if(i==-1)
//         {
//             for(int k=0;k<matrix[0].length;k++)
//             {
//                 int way1=helper(i+2,k,matrix);
//                 int way2=helper(i+2,k-1,matrix);
//                 int way3=helper(i+2,k+1,matrix);
//                 localMin=Math.min(way1,Math.min(way2,way3));
//                 localAns=matrix[0][k]+localMin;
//                 if(localAns<ans)
//                 ans=localAns;
//             }
//         }
//         else
//         {
//             int way1=helper(i+1,j,matrix);
//             int way2=helper(i+1,j-1,matrix);
//             int way3=helper(i+1,j+1,matrix);
//             localMin=Math.min(way1,Math.min(way2,way3));
//             ans=matrix[i][j]+localMin;
//         }
//         return ans;
//     }
// }

// doing recursive optimizations
// ab likha hai badhiya approach
// let's memoize this

//  class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//         int min=Integer.MAX_VALUE;
//         for(int j=0;j<matrix[0].length;j++)
//         {
//             min=Math.min(min,helper(0,j,matrix));
//         }
//         return min;
//     }
//     public int helper(int i,int j,int matrix[][])
//     {
//         if(j<0||j>=matrix[0].length)
//         return 10000;
//         if(i==matrix.length-1)
//         return matrix[i][j];
//         int way1=helper(i+1,j,matrix);
//         int way2=helper(i+1,j-1,matrix);
//         int way3=helper(i+1,j+1,matrix);
//         return matrix[i][j]+Math.min(way1,Math.min(way2,way3));
//     }
// }

// memoizing the above approach

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min=Integer.MAX_VALUE;
        int dp[][]=new int[matrix.length][matrix[0].length];
        for(int temp[]:dp)
        Arrays.fill(temp,Integer.MIN_VALUE); // harr jagah -1 nahi chalega, thoda sambhal ke guru, isme last test case mein TLE aa ra tha due to -1 initialisation
        for(int j=0;j<matrix[0].length;j++)
        {
            min=Math.min(min,helper(0,j,matrix,dp));
        }
        return min;
    }
    public int helper(int i,int j,int matrix[][],int dp[][])
    {
        if(j<0||j>=matrix[0].length)
        return 10000;
        if(i==matrix.length-1)
        return matrix[i][j];
        if(dp[i][j]!=Integer.MIN_VALUE)
        return dp[i][j];
        int way1=helper(i+1,j,matrix,dp);
        int way2=helper(i+1,j-1,matrix,dp);
        int way3=helper(i+1,j+1,matrix,dp);
        return dp[i][j]=matrix[i][j]+Math.min(way1,Math.min(way2,way3));
    }
}