// class Solution {
//     public boolean repeatedSubstringPattern(String s) {
//         for(int i=0;i<s.length()-1;i++) // yeh kewal s.length()-2 tak chalayenge loop kyunki str="aba" ke case mein for i=s.length()-1 tumhara pattern "aba" aa ja ra iss wajah se ans true ho ra, joki nahi hona chahiye
//         {
//             String pattern="";
//             for(int j=0;j<s.length()/(i+1);j++)
//             {
//                 pattern=pattern+s.substring(0,i+1);
//             }
//             if(s.equals(pattern))
//             return true;
//         }
//         return false;
//     }
// }

// Optimized solution after watching video
// https://www.youtube.com/watch?v=bClIZj66dVE
// also read first comment of this video ...very insightful

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len=s.length();
        for(int i=len/2;i>=1;i--)
        {
            if(len%i==0)
            {
                int numRepeats=len/i;
                String subString=s.substring(0,i);
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<numRepeats;j++)
                {
                    sb.append(subString);
                }
                if(sb.toString().equals(s))
                return true;
            }
        }
        return false;
    }
}