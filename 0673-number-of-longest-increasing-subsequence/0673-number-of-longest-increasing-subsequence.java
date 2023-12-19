class Solution {
    public int findNumberOfLIS(int[] nums) {
        int dp[]=new int[nums.length];
        int cnt[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            dp[i]=1;
            cnt[i]=1;
        }
        int max=Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j]&&dp[j]+1>dp[i])
                {
                    dp[i]=dp[j]+1;
                    cnt[i]=cnt[j];
                }
                else if(dp[j]+1==dp[i])
                {
                    cnt[i]+=cnt[j];
                }
            }
            max=Math.max(max,dp[i]);
        }
        for(int i=0;i<nums.length;i++)
        {
            if(dp[i]==max)
            count=count+cnt[i];
        }
        return count;
    }
}