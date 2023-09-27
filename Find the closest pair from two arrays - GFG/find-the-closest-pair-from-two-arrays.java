//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String[] element = br.readLine().split(" ");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [] = new int[N];
		    int brr [] = new int[M];
		    String[] elements = br.readLine().split(" ");
		    for(int i=0; i<N; i++)
		        arr[i] = Integer.parseInt(elements[i]);
		        
		    String[] ele = br.readLine().split(" ");
		    for(int i=0; i<M; i++)
		        brr[i] = Integer.parseInt(ele[i]);
		    
		    int X = Integer.parseInt(br.readLine());
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> ans;
		    ans = obj.printClosest(arr, brr, N, M, X);
		    System.out.println(Math.abs(ans.get(0) + ans.get(1) - X));
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Pair{
    int a,b;
    public Pair(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
    public int getKey()
    {
        return a;
    }
    public int getValue()
    {
        return b;
    }
}
class Solution{
    // Function for finding maximum and value pair
    public static ArrayList<Integer> printClosest (int arr[], int brr[], int n, int m, int x) {
        ArrayList<Integer> ans;
        if(n>m)
        {
            ans=findClosestSum(arr,brr,x);
        }
        else
        {
            ans=findClosestSum(brr,arr,x);
        }
        return ans;
    }
    public static ArrayList<Integer> findClosestSum(int a[],int b[],int target)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        int globalMin=Integer.MAX_VALUE;
        int ans1=0,ans2=0;
        for(int i=0;i<a.length;i++)
        {
            Pair temp=binarySearch(b,target-a[i]);
            int localMin=temp.getKey();
            int elem=temp.getValue();
            if(globalMin>localMin)
            {
                globalMin=Math.min(globalMin,localMin);
                ans1=a[i];
                ans2=elem;
            }
        }
        ans.add(ans1);
        ans.add(ans2);
       // System.out.println(ans);
        return ans;
    }
    public static Pair binarySearch(int a[],int target)
    {
        int l=0,r=a.length-1,ans1=Integer.MAX_VALUE,ans2=0;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(ans1>Math.abs(target-a[mid]))
            {
                ans1=Math.abs(target-a[mid]);
                ans2=a[mid];
            }
            if(target-a[mid]==0)
            {
                break;
            }
            else if(target-a[mid]>0)
            {
                l=mid+1;
            }
            else
            {
                r=mid-1;
            }
        }
        //System.out.println("HEllo"+" "+ans1+" "+ans2);
        return new Pair(ans1,ans2);
    }
}