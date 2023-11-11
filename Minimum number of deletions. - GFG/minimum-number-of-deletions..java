//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            String str = read.readLine().strip();
            Solution ob = new Solution();
            long ans = ob.minDeletions(str, n); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


// ab meri baat samjho, iss code snippet se tum no of deletions nikal loge par min. no of deleteions nahi
// aayenge, iss liye yeh approach galat hai

// class Solution 
// { 
//     int minDeletions(String str, int n)
//     {
//         String rev="";
//         int count=0;
//         for(int i=0;i<str.length();i++)
//         {
//             rev=str.charAt(i)+rev;
//         }
//         for(int i=0;i<str.length();i++)
//         {
//             if(str.charAt(i)!=rev.charAt(i))
//             {
//                 count++;
//             }
//         }
//         return count;
//     }
// } 


class Solution 
{ 
    int minDeletions(String str, int n)
    {
        String rev="";
        int count=0;
        for(int i=0;i<str.length();i++)
        {
            rev=str.charAt(i)+rev;
        }
        int dp[][]=new int[n+1][n+1];
        for(int temp[]:dp)
        {
            Arrays.fill(temp,-1);
        }
        return str.length()-helper(str,rev,n,n,dp);
    }
    int helper(String s1,String s2,int m,int n,int dp[][])
    {
        if(m==0||n==0)
        {
            return 0;
        }
        if(dp[m][n]!=-1)
        {
            return dp[m][n];
        }
        int ans=0;
        if(s1.charAt(m-1)==s2.charAt(n-1))
        {
            ans=1+helper(s1,s2,m-1,n-1,dp);
        }
        else
        {
            ans=Math.max(helper(s1,s2,m-1,n,dp),helper(s1,s2,m,n-1,dp));
        }
        return dp[m][n]=ans;
    }
} 