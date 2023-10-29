// logic is incorrect, and it fails for test case : [43,31,14,4]

// class Solution {
//     public long minIncrementOperations(int[] nums, int k) {
//         int temp=-1,max=Integer.MIN_VALUE,maxIndex=-1,i=0,ans=0;
//         while(i<nums.length){
//             if(i==3+temp+1)
//             {
//                 if(max<k)
//                 {
//                     ans=ans+k-max;
//                 }
//                 max=Integer.MIN_VALUE;
//                 temp=maxIndex;
//             }
//             if(max<=nums[i])
//             {
//                 max=nums[i];
//                 maxIndex=i;
//             }
//             i++;
//         }
//         if(i==3+temp+1)
//         {
//             if(max<k)
//             {
//                 ans=ans+k-max;
//             }
//         }
//         return ans;
//     }
// }

// we need to analyzed all possibilities and give minimum an using dp

class Solution {
    public long minIncrementOperations(int[] nums, int k) {
        int diffArray[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            if(k>nums[i])
            diffArray[i]=k-nums[i];
        }
        long dp[]=new long[nums.length];
        Arrays.fill(dp,-1);
        return opsHelper(diffArray,0,nums,dp);
    }
    public long opsHelper(int diffArray[],int index,int nums[],long dp[])
    {
        if(index+3>nums.length)
        {
            return 0;
        }
        if(dp[index]!=-1)
        {
            return dp[index];
        }
        long way1=diffArray[index]+opsHelper(diffArray,index+1,nums,dp);
        long way2=diffArray[index+1]+opsHelper(diffArray,index+2,nums,dp);
        long way3=diffArray[index+2]+opsHelper(diffArray,index+3,nums,dp);
        return dp[index]=Math.min(way1,Math.min(way2,way3));
    }
}