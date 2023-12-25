// jahan pe losers and mediocres ki mehnat khatam hoti hai wahan se outliers ki mehnat chalu hoti hai

// yeh recursive approach kaam toh kar gayi hai par iss recursive approach pe DP nahi laga sakte bilkul bhi...

// ab ek cheez ko samjho tumhe agar aese hi out of the blue question aa jaye aur tumhe samajh hi nahi aa ra dp kaise lagaun, toh tum sabse bade gadhe ho, tumhe iss cheez pe dhyan hi nahi dena hai start mein ki dp lagaun kaise, sabse pehle toh yeh socho ki jo question diya hua hai usko manually kaise solve karte tum, yeh sochne ke baad, usko code mein kaise convert karoge, ab jab code mein onvert karne gaye, tab socha ki haan ya recursive based ja ra toh recursion use kar lete hai, jab recursion kar liya hai uske baad dp ka khayal aana chhahiye ...

// ab hame sochna hai ki dp kaise lag ri yahan pe 

// class Solution {
//     public int countSquares(int[][] matrix) {
//         int count=0;
//         for(int i=0;i<matrix.length;i++)
//         {
//             for(int j=0;j<matrix[0].length;j++)
//             {
//                 if(matrix[i][j]==1)
//                 {
//                     count=count+1+helper(matrix,i,j,i+1,j+1);
//                 }
//             }
//         }
//         return count;
//     }
//     public int helper(int matrix[][],int oi,int oj,int i,int j)
//     {
//         if(!(i<matrix.length&&j<matrix[0].length))
//         {
//             return 0;
//         }
//         int count=0;
//         for(int m=oi;m<=i;m++)
//         {
//             for(int n=oj;n<=j;n++)
//             {
//                 if(matrix[m][n]!=1)
//                 {
//                     return 0;
//                 }
//             }
//         }
//         return 1+helper(matrix,oi,oj,i+1,j+1);
//     }
// }

// upar wali recursive approach pe dp lagane ka koi faayda hi nahi
// watch this video carefully
// https://youtu.be/auS1fynpnjo

// class Solution {
//     public int countSquares(int[][] matrix) {
//         int dp[][]=new int[matrix.length][matrix[0].length];
//         int sum=0;
//         //initialization
//         for(int i=0;i<matrix.length;i++)
//         {
//           dp[i][0]=matrix[i][0];
//         }
//         for(int j=0;j<matrix[0].length;j++)
//         {
//           dp[0][j]=matrix[0][j];
//         }
//         for(int i=1;i<dp.length;i++)
//         {
//           for(int j=1;j<dp[0].length;j++)
//           {
//             if(matrix[i][j]==1)
//             dp[i][j]=Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j]))+1;
//           }
//         }
//         for(int i=0;i<dp.length;i++)
//         {
//           for(int j=0;j<dp[0].length;j++)
//           {
//             sum=sum+dp[i][j];
//           }
//         }
//         return sum;
//     }
// }

















class Solution {
    public int countSquares(int[][] matrix) {
        int dp[][]=new int[matrix.length][matrix[0].length];
        int count=0;
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                if(matrix[i][j]==0)
                continue;
                if(i==0||j==0)
                {
                    dp[i][j]=1;
                }
                else
                {
                    dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
                }
                count=count+dp[i][j];
            }
        }
        return count;
    }
}