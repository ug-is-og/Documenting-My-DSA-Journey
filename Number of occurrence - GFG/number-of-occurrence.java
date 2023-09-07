//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        //boolean isFirst=true;
        int firstOccurence=occurence(arr,0,n-1,x,true);
        int lastOccurence=occurence(arr,0,n-1,x,false);
        if(firstOccurence!=-1)
        return lastOccurence-firstOccurence+1;
        return 0;
        // code here
    }
    public int occurence(int arr[],int start,int end,int target,boolean isFirst)
    {
        int mid=0;
        int presence=-1;
        while(start<=end)
        {
            mid=start+(end-start)/2;
            if(arr[mid]==target)
            {
                presence=mid;
                if(isFirst)
                end=mid-1;
                else
                start=mid+1;
            }
            else if(arr[mid]<target)
            start=mid+1;
            else
            end=mid-1;
        }
        return presence;
    }
}