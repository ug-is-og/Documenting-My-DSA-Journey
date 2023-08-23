// Brute + Better Approach (arrays.sort() optimization)

// class Solution {
//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//         List<List<Integer>> ans=new ArrayList<>();
//         List<Integer> temp=new ArrayList<>();
//         Arrays.sort(nums); // this is an optimization , ab hame baar baar collections.sort() nahi karna padega toh chill scene hai
//         helper(0,ans,temp,nums);
//         return ans;
//     }
//     public void helper(int index,List<List<Integer>> ans,List<Integer> temp,int nums[])
//     {
//         if(index==nums.length)
//         {
//             List<Integer> newTemp=new ArrayList<>(temp);
//             //Collections.sort(newTemp);
//             if(!ans.contains(newTemp)) // checks elements and not references
//             ans.add(newTemp);
//             return;
//         }
//         // leave it
//         helper(index+1,ans,temp,nums);
//         // take it
//         temp.add(nums[index]);
//         helper(index+1,ans,temp,nums);
//         temp.remove(temp.size()-1);
//     }
// }

// optimal approach

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        Arrays.sort(nums); 
        helper(0,ans,temp,nums);
        return ans;
    }
    public void helper(int index,List<List<Integer>> ans,List<Integer> temp,int nums[])
    {
        ans.add(new ArrayList<>(temp));
        for(int i=index;i<nums.length;i++)
        {
            if(i!=index&&nums[i]==nums[i-1])
            continue;
            temp.add(nums[i]);
            helper(i+1,ans,temp,nums);
            temp.remove(temp.size()-1);
        }
    }
}