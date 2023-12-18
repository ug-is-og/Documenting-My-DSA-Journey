// Approach written by me

// class Solution {
//     public List<Integer> largestDivisibleSubset(int[] nums) {
//         int dp[]=new int[nums.length];
//         int hash[]=new int[nums.length];
//         int globalMax=Integer.MIN_VALUE;
//         int maxSubsetIndex=0,index=0;
//         List<Integer> ans=new ArrayList<>();
//         Arrays.sort(nums);
//         Arrays.fill(dp,1);
//         hash[0]=0;
//         for(int i=1;i<nums.length;i++)
//         {
//             int max=Integer.MIN_VALUE;
//             for(int j=0;j<i;j++)
//             {
//                 if(nums[i]%nums[j]==0&&dp[j]>max)
//                 {
//                     max=dp[j];
//                     index=j;
//                 }
//             }
//             if(max!=Integer.MIN_VALUE)
//             {
//                 dp[i]=max+1;
//                 hash[i]=index;
//             }
//             else
//             {
//                 dp[i]=1;
//                 hash[i]=i;
//             }
//             if(globalMax<dp[i])
//             {
//                 globalMax=dp[i];
//                 maxSubsetIndex=i;
//             }
//         }
//         while(hash[maxSubsetIndex]!=maxSubsetIndex)
//         {
//             ans.add(nums[maxSubsetIndex]);
//             maxSubsetIndex=hash[maxSubsetIndex];
//         }
//         ans.add(nums[maxSubsetIndex]);
//         return ans;
//     }
// }


// a bit more optimized approach given by striver
// https://takeuforward.org/data-structure/longest-divisible-subset-dp-44/

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int dp[]=new int[nums.length];
        int hash[]=new int[nums.length];
        int globalMax=Integer.MIN_VALUE;
        int globalIndex=-1;
        Arrays.fill(dp,1);
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            hash[i]=i;
            for(int j=0;j<i;j++)
            {
                if(nums[i]%nums[j]==0&&dp[j]+1>dp[i])
                {
                    dp[i]=dp[j]+1;
                    hash[i]=j;
                }
            }
            if(globalMax<dp[i])
            {
                globalMax=dp[i];
                globalIndex=i;
            }
        }
        while(globalIndex!=hash[globalIndex])
        {
            ans.add(nums[globalIndex]);
            globalIndex=hash[globalIndex];
        }
        ans.add(nums[globalIndex]);
        return ans;
    }
}