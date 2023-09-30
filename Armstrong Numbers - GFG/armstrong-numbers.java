//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String armstrongNumber(int n){
        int temp=n,count=0,sum=0;
        while(temp!=0)
        {
            count++;
            temp=temp/10;
        }
        temp=n;
        while(temp!=0)
        {
            int m=temp%10;
            sum=sum+(int)Math.pow(m,count);
            temp=temp/10;
        }
        if(sum==n)
        return "Yes";
        return "No";
    }
}