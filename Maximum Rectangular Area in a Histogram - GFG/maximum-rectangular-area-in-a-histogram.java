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
       // we need next smaller element to the left
       // also next smaller element to the right
       int NSL[]=new int[(int)n];
       int NSR[]=new int[(int)n];
       fillNSL(NSL,hist);
       fillNSR(NSR,hist);
       return operations(NSL,NSR,hist);
    }
    public static long operations(int NSL[],int NSR[],long hist[])
    {
        long maxArea=0;
        long tempArea=0;
        for(int i=0;i<hist.length;i++)
        {
            tempArea=hist[i]*((NSR[i]-1)-(NSL[i]+1)+1);
            maxArea=Math.max(maxArea,tempArea);
        }
        return maxArea;
    }
    public static void fillNSR(int NSR[],long hist[])
    {
        NSR[NSR.length-1]=hist.length;
        Stack<Integer> st=new Stack<>();
        st.add(hist.length-1);// indexes ke saath khelo
        for(int i=hist.length-2;i>=0;i--)
        {
            while(!st.isEmpty()&&hist[st.peek()]>=hist[i])
            st.pop();
            if(st.isEmpty())
            NSR[i]=hist.length;
            else
            NSR[i]=st.peek();
            st.add(i);
        }
    }
    public static void fillNSL(int NSL[],long hist[])
    {
        NSL[0]=-1;
        Stack<Integer> st=new Stack<>();
        st.add(0);// indexes se saath khelo
        for(int i=1;i<NSL.length;i++)
        {
            while(!st.isEmpty()&&hist[st.peek()]>=hist[i])
            st.pop();
            if(st.isEmpty())
            NSL[i]=-1;
            else
            NSL[i]=st.peek();
            st.add(i);
        }
    }
}



