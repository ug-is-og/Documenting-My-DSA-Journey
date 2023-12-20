// multiple paths se pahuch sakte destination tak, par hame multiple paths pe focus nahi karna,
// ek saaf suthra path nikalna hai
// also dhyan rakho, at times, instead of focussing on forward engineering, focus on backward engineering, jaise iss question mein kiya
// best explanation : https://www.youtube.com/watch?v=EgMPjWliYGY
// [3,1,0,2,0,5]

class Solution {
    public boolean canJump(int[] nums) {
        int dest=nums.length-1;
        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]+i>=dest)
            {
                dest=i;
            }
        }
        if(dest==0)
        return true;
        return false;
    }
}