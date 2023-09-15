// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         int sum=0,range=0;
//         int n=nums.length;
// 		for(int i=0;i<nums.length;i++)
// 		range=range+nums[i];
// 		sum=(range-target)/2;
// 		if(range-target<0) // edge case 1
// 		return 0;
// 		if((range-target)%2!=0)// edge case 2
// 		return 0;
// 		int dp[][]=new int[n+1][sum+1];
// 		int k=1;
// 		for(int i=0;i<n+1;i++)
// 		{
// 			for(int j=0;j<sum+1;j++)
// 			{
// 				if(i==0)
// 				dp[i][j]=0;
// 				if(j==0)
// 				{
// 					if(i-1>=0&&nums[i-1]==0)
// 					{
// 						dp[i][j]=k*2;
// 						k=k*2;
// 					}
// 					else
// 					dp[i][j]=k;
// 				}
// 			}
// 		}
// 		for(int i=1;i<n+1;i++)
// 		{
// 			for(int j=1;j<sum+1;j++)
// 			{
// 				if(j>=nums[i-1])
// 				dp[i][j]=(dp[i-1][j]+dp[i-1][j-nums[i-1]])%1000000007;
// 				else
// 				dp[i][j]=dp[i-1][j]%1000000007;
// 			}
// 		}
// 		return dp[n][sum];
// 		// Write your code here.
//     }
// }



















class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int a:nums)
        sum+=a;
        if(sum+target<0) // bhot badi galti, yeh wali condition bhul gaya tha, dhyann rakhna
            return 0;
        if((sum+target)%2!=0)
        return 0;
        int check=(sum+target)/2;
        int dp[][]=new int[nums.length+1][check+1];
        for(int temp[]:dp)
        Arrays.fill(temp,-1);
        return helper(nums,nums.length,check,dp);
    }
    public int helper(int nums[],int index,int check,int dp[][])
    {
        if(index==0)
        {
            if(check==0)
            return 1;
            else
            return 0;
        }
        if(dp[index][check]!=-1)
        return dp[index][check];
        int count=0;
        if(check>=nums[index-1])
            count=helper(nums,index-1,check-nums[index-1],dp)+helper(nums,index-1,check,dp);
        else
            count=helper(nums,index-1,check,dp);
        return dp[index][check]=count;
    }
}