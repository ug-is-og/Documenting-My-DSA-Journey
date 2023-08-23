class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        helper(0,ans,temp,nums);
        return ans;
    }
    public void helper(int index,List<List<Integer>> ans,List<Integer> temp,int nums[])
    {
        if(index==nums.length)
        {
            List<Integer> newTemp=new ArrayList<>(temp);
            Collections.sort(newTemp);
            if(!ans.contains(newTemp))
            ans.add(newTemp);
            return;
        }
        // leave it
        helper(index+1,ans,temp,nums);
        // take it
        temp.add(nums[index]);
        helper(index+1,ans,temp,nums);
        temp.remove(temp.size()-1);
    }
}