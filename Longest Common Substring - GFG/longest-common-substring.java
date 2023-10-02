//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        int dp[][]=new int[n+1][m+1];
        for(int temp[]:dp)
        Arrays.fill(temp,-1);
        return helper(S1,S2,n,m,dp);
    }
    public int helper(String S1,String S2,int n,int m,int dp[][])
    {
        if(n==0||m==0)
        return 0;
        if(dp[n][m]!=-1)
        return dp[n][m];
        char a=S1.charAt(n-1);
        char b=S2.charAt(m-1);
        int n1=n,m1=m,ans1=0,ans2=0;
        if(a==b)
        {
            while(n1>0&&m1>0)
            {
                char a1=S1.charAt(n1-1);
                char b1=S2.charAt(m1-1);
                if(a1==b1)
                {
                    ans1++;
                    n1--;
                    m1--;
                }
                else
                {
                   break;
                }
            }
             ans1=Math.max(ans1,Math.max(helper(S1,S2,n-1,m,dp),helper(S1,S2,n,m-1,dp)));
        }
        else
        {
            ans2=Math.max(helper(S1,S2,n-1,m,dp),helper(S1,S2,n,m-1,dp));
        }
        return dp[n][m]=Math.max(ans1,ans2);
    }
}