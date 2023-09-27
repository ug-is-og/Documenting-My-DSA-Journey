class Solution {
    public String longestPalindrome(String s) {
        boolean dp[][]=new boolean[s.length()][s.length()];
        int max=Integer.MIN_VALUE;
        String ans="";
        for(int i=0;i<dp[0].length;i++)
        {
            for(int j=0,k=j+i;j<dp.length&&k<dp[0].length;j++,k++)
            {
                if(j==k)
                {
                    dp[j][k]=true;
                }
                if(k==j+1&&s.charAt(j)==s.charAt(k))
                {
                    dp[j][k]=true;
                }
                if(k>j+1&&s.charAt(j)==s.charAt(k)&&dp[j+1][k-1]==true)
                {
                    dp[j][k]=true;
                }
                if(dp[j][k]==true)
                {
                    if(max<(k-j+1))
                    {
                        max=k-j+1;
                        ans=s.substring(j,k+1);
                    }
                }
            }
        }
        return ans;
    }
}