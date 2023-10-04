//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// After carefully analyzing several test cases, I made one observation
// we need to check these pairs (I,V) , (I,X), (X,L), (C,D) ,

class Solution {
    public int romanToDecimal(String str) {
        int ans=0;
        for(int i=str.length()-1;i>=0;i--)
        {
            char c2=str.charAt(i);
            char c1='\u0000';
            if(i-1>=0)
            {
                c1=str.charAt(i-1);
                if((c1=='I'&&c2=='V')||(c1=='I'&&c2=='X')||(c1=='X'&&c2=='L')||(c1=='X'&&c2=='C')||(c1=='C'&&c2=='D')||(c1=='C'&&c2=='M'))
                {
                    ans=ans+getValue(c2)-getValue(c1);
                    i--;
                }
                else
                {
                    ans=ans+getValue(c2);
                }
            }
            else
            {
                ans=ans+getValue(c2);
            }
            //System.out.println(ans+" "+i);
        }
        return ans;
    }
    public int getValue(char roman)
    {
        int ans=0;
        switch(roman)
        {
            case 'I': // bhai yeh semicolon mat bhul jaya karo
            ans=1;
            break;
            case 'V':
            ans= 5;
            break;
            case 'X':
            ans=10;
            // return 10; // yahan tum return kyun karoge bhaii, thoda socha toh karo
            break;
            case 'L':
            ans=50;
            break;
            case 'C':
            ans=100;
            break;
            case 'D':
            ans=500;
            break;
            case 'M':
            ans=1000;
            break;
        }
        return ans;
    }
}