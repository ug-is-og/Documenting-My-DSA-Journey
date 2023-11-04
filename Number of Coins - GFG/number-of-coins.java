//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


// This question is under greedy tag in Striver's sheet, but it isn't a greedy algo question, it's a dp question

class Solution
{
	public int minCoins(int coins[], int M, int V) 
	{ 
	    int dp[][]=new int[M][V+1];
	    for(int temp[]:dp)
	    {
	        Arrays.fill(temp,-1);
	    }
	    int ans=helper(0,coins,V,dp);
	    if(ans>=1000000)
	    {
	        return -1;
	    }
	    return ans;
	} 
	public int helper(int index,int coins[],int V,int dp[][])
	{
	    if(V==0)
	    {
	        return 0;
	    }
	    if(index==coins.length)
	    {
	        return 1000000;
	    }
	    if(dp[index][V]!=-1)
	    {
	        return dp[index][V];
	    }
	    int min=Integer.MAX_VALUE;
	    for(int i=0;i<=V/coins[index];i++)
	    {
	        min=Math.min(min,i+helper(index+1,coins,V-(i*coins[index]),dp));
	    }
	    return dp[index][V]=min;
	}
}