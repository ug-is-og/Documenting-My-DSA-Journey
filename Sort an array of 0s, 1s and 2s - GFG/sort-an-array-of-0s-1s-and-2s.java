//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for Java

// Dutch National Flag Algorithm

// class Solution
// {
//     public static void sort012(int a[], int n)
//     {
//         int low=0,mid=0,high=a.length-1;
//         int temp=0;
//         while(mid<=high) // < nahi hoga <= hi hoga
//         {
//             switch(a[mid])
//             {
//                 case 0:
//                     temp=a[low];
//                     a[low]=a[mid];
//                     a[mid]=temp;
//                     low++;
//                     mid++;
//                     break;
//                 case 1:
//                     mid++;
//                     break;
//                 case 2:
//                     temp=a[mid];
//                     a[mid]=a[high];
//                     a[high]=temp;
//                  //   mid++;       // mid++ nahi karna hai yahan pe
//                     high--;
//             }
//         }
//     }
// }






































class Solution
{
    public static void sort012(int a[], int n)
    {
        int l=0,m=0,r=n-1;
        while(m<=r)
        {
            if(a[m]==0)
            {
                int temp=a[l];
                a[l]=a[m];
                a[m]=temp;
                l++;
                m++;

            }
            else if(a[m]==1)
            {
                m++;
            }
            else
            {
                int temp=a[m];
                a[m]=a[r];
                a[r]=temp;
                r--;
            }
        }
    }
}

//{ Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}


// } Driver Code Ends