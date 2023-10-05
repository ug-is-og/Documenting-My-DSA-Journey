//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.countSub(a, n) ? 1:0);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public boolean countSub(long arr[], long n)
    {
        return heapCheck(arr,0);
    }
    public boolean heapCheck(long arr[],int parentIndex)
    {
        int leftChildIndex=2*parentIndex+1;
        int rightChildIndex=2*parentIndex+2;
        boolean ans=false;
        if(leftChildIndex>=arr.length)
        return true;
        if(arr[parentIndex]<arr[leftChildIndex])
        {
            return false;
        }
        else
        {
            if(rightChildIndex<arr.length)
            {
                if(arr[rightChildIndex]<arr[parentIndex])
                {
                    ans=heapCheck(arr,leftChildIndex)&&heapCheck(arr,rightChildIndex);
                }
                else
                {
                    return false;
                }
            }
            else
            {
                ans=heapCheck(arr,leftChildIndex);
            }
        }
        return ans;
    }
}