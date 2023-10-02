//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.distinctSubsequences(s));
        }
    }
}
// } Driver Code Ends


// Brute approach

// class Solution {
//     int distinctSubsequences(String S) {
//         Set<String> set=new HashSet<>();
//         helper(S,set,0,"");
//         return set.size();
//     }
//     public void helper(String S,Set<String> set,int index,String temp)
//     {
//         if(index==S.length())
//         {
//             set.add(temp);
//             return;
//         }
//         helper(S,set,index+1,temp);
//         helper(S,set,index+1,temp+S.charAt(index));
//     }
// }



// https://www.youtube.com/watch?v=9UEHPiK53BA
// yeh video dekhlo crystal clear samajh aa jayega
// bhai mere mod bhot important cheez hai, please bhot carefulyy deal kiya karo jahan pe bhi 10^9+7 ya long jaisi cheezein involve ho jaaye

class Solution {
    int distinctSubsequences(String S) {
        long dp[]=new long[S.length()+1];
        dp[0]=1; // denoting empty subsequence
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=1;i<dp.length;i++)
        {
            long temp=(dp[i-1]*2)%1000000007;
            char c=S.charAt(i-1);
            if(map.containsKey(c))
            {
                temp=(temp-dp[map.get(c)-1]+1000000007)%1000000007; // yahan pe +mod karna inside brackets was very very important, issi ki wajah se code nahi chal ra tha for bigger inputs, +mod karne se you ensure ki value negative na chali jaaye after subtraction
            }
            dp[i]=temp;
            map.put(c,i);
        }
        return (int)dp[dp.length-1];
    }
}




