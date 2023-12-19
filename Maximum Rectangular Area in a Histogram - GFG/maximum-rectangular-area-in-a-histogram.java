//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        int k=(int)n;
        int NSR[]=new int[k];
        int NSL[]=new int[k];
        buildNSR(NSR,hist,k);
        buildNSL(NSL,hist,k);
        long ans=0;
        for(int i=0;i<k;i++)
        {
            ans=Math.max(ans,(NSR[i]-NSL[i]-1)*hist[i]);
        }
        return ans;
    }
    public static void buildNSL(int NSL[],long hist[],int n)
    {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty()&&hist[st.peek()]>=hist[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                NSL[i]=-1;
            }
            else
            {
                NSL[i]=st.peek();
            }
            st.push(i);
        }
    }
    public static void buildNSR(int NSR[],long hist[],int n)
    {
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty()&&hist[st.peek()]>=hist[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                NSR[i]=n;
            }
            else
            {
                NSR[i]=st.peek();
            }
            st.push(i);
        }
    }
        
}



