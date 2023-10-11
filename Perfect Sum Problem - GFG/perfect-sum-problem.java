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
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends




// Approach 1 - (Completely Recursive ) (n to 0) ------------------------------------->

// Sirji recursive se toh ho gaya
 
// class Solution{

// 	public int perfectSum(int arr[],int n, int sum) 
// 	{ 
// 	   if(sum==0)
// 	   {
// 	       int countZeros=0;
// 	       for(int i=1;i<=n;i++)
// 	       {
// 	           if(arr[i-1]==0)
// 	           countZeros++;
// 	       }
// 	       return (int)Math.pow(2,countZeros)*1;
// 	   }
// 	   if(n==0)
// 	   return 0;
// 	   //if(sum==0)
// 	   //return 1;
// 	   int ways=0;
// 	   //pick and non pick condition
// 	   if(arr[n-1]<=sum)
// 	   ways=perfectSum(arr,n-1,sum-arr[n-1])+perfectSum(arr,n-1,sum);
// 	   else
// 	   ways=perfectSum(arr,n-1,sum);
// 	   return ways;
// 	} 
// }

// Approach 2- (Memoization on approach) (n to 0)-------------------------------------->

// class Solution{
//     public int perfectSum(int arr[], int n,int sum)
//     {
//         int dp[][]=new int[n+1][sum+1];
//         for(int temp[]:dp)
//         Arrays.fill(temp,-1);
//         return helper(arr,n,sum,dp);
//     }
//     public int helper(int arr[],int n,int sum,int dp[][])
//     {
//         if(sum==0)
// 	   {
// 	       int countZeros=0;
// 	       for(int i=1;i<=n;i++)
// 	       {
// 	           if(arr[i-1]==0)
// 	           countZeros++;
// 	       }
// 	       return (int)Math.pow(2,countZeros)*1;
// 	   }
// 	   if(n==0)
// 	   return 0;
// 	   if(dp[n][sum]!=-1)
// 	   return dp[n][sum];
// 	   int ways=0;
// 	   //pick and non pick condition
// 	   if(arr[n-1]<=sum)
// 	   ways=(helper(arr,n-1,sum-arr[n-1],dp)+helper(arr,n-1,sum,dp))%1000000007;
// 	   else
// 	   ways=helper(arr,n-1,sum,dp)%1000000007;
// 	   return dp[n][sum]=ways%1000000007;
//     }
// }


// Approach 3 (Tabulation)(n to 0) ------------------------------------------------->


// class Solution{
//     public int perfectSum(int arr[],int n,int sum)
//     {
//         int dp[][]=new int[n+1][sum+1];
//         int k=1;
//         //initialisation using base condition of recursion 
//         for(int i=0;i<n+1;i++)
//         {
//             if(i>0&&arr[i-1]==0)
//             k=k*2;
//             dp[i][0]=k;
//         }
//         //tabulation
//         for(int i=1;i<n+1;i++)
//         {
//             for(int j=1;j<sum+1;j++)
//             {
//                 if(j>=arr[i-1])
//                 dp[i][j]=(dp[i-1][j-arr[i-1]]+dp[i-1][j])%1000000007;
//                 else
//                 dp[i][j]=dp[i-1][j]%1000000007;
//             }
//         }
//         return dp[n][sum]%1000000007;
//     }
// }


// tumne iss nayi approach mein zaada dimaag laga diya hai and 1 size used array use karli, isme memoization use hi nahi karpaoge
// kyunki return type void le rakha hai bhaisahab aapne toh

//  class Solution{

// 	public int perfectSum(int arr[],int n, int sum) 
// 	{ 
// 	   int count[]=new int[1];
// 	   int cnt=0;
//       helper(arr.length,arr,sum,count);
       
        
//         // yeh approach fail ho jayegi, recursion mein ghuske dekhna padega kahan dikakt aa rahi
        
//         // find the number of zeroes
//         // for(int a:arr)
//         // {
//         //     if(a==0)
//         //     cnt++;
//         // }
//          return count[0];
// 	} 
// 	public static void helper(int index,int num[],int tar,int count[])
//     {
//         int k=0;
//         if(tar==0)
//         {
//             // 6 10
//             // 2 0 5 0 8 10
//             // iss test case ko bhot dhyan se dekho bhaii, issi ki wajah se yeh loop lagaya hai to check ki 
//             // index ke pehle tak kitne zeroes aa rahe hai
//             // aur upar wali approach nahi chalegi
//             for(int i=0;i<index;i++) 
//             {
//                 if(num[i]==0)
//                 k++;
//             }
//             count[0]=count[0]+(int)Math.pow(2,k);
//             return;
//         }
//         if(index==0)
//         {
//             return;
//         }
//         if(tar>=num[index-1])
//         {
//             helper(index-1,num,tar-num[index-1],count);
//             helper(index-1,num,tar,count);
//         }
//         else
//         {
//             helper(index-1,num,tar,count);
//         }
//     }
// }

















 class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	   int dp[][]=new int[sum+1][n];
	   for(int temp[]:dp)
	   {
	       Arrays.fill(temp,-1);
	   }
	   return helper(arr,sum,dp,0);
	} 
	public int helper(int arr[],int sum,int dp[][],int index)
	{
	    int count=0;
	    if(sum==0)
	    {
	        for(int i=index;i<arr.length;i++)
	        {
	           if(arr[i]==0)
	           {
	               count++;
	           }
	        }
	        return (int)Math.pow(2,count);
	    }
	    if(index==arr.length||sum<0)
	    {
	        return 0;
	    }
	    if(dp[sum][index]!=-1)
	    {
	        return dp[sum][index];
	    }
	    return dp[sum][index]=((helper(arr,sum,dp,index+1))%1000000007+helper(arr,sum-arr[index],dp,index+1)%1000000007)%1000000007;
	}
}
















