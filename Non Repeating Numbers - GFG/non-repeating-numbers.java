//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

// trying in O(n logn) time

// class Solution
// {
//     public int[] singleNumber(int[] nums)
//     {
//         int ans[]=new int[2];
//         int k=0;
//         Arrays.sort(nums);
//         for(int i=1;i<nums.length;i++)
//         {
//             if(nums[i]==nums[i-1])
//             i++;
//             else
//             ans[k++]=nums[i-1];
//         }
//         if(k==1)
//         ans[k]=nums[nums.length-1];
//         return ans;
//     }
// }

// can also do in O(n) time and O(n) space easily using hashmap

// O(n^2) mein bhi ho jayega yeh question

// let's do it in O(n) time and O(1) space
// using bit manipulation


class Solution
{
    public int[] singleNumber(int[] nums)
    {
        int ans[]=new int[2];
        int xxory=0;
        for(int i=0;i<nums.length;i++)
        xxory=xxory^nums[i];
        int rsbm=xxory&-xxory;
        int x=0,y=0;
        for(int i=0;i<nums.length;i++)
        {
            if((nums[i]&rsbm)==0)
            {
                x=x^nums[i];
            }
            else
            {
                y=y^nums[i];
            }
        }
        if(x<y)
        {
            ans[0]=x;
            ans[1]=y;
        }
        else
        {
            ans[0]=y;
            ans[1]=x;
        }
        return ans;
    }
}

