class Solution {
    public int countSubstrings(String s) {
        int dp[][]=new int[s.length()][s.length()];
        int count=0;
        for(int k=0;k<s.length();k++)
        {
            for(int i=0,j=k;j<s.length();j++,i++)
            {
                if(k==0)
                {
                    dp[i][j]=1;
                    count++;
                }
                else if(k==1)
                {
                    if(s.charAt(i)==s.charAt(j))
                    {
                        dp[i][j]=1;
                        count++;
                    }
                }
                else
                {
                    if((s.charAt(i)==s.charAt(j))&&dp[i+1][j-1]==1)
                    {
                        dp[i][j]=1;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}