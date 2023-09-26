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

            boolean ans = new Solution().hasArrayTwoCandidates(arr, n, x);
            System.out.println(ans ? "Yes" : "No");
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        // using 2 sum approach
        // Arrays.sort(arr);
        // int l=0,r=n-1;
        // while(l<r)
        // {
        //     int tempSum=arr[l]+arr[r];
        //     if(tempSum==x)
        //     return true;
        //     else if(tempSum>x)
        //     {
        //         r--;
        //     }
        //     else
        //     {
        //         l++;
        //     }
        // }
        // return false;
        
        // using hashMap approach
        
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int a:arr)
        {
            if(map.containsKey(x-a))
            return true;
            map.put(a,1);
        }
        return false;
    }
}