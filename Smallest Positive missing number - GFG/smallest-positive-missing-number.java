//{ Driver Code Starts
import java.util.*;
import java.io.*;


// } Driver Code Ends


// TC : O(nlogn) and SC: O(1)
class Solution
{
    static int missingNumber(int arr[], int size)
    {
        Arrays.sort(arr);
        int count=1,num=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>0)
            {
                if(num==0)
                {
                    num=arr[i];
                    if(num!=count)
                    return count;
                }
                else
                {
                    if(arr[i]!=num)
                    {
                       num=arr[i];
                       count++;
                       if(count!=arr[i])
                       return count;
                    }
                }
            }
        }
        if(num==0) // matlab ek bhi positive number nahi mila, eg n=1 arr= {0}
        return count;
        return count+1;
    }
}


//{ Driver Code Starts.

class Main
{   
    public static void main (String[] args) throws IOException
    {

		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		
        //taking testcases
		int t=Integer.parseInt(in.readLine().trim());
		while(t-->0){
		    
		    //input number n
			int n=Integer.parseInt(in.readLine().trim());
			int[] arr=new int[n];
			String s[]=in.readLine().trim().split(" ");
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=Integer.parseInt(s[i]);
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			out.println(missing);
		}
		out.close();
    }
}


// } Driver Code Ends