class Solution {
    public boolean isMatch(String s, String p) {
        int dp[][]=new int[s.length()+1][p.length()+1];
        for(int temp[]:dp)
        Arrays.fill(temp,-1);
        return helper(s,p,s.length(),p.length(),dp);
    }
    public boolean helper(String s,String p,int m,int n,int dp[][])
    {
        if(m==0&&n==0)
        return true;
        if(m!=0&&n==0)
        return false;
        if(m==0&&n!=0)
        {
            for(int i=n;i>0;i--)// check if all the leftovers are *
            {
                if(p.charAt(i-1)!='*')
                return false;
            }
            return true;
        }
        if(dp[m][n]!=-1)
        {
            if(dp[m][n]==1)
            return true;
            return false;
        }
        boolean ans=false;
        if(s.charAt(m-1)==p.charAt(n-1)||p.charAt(n-1)=='?')
        {
            ans=helper(s,p,m-1,n-1,dp);
        }
        else
        {
            if(p.charAt(n-1)=='*')
            {
                for(int i=m;i>=0;i--)
                {
                    ans=ans||helper(s,p,i,n-1,dp);
                }
            }
            else
            {
                ans=false;
            }
        }
        if(ans==true)
        dp[m][n]=1;
        else
        dp[m][n]=0;
        return ans;
    }
}