// class Solution {
//     public int longestSubarray(int[] nums) {
//         int max[]=new int[1];
//         helper(0,1,1,0,max,nums);
//         if(max[0]==nums.length)
//         return max[0]-1;
//         return max[0];
//     }
//     public void helper(int index,int prevEle,int zeroBit,int streamOf1,int max[],int nums[])
//     {
//         if(index==nums.length)
//         {
//             return;
//         }
//         if(nums[index]==1)
//         {
//             if(prevEle==1)
//             {
//                 streamOf1++;
//             }
//             else
//             {
//                 streamOf1=1;
//             }
//             max[0]=Math.max(max[0],streamOf1);
//             helper(index+1,1,zeroBit,streamOf1,max,nums);
//         }
//         else
//         {
//             if(zeroBit==1)
//             {
//                 helper(index+1,1,0,streamOf1,max,nums);
//                 helper(index+1,0,1,0,max,nums);
//             }
//             else
//             {
//                 helper(index+1,0,0,0,max,nums);
//             }
//         }
//     }
// }

// Recuraively toh soch liye par 80/81 TC passed and TLE aa ra 
// optimize kaise kare
// Hint : Try using Sliding Window

class Solution {
    public int longestSubarray(int[] nums) {
       int i=0,j=0,max=0;
       List<Integer> list=new ArrayList<>(); // to keep a track of indices with value 0
       while(j<nums.length)
       {
           if(nums[j]==0)
           {
               list.add(j);
               if(list.size()==1)
               {
                   max=Math.max(max,j-i);
               }
               else if(list.size()==2)
               {
                   max=Math.max(max,j-i-1);
                   i=list.get(0)+1;
                   list.remove(0);
               }
           }
           j++;
       }
       if(list.size()<=1) // if all 1's in nums then the list size will be 0 but we definitely have to remove 1 element so j-i-1 works here
       {
           max=Math.max(max,j-i-1);
       }
       return max;
    }
}