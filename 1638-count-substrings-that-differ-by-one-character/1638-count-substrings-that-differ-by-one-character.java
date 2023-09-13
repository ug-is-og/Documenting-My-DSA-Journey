// pehle brute force approach socha ki t ke saare substrings length wise store karlo and s ke length wise substrings build karte jao and cross check with the lengthwise substrings of t ki konse aese hai jisme difference kewal 1 ka aayega 

// par substrings generate karne ki complexity toh n^2 hai toh brute force sa lag jayega, ....eventually brute approach ki complexity aayegi O(N^2)*O(m^2)*O(N) fir hamne issi approach ko optimize karne ka socha using Fraz's solution

// n! is the no of substrings, it isn't the complexity

// https://www.youtube.com/watch?v=EyJUpI0nowY

// This is a slightly better solution, it works but isn't the most optimized, maza nahi aa raha hai bilkul bhi

// Go for the DP approach now

// class Solution {
//     public int countSubstrings(String s, String t) {
//         int ans=0;
//         for(int i=0;i<s.length();i++)
//         {
//             for(int j=0;j<t.length();j++)
//             {
//                 char c1=s.charAt(i);
//                 char c2=t.charAt(j);
//                 int diff=0,i1=i,j1=j;
//                 while(diff<=1)
//                 {
//                     if(c1==c2)
//                     {
//                         if(diff==1)
//                         {
//                             ans++;
//                         }
//                     }
//                     else 
//                     {
//                         diff++;
//                         if(diff>1)
//                         break;
//                         ans++;
//                     }
//                     if(i1<s.length()-1&&j1<t.length()-1)
//                     {
//                         c1=s.charAt(++i1);
//                         c2=t.charAt(++j1);
//                     }
//                     else
//                     break;
//                 }
//             }
//         }
//         return ans;
//     }
// }

// DP approach

// refer version 2 of xieuyan 95 solution
// refer this video as well youtube.com/watch?v=CGokZpAxzLY

class Solution {
    public int countSubstrings(String s, String t) {
        int dp[][][]=new int[s.length()+1][t.length()+1][2];
        int sum=0;
        // first fill the diff=0 part
        for(int i=1;i<s.length()+1;i++)
        {
            for(int j=1;j<t.length()+1;j++)
            {
                if(s.charAt(i-1)==t.charAt(j-1))
                {
                    dp[i][j][0]=1+dp[i-1][j-1][0];
                }
            }
        }
        // now we will use diff=0 part while filling diff=1 part
        for(int i=1;i<s.length()+1;i++)
        {
            for(int j=1;j<t.length()+1;j++)
            {
                if(s.charAt(i-1)!=t.charAt(j-1))
                dp[i][j][1]=1+dp[i-1][j-1][0];
                else
                dp[i][j][1]=dp[i-1][j-1][1];
                sum=sum+dp[i][j][1];
            }
        }
        return sum;
    }
}