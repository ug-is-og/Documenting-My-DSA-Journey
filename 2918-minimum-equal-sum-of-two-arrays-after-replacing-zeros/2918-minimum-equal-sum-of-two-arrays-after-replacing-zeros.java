class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1=0,sum2=0; // yeh long wali cheez bhul gaye the issi liye hidden test case ke liye nah chal ra tha
        int count1=0,count2=0;
        // consider 0's as 1's and find the sum of elements of both arrays initially
        for(int a:nums1)
        {
            if(a==0)
            {
                sum1++;
                count1++;
            }
            else
                sum1=sum1+a;
        }
        for(int a:nums2){
            if(a==0)
            {
                sum2++;
                count2++;
            }
            else
                sum2=sum2+a;
        }
        if(sum1>sum2)
        {
            if(count2>0)
            {
                return sum1;
            }
        }
        else if(sum2>sum1){
            if(count1>0)
            {
                return sum2;
            }
        }
        else
        {
            return sum1;
        }
        return -1;
    }
}