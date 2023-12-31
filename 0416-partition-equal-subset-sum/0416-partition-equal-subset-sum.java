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





// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum=0;
//         for(int i=0;i<nums.length;i++)
//         sum=sum+nums[i];
//         if(sum%2!=0)
//         return false;
//         int target=sum/2;
//         // now it's typical subset sum problem
//         int dp[][]=new int[target+1][nums.length];
//         for(int temp[]:dp)
//         Arrays.fill(temp,-1);
//         return helper(0,target,nums,dp);
//     }
//     public boolean helper(int index,int k,int nums[],int dp[][])
//     {
//         if(k==0)
//         return true;
//         if(index==nums.length)
//         return false;
//         if(dp[k][index]!=-1)
//         {
//             if(dp[k][index]==1)
//             return true;
//             else
//             return false;
//         }
//         boolean way1=false,way2=false,ans=false;
//         if(k>=nums[index])
//         {
//             way1=helper(index+1,k-nums[index],nums,dp);
//             way2=helper(index+1,k,nums,dp);
//             ans=way1||way2;
//         }
//         else
//         {
//             ans=helper(index+1,k,nums,dp);
//         }
//         if(ans==true)
//         dp[k][index]=1;
//         else
//         dp[k][index]=0;
//         return ans;
//     }
// }

// Let's try tabulation for this
// did it by myself, great going

// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum=0;
//         for(int i=0;i<nums.length;i++)
//         sum=sum+nums[i];
//         if(sum%2!=0)
//         return false;
//         int target=sum/2;
//         boolean dp[][]=new boolean[target+1][nums.length+1];
//         //initialisation
//         for(int j=0;j<=nums.length;j++)
//         dp[0][j]=true;
//         boolean ans=false,way1=false,way2=false;
//         // fill up the dp array
//         for(int i=1;i<dp.length;i++)
//         {
//             for(int j=1;j<dp[0].length;j++)
//             {
//                 if(i>=nums[j-1])
//                 {
//                     way1=dp[i-nums[j-1]][j-1];
//                     way2=dp[i][j-1];
//                     ans=way1||way2;
//                 }
//                 else
//                 {
//                     ans=dp[i][j-1];
//                 }
//                 dp[i][j]=ans;
//             }
//         }
//         return dp[target][nums.length];
//     }
// }




















class Solution {
    public boolean canPartition(int[] nums) {
        //summation of all elements
        int sum=0;
        for(int a:nums)
        {
            sum=sum+a;
        }
        if(sum%2!=0)
        {
            return false;
        }
        int dp[][]=new int[nums.length][sum/2+1];
        for(int temp[]:dp)
        {
            Arrays.fill(temp,-1);
        }
        return helper(0,sum/2,dp,nums);
    }
    public boolean helper(int index,int remSum,int dp[][],int nums[])
    {
        if(remSum==0)
        {
            return true;
        }
        if(index==nums.length||remSum<0)
        {
            return false;
        }
        if(dp[index][remSum]!=-1)
        {
            if(dp[index][remSum]==1)
            {
                return true;
            }
            return false;
        }
        boolean ans=helper(index+1,remSum-nums[index],dp,nums)||helper(index+1,remSum,dp,nums);
        if(ans==true)
        {
            dp[index][remSum]=1;
        }
        else
        {
            dp[index][remSum]=0;
        }
        return ans;
    }
}