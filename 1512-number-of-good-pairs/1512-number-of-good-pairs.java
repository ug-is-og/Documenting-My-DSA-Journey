class Solution {
    public int numIdenticalPairs(int[] nums) {
        Arrays.sort(nums);
        int num=nums[0],temp=0,k=1,count=0;
        for(int i=1;i<nums.length;i++)
        {
            temp=num^nums[i];
            if(temp==0)
            count=count+(k++);
            else
            {
                k=1;
                num=nums[i];
            }
        }
        return count;
    }
}