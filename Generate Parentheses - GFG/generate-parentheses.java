//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        List<String> list=new ArrayList<>();
        helper(n,n,list,"");
        return list;
    }
    public void helper(int open,int close,List<String> list,String s)
    {
        if(open==0&&close==0)
        {
            list.add(s);
            return;
        }
        if(open>0)
        {
            helper(open-1,close,list,s+"(");
        }
        if(close>0&&open<close)
        {
            helper(open,close-1,list,s+")");
        }
    }
}