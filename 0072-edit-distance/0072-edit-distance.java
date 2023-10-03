class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][]=new int[word1.length()+1][word2.length()+1];
        for(int temp[]:dp)
        Arrays.fill(temp,-1);
        return helper(word1,word2,word1.length(),word2.length(),dp);
    }
    public int helper(String word1,String word2,int m,int n,int dp[][])
    {
        if(m==0||n==0)
        {
            if(n!=0)
            return n;
            return m;
        }
        if(dp[m][n]!=-1)
        return dp[m][n];
        int ans=0;
        if(word1.charAt(m-1)==word2.charAt(n-1))
        {
            ans=helper(word1,word2,m-1,n-1,dp);
        }
        else
        {
            ans=1+Math.min(helper(word1,word2,m-1,n,dp),Math.min(helper(word1,word2,m-1,n-1,dp),helper(word1,word2,m,n-1,dp)));
        }
        return dp[m][n]=ans;
    }
}