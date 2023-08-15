// class Solution {
//     public boolean canPartition(int[] nums) {
//         //find the sum
//         int sum=0;
//         for(int i=0;i<nums.length;i++)
//         sum=sum+nums[i];
//         if(sum%2!=0)
//         return false;
//         return subsetSum(nums,sum/2,nums.length);
//     }
//     public boolean subsetSum(int nums[],int sum,int n)
//     {
//         boolean dp[][]=new boolean[n+1][sum+1];
//         for(int i=0;i<n+1;i++)
//         {
//             for(int j=0;j<sum+1;j++)
//             {
//                 if(i==0)
//                 dp[i][j]=false;
//                 if(j==0)
//                 dp[i][j]=true;
//             }
//         }
//         for(int i=1;i<n+1;i++)
//         {
//             for(int j=1;j<sum+1;j++)
//             {
//                 if(j>=nums[i-1])
//                 dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
//                 else
//                 dp[i][j]=dp[i-1][j];
//             }
//         }
//         return dp[n][sum];
//     }
// }





class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++)
        sum=sum+nums[i];
        if(sum%2!=0)
        return false;
        int target=sum/2;
        // now it's typical subset sum problem
        int dp[][]=new int[target+1][nums.length];
        for(int temp[]:dp)
        Arrays.fill(temp,-1);
        return helper(0,target,nums,dp);
    }
    public boolean helper(int index,int k,int nums[],int dp[][])
    {
        if(k==0)
        return true;
        if(index==nums.length)
        return false;
        if(dp[k][index]!=-1)
        {
            if(dp[k][index]==1)
            return true;
            else
            return false;
        }
        boolean way1=false,way2=false,ans=false;
        if(k>=nums[index])
        {
            way1=helper(index+1,k-nums[index],nums,dp);
            way2=helper(index+1,k,nums,dp);
            ans=way1||way2;
        }
        else
        {
            ans=helper(index+1,k,nums,dp);
        }
        if(ans==true)
        dp[k][index]=1;
        else
        dp[k][index]=0;
        return ans;
    }
}