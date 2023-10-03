// before doing this question : you should know tabulation of LCSubseq then tabulation of printing LCSubseq then come to this question

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m=str1.length();
        int n=str2.length();
        int dp[][]=new int[m+1][n+1];
        int ans1=0,ans2=0;
        String ans="";
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
                if(str1.charAt(i-1)==str2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        // printing dp so that I can build the logic

        // for(int i=0;i<dp.length;i++)
        // {
        //     for(int j=0;j<dp[0].length;j++)
        //     {
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        int i=m,j=n;
        while(i>0&&j>0)
        {
            if(str1.charAt(i-1)==str2.charAt(j-1))
            {
                ans=str1.charAt(i-1)+ans;
                i--;
                j--;
            }
            else
            {
                if(dp[i-1][j]>dp[i][j-1]) // yahan pe ek simple sa funda samjho ki agar tum Longest Common Subsequence ke tabulation approach ko backtrack karoge and along with that ek string maintain karte jaoge toh tum longest common supersequence tak pahunch jaoge
                {
                    ans=str1.charAt(i-1)+ans;
                    i--;
                }
                else
                {
                    ans=str2.charAt(j-1)+ans;
                    j--;
                }
            }
        }
        while(i>0)
        {
            ans=str1.charAt(i-1)+ans;
            i--;
        }
        while(j>0)
        {
            ans=str2.charAt(j-1)+ans;
            j--;
        }
        return ans;
    }
}