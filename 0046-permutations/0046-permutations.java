// Method 1


// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> list=new ArrayList<>();
//         helper(0,nums,list,new ArrayList<>());
//         return list;
//     }
//     public void helper(int elementsCovered,int nums[],List<List<Integer>> list,List<Integer> temp)
//     {
//         if(elementsCovered==nums.length)
//         {
//             List<Integer> tempList=new ArrayList<>(temp);
//             list.add(tempList);
//             return;
//         }
//         for(int i=0;i<nums.length;i++)
//         {
//             if(nums[i]!=Integer.MAX_VALUE)
//             {
//                 int data=nums[i];
//                 nums[i]=Integer.MAX_VALUE;
//                 temp.add(data);
//                 helper(elementsCovered+1,nums,list,temp);
//                 temp.remove(temp.size()-1);
//                 nums[i]=data;
//             }
//         }
//     }
// }


// Method 2 (Swapping)

// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> list=new ArrayList<>();
//         helper(0,nums,list);
//         return list;
//     }
//     public void helper(int index,int nums[],List<List<Integer>> list)
//     {
//         if(index==nums.length)
//         {
//             List<Integer> tempList=new ArrayList<>();
//             for(int i=0;i<nums.length;i++)
//             tempList.add(nums[i]);
//             list.add(tempList);
//             return;
//         }
//         for(int i=index;i<nums.length;i++)
//         {
//             // swap index element with ith index
//             int data=nums[index];
//             nums[index]=nums[i];
//             nums[i]=data;
//             helper(index+1,nums,list);
//             // swap back
//             data=nums[i];
//             nums[i]=nums[index];
//             nums[index]=data;
//         }
//     }
// }
















// swapping method

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        backTrack(ans,0,nums);
        return ans;
    }
    public void backTrack(List<List<Integer>> ans,int index,int nums[])
    {
        if(index==nums.length)
        {
            List<Integer> temp=new ArrayList<>();
            for(int a:nums)
            temp.add(a);
            ans.add(temp);
        }
        for(int i=index;i<nums.length;i++)
        {
            // swap elements;
            int temp=nums[i];
            nums[i]=nums[index];
            nums[index]=temp;
            backTrack(ans,index+1,nums);
            //swap back
            temp=nums[i];
            nums[i]=nums[index];
            nums[index]=temp;
        }
    }
}