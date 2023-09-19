//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.rotate (n, d);
            System.out.println(res.get(0));
            System.out.println(res.get(1));
            
           
        }
    }
}
// } Driver Code Ends


// https://www.geeksforgeeks.org/java-program-to-rotate-bits-of-a-number/


class Solution
{
    
    ArrayList<Integer> rotate(int N, int D)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        D=D%16;
        int n1=(N<<D|N>>(16-D))&0xFFFF;
        int n2=(N>>D|N<<(16-D))&0xFFFF;
        ans.add(n1);
        ans.add(n2);
        return ans;
    }
}