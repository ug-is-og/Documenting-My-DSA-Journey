// bit manipulation ka bhot pyaare tareeke se istemaal kiya gaya hai, hamne kya kiya ki lets say ek no. hai 9, agar usko components mein tode toh 1+0+0+8 hoga and binary representation is 1001 toh aese harr ek no ki jo set bits hai unki frequency store karte ja re alag alag corresponding to the 2^x where x lies from 0 to 31 kyunki summation of Math.pow(2,x)*(1 or 0) generates the number ...

// ab hame bola gaya hai ki saare no 3 baar repeat hore except one, toh end mein jab modulo 3 karoge for each BitFreq (0th,1th till 31th) toh jo 3-3 baar aa re no. unka modulo toh 0 hi ho jayega , bachega woh ek akela no. jo kewal ek baar aaya tha ...uss akele no. ke componenets bachenge in our bitFreq array and ham usse fir apna no. generate kar lenge


class Solution {
    public int singleNumber(int[] nums) {
        int bitFreq[]=new int[33];
        double ans=0.0;
        for(int i=0;i<nums.length;i++)
        {
            long num=nums[i]; // long lena zaruri hai kyunki agar -2^31 hua no. toh ham neeche jaake *-1 kar re that is 2^31 jo store hi nahi kar paoge in int 
            int counter=32; // 32 se 1 tak counter jayega , ab tum sochoge ki yaar positive number toh kewal 31 bits use karke denote kar sakte toh ek extra bit ka kya karna, par bhaii tumne toh yeh bola hai na ki mein negative no ko bhi as a positive no deal karunga and end mein sign ka matter sort kar lunga, toh lets say negative no. is -2^31 ab iska magnitude hua 2^31 jisko bina 32 bits ke represent kar hi nahi sakte 2^0, 2^1 karte karte...2^31 tak tab pahuchoge jab tum 32 bits leke chalo, iss liye hamne counter ko 32 pe rakha. 
            if(num<0)
            {
                bitFreq[0]+=1; // to find kitne aese hai jo negative the
                num=num*-1; // isse hame kewal negative no. ke magnitude se deal karna padega
            }
            while(num!=0)
            {
                long temp=num&1;
                num=num>>1; // basically dividing by 2
                if(temp==1)
                bitFreq[counter]+=1;
                counter--;
            }
        }
        for(int i=32;i>=1;i--)
        {
            ans=ans+Math.pow(2,(32-i))*(bitFreq[i]%3); // handling the magnitude part of missing number
        }
        if(bitFreq[0]%3!=0) // handling the sign part of missing number
            ans=ans*-1;
        return (int)ans;
    }
}