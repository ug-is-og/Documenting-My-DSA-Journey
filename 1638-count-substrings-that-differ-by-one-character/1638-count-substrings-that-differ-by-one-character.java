// pehle brute force approach socha ki t ke saare substrings length wise store karlo and s ke length wise substrings build karte jao and cross check with the lengthwise substrings of t ki konse aese hai jisme difference kewal 1 ka aayega 

// par substrings generate karne ki complexity toh n! hai toh TLE aa jayega, fir hamne issi approach ko optimize karne ka socha using Fraz's solution

// https://www.youtube.com/watch?v=EyJUpI0nowY

// This is a slightly better solution, it works but isn't the most optimized, maza nahi aa raha hai bilkul bhi

// Go for the DP approach now

class Solution {
    public int countSubstrings(String s, String t) {
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            for(int j=0;j<t.length();j++)
            {
                char c1=s.charAt(i);
                char c2=t.charAt(j);
                int diff=0,i1=i,j1=j;
                while(diff<=1)
                {
                    if(c1==c2)
                    {
                        if(diff==1)
                        {
                            ans++;
                        }
                    }
                    else 
                    {
                        diff++;
                        if(diff>1)
                        break;
                        ans++;
                    }
                    if(i1<s.length()-1&&j1<t.length()-1)
                    {
                        c1=s.charAt(++i1);
                        c2=t.charAt(++j1);
                    }
                    else
                    break;
                }
            }
        }
        return ans;
    }
}