// yeh question pehle hashmap wali approach se try kar re tha par TLE aa ra baar baar
// very imp learning, hashmap bhi TLE de sakta hai toh be very careful

// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         HashMap<String,Integer> map=new HashMap<>();
//         return helper(nums,0,-1,map);
//     }
//     public int helper(int nums[],int index,int prevInd,HashMap<String,Integer> map)
//     {
//         if(index>=nums.length)
//         {
//             return 0;
//         }
//         String key=index+"_"+prevInd;
//         if(map.containsKey(key))
//         {
//             return map.get(key);
//         }
//         int ans1=0,ans2=0,ans=0;
//         ans1=helper(nums,index+1,prevInd,map);
//         if(prevInd==-1||nums[index]>nums[prevInd])
//         {
//             ans2=1+helper(nums,index+1,index,map);
//         }
//         ans=Math.max(ans1,ans2);
//         map.put(key,ans);
//         return ans;
//     }
// }

// hashmap to dp
// coordinate shift method by Striver
// https://youtu.be/ekcwMsSIzVc

// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int dp[][]=new int[nums.length][nums.length+1];
//         for(int temp[]:dp)
//         {
//             Arrays.fill(temp,-1);
//         }
//         return helper(nums,0,-1,dp);
//     }
//     public int helper(int nums[],int index,int prevInd,int dp[][])
//     {
//         if(index>=nums.length)
//         {
//             return 0;
//         }
//         if(dp[index][prevInd+1]!=-1)
//         {
//             return dp[index][prevInd+1];
//         }
//         int ans1=0,ans2=0,ans=0;
//         ans1=helper(nums,index+1,prevInd,dp);
//         if(prevInd==-1||nums[index]>nums[prevInd])
//         {
//             ans2=1+helper(nums,index+1,index,dp);
//         }
//         ans=Math.max(ans1,ans2);
//         return dp[index][prevInd+1]=ans;
//     }
// }


// Tabulation approach
// keep in mind coordinate shift ki method se kya kya chnages aa rahe hai 
// https://youtu.be/IFfYfonAFGc

class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][]=new int[nums.length+1][nums.length+1];
        for(int i=nums.length-1;i>=0;i--)
        {
            for(int j=nums.length-1;j>=-1;j--)
            {
                int ans1=0,ans2=0;
                ans1=dp[i+1][j+1]; // yahan pe j ki jagah j+1
                if(j==-1||nums[i]>nums[j])
                {
                    ans2=1+dp[i+1][i+1]; // yahan i ki jagah i+1
                }
                dp[i][j+1]=Math.max(ans1,ans2); // yahan pe bhi j+1
            }
        }
        return dp[0][0]; // yahan pe bhi -1 ki jagah 0
    }
}