// TC : O(n^2) but space O(1)

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int a[]=new int[2];
//         for(int i=0;i<nums.length;i++)
//         {
//             for(int j=i+1;j<nums.length;j++)
//             {
//                 if(nums[i]+nums[j]==target)
//                 {
//                     a[0]=i;
//                     a[1]=j;
//                     break;
//                 }
//             }
//         }
//         return a;
//     }
// }

// TC is O(n logn) but soace is also O(N) due to hashmap
// optimize your approach later

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         HashMap<Integer,List<Integer>> map=new HashMap<>();
//         for(int i=0;i<nums.length;i++)
//         {
//             List<Integer> temp=null;
//             if(map.containsKey(nums[i]))
//             {
//                 temp=map.get(nums[i]);
//                 temp.add(i);
//                 map.put(nums[i],temp);
//             }
//             else
//             {
//                 temp=new ArrayList<>();
//                 temp.add(i);
//                 map.put(nums[i],temp);
//             }
//         }
//         int ans[]=new int[2];
//         int lo=0,hi=nums.length-1;
//         Arrays.sort(nums);
//         while(lo<hi)
//         {
//             int sum=nums[lo]+nums[hi];
//             if(sum==target)
//             {
//                 List<Integer> temp1=map.get(nums[lo]);
//                 ans[0]=temp1.get(0);
//                 temp1.remove(0);
//                 map.put(nums[lo],temp1);
//                 List<Integer> temp2=map.get(nums[hi]);
//                 ans[1]=temp2.get(0);
//                 temp2.remove(0);
//                 map.put(nums[hi],temp2);
//                 break;
//             }
//             else if(sum<target)
//             {
//                 lo++;
//             }
//             else
//             {
//                 hi--;
//             }
//         }
//         return ans;
//     }
// }




// In this approach as well, TC is O(nlogn) but the SC is O(n)
// but did this using custom comparator for sorting, above one was hashmap approach

// class numsData{
//     int data;
//     int index;
//     public numsData(int data,int index)
//     {
//         this.data=data;
//         this.index=index;
//     }
// }
// class ordering implements Comparator<numsData>{
//     public int compare(numsData a,numsData b)
//     {
//         return a.data-b.data;
//     }
// }
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         List<numsData> list=new ArrayList<>();
//         for(int i=0;i<nums.length;i++)
//         {
//             list.add(new numsData(nums[i],i));
//         }
//         Collections.sort(list,new ordering());
//         int i=0,j=nums.length-1;
//         int ans[]=new int[2];
//         while(i<j)
//         {
//             int sum=list.get(i).data+list.get(j).data;
//             if(sum==target)
//             {
//                 ans[0]=list.get(i).index;
//                 ans[1]=list.get(j).index;
//                 break;
//             }
//             else if(sum>target)
//             {
//                 j--;
//             }
//             else
//             {
//                 i++;
//             }
//         }
//         return ans;
//     }
// }







// most optimal approach, O(n) TC and O(n) SC

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[]=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(target-nums[i]))
            {
                ans[0]=i;
                ans[1]=map.get(target-nums[i]);
            }
            map.put(nums[i],i);
        }
        return ans;
    }
}