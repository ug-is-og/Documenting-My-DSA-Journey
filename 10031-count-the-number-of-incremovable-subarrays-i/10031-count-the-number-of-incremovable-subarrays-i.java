class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            ab: for(int j=i;j<nums.length;j++)
            {
                int temp=0;
                if(i==0)
                {
                    temp=Integer.MIN_VALUE;
                }
                else
                {
                    temp=nums[0];
                }
                for(int k=1;k<nums.length;k++)
                {
                    if(k<i||k>j)
                    {
                        if(nums[k]<=temp)
                        {
                            continue ab;
                        }
                        temp=nums[k];
                    }
                }
                count++;
            }
        }
        return count;
    }
}