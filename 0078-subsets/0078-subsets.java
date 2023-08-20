class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp=new ArrayList<>();
        List<List<Integer>> finalList=new ArrayList<>();
        helper(0,nums,temp,finalList);
        return finalList;
    }
    public void helper(int index,int nums[],List<Integer> temp,List<List<Integer>> finalList)
    {
        if(index==nums.length)
        {
            List<Integer> newTemp=new ArrayList<>(temp);
            finalList.add(newTemp);
            return;
        }
        // leave
        helper(index+1,nums,temp,finalList);
        // take
        temp.add(nums[index]);
        helper(index+1,nums,temp,finalList);
        temp.remove(temp.size()-1);
    }
}