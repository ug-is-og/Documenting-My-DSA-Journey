//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int X = Integer.parseInt(inputLine[1]);
		    int A[] = new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        A[i] = Integer.parseInt(inputLine[i]);
		    }
		    Solution ob=new Solution();
		    boolean ans = ob.find3Numbers(A, n, X);
		    System.out.println(ans?1:0);
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find if there exists a triplet in the 
    //array A[] which sums up to X.
    public static boolean find3Numbers(int A[], int n, int X) { 
    
       Arrays.sort(A);
       boolean ans=false;
       for(int i=0;i<n;i++)
       {
           ans=ans||twoPointer(A,i+1,n-1,X-A[i]);
           if(ans)
           {
               return true;
           }
       }
       return false;
    }
    public static boolean twoPointer(int A[],int start,int end,int target)
    {
        while(start<end) // start<=end nahi kar sakte dhyan se socho , 2 distinct elements chahiye hame 
        {
            int sum=A[start]+A[end];
            if(sum==target)
            {
                return true;
            }
            else if(sum<target)
            {
                start++;
            }
            else
            {
                end--;
            }
        }
        return false;
    }
}
