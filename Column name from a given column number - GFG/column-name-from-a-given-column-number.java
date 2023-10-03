//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
    		System.out.println (new Solution().colName (n));
        }
        
    }
}

// Contributed By: Pranay Bansal 

// } Driver Code Ends


// iss question ke liye explanation iss hisaab se socho ki bhai jab binary , oct yeh sab se deal karte ho tab 0 to 7 lete ho par divide 8 se karte ho
// in case of strings A to Z chal re matlab 1 to 26...0 se start nahi kar re , and divide 26 se kar re toh agar /26 wali cheez use karni hai toh tumhe usse 1 to 26 ki jagah 0 to 25 leke chalna padega
// issi liye -1 karke use kar re 

class Solution
{
    String colName (long n)
    {
        String ans="";
        while(n!=0)
        {
            long m=(n-1)%26;
            ans=(char)(m+65)+ans;
            n=(n-1)/26;
        }
        return ans;
    }
}