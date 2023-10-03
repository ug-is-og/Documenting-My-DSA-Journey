// yeh toh ho gaya using recursion + memoization

// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int m=text1.length();
//         int n=text2.length();
//         int dp[][]=new int[m+1][n+1];
//         for(int temp[]:dp)
//         Arrays.fill(temp,-1);
//         return helper(text1,text2,m,n,dp);
//     }
//     public int helper(String s1,String s2,int m,int n,int dp[][])
//     {
//         if(m==0||n==0)
//         return 0;
//         char a=s1.charAt(m-1);
//         char b=s2.charAt(n-1);
//         int ans1=0,ans2=0;
//         if(dp[m][n]!=-1)
//         return dp[m][n];
//         if(a==b)
//         {
//              ans1=1+helper(s1,s2,m-1,n-1,dp);

// //             ans1=1+Math.max(helper(s1,s2,m-1,n-1,dp),Math.max(helper(s1,s2,m,n-1,dp),helper(s1,s2,m-1,n,dp)));

// // yahan pe (m-1,n) and (m,n-1) tak jaane ki zarurat hi nahi thi, zabardasti ke calls badha re 
// // code toh accept ho jayega parr faayda kya hua

//         }
//         else
//         {
//             ans2=Math.max(helper(s1,s2,m,n-1,dp),helper(s1,s2,m-1,n,dp));
//         }
//         return dp[m][n]=Math.max(ans1,ans2);
//     }
// }

// we need to learn the tabulation for this and it is very important as you will face difficulty, in Print LCS question + you won't be able to do Shortest common supersequence question

// tabulation se mat dara karr bhaii, here are 5 key pointers to keep in mind :

// 1. Declare the DP array
// 2. Understand what each cell stands for
// 3. Initialise the DP array
// 4. Fill it using recurrence relationfrom memoization approach
// 5. Keep in mind 1 basic thing for memoization ham deep down ek recursive call ke liye chale jaate hai and wapas aate samay computed values ko store kar lete hai taaki agli recursive call mein I have stuff stored with me and baar baar cheezein na compute karni pade
// Tabulation ke case mein ham chhote chhote steps se hi chalu karte hai and after that bade steps ki taraf jaate hai

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int dp[][]=new int[m+1][n+1];
        int ans1=0,ans2=0;
        // initialisation
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                if(i==0||j==0)
                dp[i][j]=0;
            }
        }
        // fill up your dp array
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}