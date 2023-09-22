//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        int first=-1,last=-1;
        first=occFinder(arr,x,true); // true denotes first occurence
        last=occFinder(arr,x,false);
        ArrayList<Integer> list=new ArrayList<>();
        list.add(first);
        list.add(last);
        return list;
    }
    public int occFinder(int arr[],int elem,boolean first)
    {
        int mid=0,start=0,end=arr.length-1;
        int ans=-1;
        while(start<=end)
        {
            mid=(start+end)/2;
            if(arr[mid]==elem)
            {
                ans=mid;
                if(first==true)
                end=mid-1;
                else
                start=mid+1;
            }
            else if(arr[mid]<elem)
            {
                start=mid+1;
            }
            else
            {
                end=mid-1;
            }
        }
        return ans;
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Integer> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends