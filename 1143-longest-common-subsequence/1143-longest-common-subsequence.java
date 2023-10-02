class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int dp[][]=new int[m+1][n+1];
        for(int temp[]:dp)
        Arrays.fill(temp,-1);
        return helper(text1,text2,m,n,dp);
    }
    public int helper(String s1,String s2,int m,int n,int dp[][])
    {
        if(m==0||n==0)
        return 0;
        char a=s1.charAt(m-1);
        char b=s2.charAt(n-1);
        int ans1=0,ans2=0;
        if(dp[m][n]!=-1)
        return dp[m][n];
        if(a==b)
        {
            ans1=Math.max(1+helper(s1,s2,m-1,n-1,dp),Math.max(helper(s1,s2,m,n-1,dp),helper(s1,s2,m-1,n,dp)));
        }
        else
        {
            ans2=Math.max(helper(s1,s2,m,n-1,dp),helper(s1,s2,m-1,n,dp));
        }
        return dp[m][n]=Math.max(ans1,ans2);
    }
}