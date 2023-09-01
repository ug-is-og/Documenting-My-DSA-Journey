// class Solution {
//     public int jump(int[] nums) {
//         int dp[]=new int[nums.length];
//         Arrays.fill(dp,-1);
//         return helper(nums,0,dp);
//     }
//     public int helper(int nums[],int index,int dp[])
//     {
//         if(index==nums.length-1)
//         return 0;
//         if(dp[index]!=-1)
//         return dp[index];
//         int min=100000000; // tareeka yahi kar re log, matlab koi bada sa no daaldo , index>=nums.length-1 wali condition laga sakte the koi dikkat na aati
//         int ans=0;
//         for(int i=1;i<=nums[index];i++)
//         {
//             if(index+i<=nums.length-1)
//             {
//                 ans=1+helper(nums,index+i,dp);
//                 min=Math.min(min,ans);
//             }
//         }
//         return dp[index]=min;
//     }
// }


import java.util.*;

class Solution {
    public int jump(int nums[]) {
        for (int i = 1; i < nums.length; i++) {
            nums[i]=Math.max(nums[i] + i, nums[i-1]);
        }
        int idx = 0, c = 0;
        while (idx < nums.length - 1) {
            c++;
            idx = nums[idx];
        }
        return c;
    }
}