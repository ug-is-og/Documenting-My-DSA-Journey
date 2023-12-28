//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            
            //taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            
            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            Solution ob = new Solution();
            
            //calling equilibriumPoint() function
            System.out.println(ob.equilibriumPoint(arr, n));
        }
    }
}
// } Driver Code Ends




// class Solution {

    
//     // a: input array
//     // n: size of array
//     // Function to find equilibrium point in the array.
//     public static int equilibriumPoint(long arr[], int n) {
//         long preSum[]=new long[n];
//         preSum[0]=arr[0];
//         long leftSum=0,rightSum=0;
//         for(int i=1;i<arr.length;i++)
//         {
//             preSum[i]=preSum[i-1]+arr[i];
//         }
//         for(int i=0;i<n;i++)
//         {
//             if(i-1<0)
//             leftSum=0;
//             else
//             leftSum=preSum[i-1];
//             rightSum=preSum[n-1]-preSum[i];
//             if(leftSum==rightSum)
//             return i+1;
//         }
//         return -1;
//     }
// }



// a better code kyunki zabardasti ki conditions nahi peli


// class Solution {
    
//     // a: input array
//     // n: size of array
//     // Function to find equilibrium point in the array.
//     public static int equilibriumPoint(long arr[], int n) {
//         long prefixSum[]=new long[n];
//         prefixSum[0]=arr[0];
//         for(int i=1;i<arr.length;i++)
//         {
//             prefixSum[i]=arr[i]+prefixSum[i-1];
//         }
//         long temp=0;
//         for(int i=0;i<n;i++)
//         {
//             if(prefixSum[n-1]-prefixSum[i]==temp)
//             {
//                 return i+1;
//             }
//             temp=prefixSum[i];
//         }
//         return -1;
//     }
// }



































class Solution {
    
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {
        long prefixSum[]=new long[n];
        long suffixSum[]=new long[n];
        for(int i=0;i<n;i++)
        {
            if(i==0)
            {
                prefixSum[i]=arr[i];
            }
            else
            {
                prefixSum[i]=prefixSum[i-1]+arr[i];
            }
        }
        for(int i=0;i<n;i++)
        {
            if(prefixSum[i]-arr[i]==prefixSum[n-1]-prefixSum[i])
            {
               return i+1;
            }
        }
        return -1;
    }
}

