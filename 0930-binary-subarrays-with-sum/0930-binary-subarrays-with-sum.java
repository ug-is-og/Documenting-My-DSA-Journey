// had to specially handle the case where the goal==0 but you wrote like the most optimized code so its worth it

// Solution with O(1) Space and O(N) TC

// class Solution {
//     public int numSubarraysWithSum(int[] nums, int goal) {
//         List<Integer> occ1=new ArrayList<>();
//         int i=0,j=0,count=0,ans=0,preceedingZeroes=0,succeedingZeroes=0;
//         while(j<nums.length)
//         {
//             if(nums[j]==1)
//             {
//                 occ1.add(j);
//                 count++;
//             }
//             if(count>goal)
//             {
//                 preceedingZeroes=occ1.get(0)-i;
//                 if(goal==0)
//                 {
//                     ans=ans+((preceedingZeroes)*(preceedingZeroes+1))/2;
//                 }
//                 else
//                 {
//                     succeedingZeroes=j-occ1.get(occ1.size()-2)-1;
//                     ans=ans+(preceedingZeroes+1)*(succeedingZeroes+1);
//                 }
//                 i=occ1.get(0)+1;
//                 occ1.remove(0);
//                 count--;
//             }
//             j++;
//         }
//         if(count==goal)
//         {
//             if(goal==0)
//             {
//                 ans=ans+((j-i)*(j-i+1))/2;
//             }
//             else
//             {
//                 preceedingZeroes=occ1.get(0)-i;
//                 succeedingZeroes=j-occ1.get(occ1.size()-1)-1;
//                 ans=ans+(preceedingZeroes+1)*(succeedingZeroes+1);
//             }
//         }
//         return ans;
//     }
// }

























// A more standard approach with O(N) SC and O(N) TC

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int prefixSum[]=new int[nums.length];
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i==0)
            {
                prefixSum[i]=nums[0];
            }
            else
            {
                prefixSum[i]=prefixSum[i-1]+nums[i];
            }
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<prefixSum.length;i++)
        {
            if(map.containsKey(prefixSum[i]-goal))
            {
                count+=map.get(prefixSum[i]-goal);
            }
            map.put(prefixSum[i],map.getOrDefault(prefixSum[i],0)+1);
        }
        return count;
    }
}