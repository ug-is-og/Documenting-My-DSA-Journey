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





// Dp approach

// import java.util.*;
// class Solution {
//     public int jump(int nums[]) {
//         int dp[]=new int[nums.length];
//         Arrays.fill(dp,-1);
//         return helper(nums,dp,0);
//     }
//     public int helper(int nums[],int dp[],int index)
//     {
//         if(index==nums.length-1)
//         {
//             return 0;
//         }
//         if(nums[index]==0)
//         {
//             return 1000000;
//         }
//         if(dp[index]!=-1)
//         {
//             return dp[index];
//         }
//         int minCount=Integer.MAX_VALUE;
//         for(int i=index+1;i<=Math.min(index+nums[index],nums.length-1);i++)
//         {
//             minCount=Math.min(minCount,1+helper(nums,dp,i));
//         }
//         return dp[index]=minCount;
//     }
// }









// Greedy Approach
// not the best approach
// TC : O(n^2) worst case

// import java.util.*;
// class Solution {
//     public int jump(int nums[]) {
//         int dest=nums.length-1;
//         int minDest=Integer.MIN_VALUE;
//         int count=0;
//         while(dest!=0)
//         {
//             for(int i=dest-1;i>=0;i--)
//             {
//                 if(i+nums[i]>=dest)
//                 {
//                     minDest=i;
//                 }
//             }
//             dest=minDest;
//             count++;
//         }
//         return count;
//     }
// }






// Best Greedy Approach
// https://www.youtube.com/watch?v=wLPdkLM_BWo&t=584s

import java.util.*;
class Solution {
    public int jump(int nums[]) {
        int curr=0,farthest=0,jumps=0;
        for(int i=0;i<nums.length-1;i++)
        {
            farthest=Math.max(farthest,nums[i]+i);
            if(i==curr)
            {
                curr=farthest;
                jumps++;
            }
        }
        return jumps;
    }
}



// O(N) approach
// yeh apne aap se kiya tha

// import java.util.*;

// class Solution {
//     public int jump(int nums[]) {
//         int ans=0,jmp=0;
//         if(nums.length==1)
//             return 0;
//         for(int i=0;i<nums.length;i++)
//         {
//             int max=Integer.MIN_VALUE;
//             int newPos=Integer.MIN_VALUE;
//             jmp++;
//             int pos=i;
//             int jmpValue=nums[i];
//             if(jmpValue+pos>=nums.length-1)
//             {
//                 ans=jmp;
//                 break;
//             }
//             for(int j=pos+1;j<=pos+jmpValue;j++)
//             {
//                 if(max<nums[j]+j) // yeh statement bhot crucial hai dhyan se samajhna 
//                 // pehle main max< nums[j] karke check kar ra tha and woh work nahi karega , chahe toh karke dekhlo
//                 {
//                     max=nums[j]+j;
//                     newPos=j;
//                 }
//             }
//             i=newPos-1;
//         }
//         return ans;
//     }
// }