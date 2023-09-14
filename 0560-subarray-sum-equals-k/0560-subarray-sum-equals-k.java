// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         // build the prefix array
//         int prefix[]=new int[nums.length];
//         prefix[0]=nums[0];
//         for(int i=1;i<nums.length;i++)
//         {
//             prefix[i]=prefix[i-1]+nums[i];
//         }
//         int count=0;
//         for(int i=0;i<nums.length;i++)
//         {
//             if(prefix[i]==k) // keep in mind
//             count++; 
//             for(int j=0;j<i;j++)
//             {
//                 if(prefix[i]-prefix[j]==k)
//                 count++;
//             }
//         }
//         return count;
//     }
// }

// optimized solution

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        int prefix[]=new int[nums.length];
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            if(i==0)
            {
                prefix[0]=nums[0];
            }
            else
            {
                prefix[i]=prefix[i-1]+nums[i];
            }
            if(map.containsKey(prefix[i]-k))
            count=count+map.get(prefix[i]-k);
            map.put(prefix[i],map.getOrDefault(prefix[i],0)+1);
            // if(map.containsKey(prefix[i]-k)) // khaas dhyan rakhna iss cheez ka considering TC : [1], 0 
            // count++;
        }
        return count;
    }
}