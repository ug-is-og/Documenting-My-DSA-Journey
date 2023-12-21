// https://www.youtube.com/watch?v=oO5uLE7EUlM 
//Striver's brute,better, optimal solution

// Hashset contains method ki TC O(1) hai uski advantage le re

// class Solution {
//     public int longestConsecutive(int[] nums) {
//         HashSet<Integer> set=new HashSet<>();
//         for(int i=0;i<nums.length;i++)
//         set.add(nums[i]);
//         int maxCount=1;
//         int count=1;
//         for(int i:set)
//         {
//             int temp=i;
//             if(set.contains(temp-1))
//             {
//                 count=1;
//                 continue;
//             }
//             else
//             {
//                 count=1;
//                 while(set.contains(temp+1))
//                 {
//                     count++;
//                     temp=temp+1;
//                 }
//                 maxCount=Math.max(maxCount,count);
//             }
//         }
//         if(nums.length==0)
//         return 0;
//         return maxCount;
//     }
// }



















// approach 1 was using sorting O(nlogn) TC
// mere dhyan se ek fact nikal gaya ki yaar Hashset mein contains ki TC O(1) hoti hai
// jo ham use kar sakte
// https://www.youtube.com/watch?v=oO5uLE7EUlM 
//Striver's brute,better, optimal solution

class Solution {
    public int longestConsecutive(int[] nums) {
       HashSet<Integer> set=new HashSet<>();
       for(int a:nums)
       {
           set.add(a);
       }
       int count=0,maxCount=0;
       for(int i:set)
       {
           int temp=i;
           count=1; // ek element toh mil hi gaya
           if(set.contains(i-1)) // baap se baat karunga tujhse nahi
           {
               continue;
           }
           else //ab baap aa gaya hai
           {
               while(set.contains(temp+1))
               {
                   count++;
                   temp++;
               }
               maxCount=Math.max(maxCount,count);
           }
       }
       return maxCount;
    }
}