//{ Driver Code Starts
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
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        int dp[][]=new int[arr.length][sum+1];
        for(int temp[]:dp)
        {
            Arrays.fill(temp,-1);
        }
        return helper(dp,0,sum,arr);
    }
    static boolean helper(int dp[][],int index,int remSum,int arr[])
    {
        if(remSum==0)
        {
            return true;
        }
        if(remSum<0||index==arr.length)
        {
            return false;
        }
        if(dp[index][remSum]!=-1)
        {
            if(dp[index][remSum]==1)
            return true;
            return false;
        }
        boolean ans=helper(dp,index+1,remSum,arr)||helper(dp,index+1,remSum-arr[index],arr);
        if(ans)
        {
            dp[index][remSum]=1;
        }
        else
        {
            dp[index][remSum]=0;
        }
        return ans;
    }
}