//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends



class Solution
{
    public ArrayList<String> permutation(String S)
    {
        ArrayList<String> ans=new ArrayList<>();
        helper(ans,S,"");
        Collections.sort(ans); // lexicographically increasing order likha hai, dhyan se padhar kar tu bhul gaya tha
        return ans;
    }
    public void helper(ArrayList<String> ans,String s,String temp)
    {
        if(s.length()==0) // repetition is allowed iss liye condition nahi lagayi laga se contains() wali
        ans.add(temp);
        for(int i=0;i<s.length();i++)
        {
            helper(ans,s.substring(0,i)+s.substring(i+1),temp+s.charAt(i));
        }
    }
	   
}
