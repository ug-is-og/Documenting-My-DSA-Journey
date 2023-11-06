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


class Solution{

	public int minCoins(int coins[], int M, int V) 
	{ 
	    int dp[][]=new int[V+1][M];
	    for(int temp[]:dp)
	    {
	        Arrays.fill(temp,-1);
	    }
	    int ans=helper(coins,V,dp,0);
	    if(ans==1000000)
	    {
	        return -1;
	    }
	    return ans;
	} 
	public int helper(int coins[],int V,int dp[][],int index)
	{
	    if(V==0)
	    {
	        return 0;
	    }
	    if(index==coins.length)
	    {
	        return 1000000;
	    }
	    if(dp[V][index]!=-1)
	    {
	        return dp[V][index];
	    }
	    int min=Integer.MAX_VALUE;
	    for(int i=0;i<=V/coins[index];i++)
	    {
	        min=Math.min(min,i+helper(coins,V-i*coins[index],dp,index+1));
	    }
	    return dp[V][index]=min;
	}
}