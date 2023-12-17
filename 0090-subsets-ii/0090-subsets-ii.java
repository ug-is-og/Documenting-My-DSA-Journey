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
// dry run using this example: [1,2,2,3,4,4]
// Striver: https://youtu.be/RIn3gOkbhQE

// class Solution {
//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//         List<List<Integer>> ans=new ArrayList<>();
//         List<Integer> temp=new ArrayList<>();
//         Arrays.sort(nums); 
//         helper(0,ans,temp,nums);
//         return ans;
//     }
//     public void helper(int index,List<List<Integer>> ans,List<Integer> temp,int nums[])
//     {
//         ans.add(new ArrayList<>(temp));
//         for(int i=index;i<nums.length;i++)
//         {
//             if(i!=index&&nums[i]==nums[i-1])
//             continue;
//             temp.add(nums[i]);
//             helper(i+1,ans,temp,nums);
//             temp.remove(temp.size()-1);
//         }
//     }
// }


















// Complete brute approach 
// Additional sorting done + unnecessary checks, equals done

// class Solution {
//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//         List<List<Integer>> ans=new ArrayList<>();
//         helper(ans,nums,0,new ArrayList<>());
//         return ans;
//     }
//     public void helper(List<List<Integer>> ans,int nums[],int index,List<Integer> temp)
//     {
//         if(index==nums.length)
//         {
//             List<Integer> tempAns=new ArrayList<>(temp);
//             List<Integer> temp2=new ArrayList<>(temp);
//             Collections.sort(temp2);
//             for(int i=0;i<ans.size();i++)
//             {
//                 List<Integer> temp1=new ArrayList<>(ans.get(i));
//                 Collections.sort(temp1);
//                 if(temp1.equals(temp2))
//                 return;
//             }
//             ans.add(tempAns);
//             return;
//         }
//         temp.add(nums[index]);
//         helper(ans,nums,index+1,temp);
//         temp.remove(temp.size()-1);
//         helper(ans,nums,index+1,temp);
//     }
// }









// optimized approach
// wrote this completely by myself beats 99.8% , just knew some rough bits and pieces about how to deal with it but great going

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        helper(ans,new ArrayList<>(),0,nums);
        return ans;
    }
    public void helper(List<List<Integer>> ans,List<Integer> temp,int index,int nums[])
    {
        if(index==nums.length)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        int i=0;
        for(i=index+1;i<nums.length;i++)
        {
            if(nums[i]==nums[index])
            continue;
            else
            break;
        }
        helper(ans,temp,i,nums);
        for(int k=index;k<i;k++)
        {
            temp.add(nums[k]);
            helper(ans,temp,i,nums);
        }
        for(int k=index;k<i;k++)
        {
            temp.remove(temp.size()-1);
        }
    }
}