//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{ 
    static String isKSortedArray(int arr[], int n, int k) 
    { 
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        List<Integer> temp=new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            if(map.containsKey(arr[i]))
            {
                temp=map.get(arr[i]);
                temp.add(i);
                map.put(arr[i],temp);
            }
            else
            {
                temp=new ArrayList<>();
                temp.add(i);
                map.put(arr[i],temp);
            }
        }
        Arrays.sort(arr);
        //System.out.println(map);
        for(int i=0;i<arr.length;i++)
        {
            temp=map.get(arr[i]);
            if(temp.get(0)>=i-k&&temp.get(0)<=i+k)
            {
                temp.remove(0);
                map.put(arr[i],temp);
            }
            else
            return "No";
        }
        return "Yes";
        
    }

}

//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    int n=Integer.parseInt(br.readLine());
		    String line1 = br.readLine();
		    String[] a1 = line1.trim().split("\\s+");
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		    {
		        a[i]=Integer.parseInt(a1[i]);
		    }
		    int k=Integer.parseInt(br.readLine());
		    Solution ob=new Solution();
		    String ans=ob.isKSortedArray(a,n,k);
		    System.out.println(ans);
		    
		}
	}
}
// } Driver Code Ends