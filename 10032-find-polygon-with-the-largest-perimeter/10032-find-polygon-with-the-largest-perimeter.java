class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long prefix[]=new long[nums.length];
        prefix[0]=nums[0];
        long max=Long.MIN_VALUE;
        for(int i=1;i<nums.length;i++)
        {
            prefix[i]=prefix[i-1]+nums[i];
            if(i>=2)
            {
               if(prefix[i-1]>nums[i])
               {
                   max=Math.max(max,prefix[i]);
               }
            }
        }
        if(max==Long.MIN_VALUE)
            return -1;
        return max;
    }
}