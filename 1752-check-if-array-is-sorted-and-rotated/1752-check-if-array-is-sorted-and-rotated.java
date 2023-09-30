class Solution {
    public boolean check(int[] nums) {
        int index=-1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<nums[i-1])
            {
                index=i;
                break;
            }
        }
        if(index==-1)
        return true;
        for(int i=index+1;i<nums.length;i++)
        {
            if(nums[i]<nums[i-1])
            return false;
        }
        if(nums[nums.length-1]<=nums[0])
        return true;
        return false;
    }
}