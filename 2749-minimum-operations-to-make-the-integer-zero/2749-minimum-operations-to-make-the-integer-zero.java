
// the only correct snippet of code

// class Solution {
//     public int makeTheIntegerZero(int num1, int num2) {
//         if (num1 < num2) {
//             return -1;
//         }
//         for (int k = 0; k <= 32; k++) {
//             long diff = num1 - 1L*(num2) * k;
//             int bits = Long.bitCount(diff);
//             if (bits <= k && k <= diff)
//                 return k;
//         }
//         return -1;
//     }
// }























class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        int count=1;
        while(num1-1L*count*num2>0)
        {
            long temp=num1-(1L*count*num2);
            // to find setBits in binary representation
            int setBits=countSetBits(temp);
            if(temp>=count&&count>=setBits)
            {
                return count;
            }
            count++;
        }
        return -1;
    }
    public int countSetBits(long temp)
    {
        int count=0;
        while(temp>0)
        {
            count=count+(int)(temp&1);
            temp=temp>>1;
        }
        return count;
    }
}