class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0,r=0,windSize=1,max=Integer.MIN_VALUE;
        long windSum=nums[0];
        while(r<nums.length)
        {
            if(nums[r]*windSize<=windSum+k)
            {
                r++;
                windSize++;
                if(r<nums.length)
                {
                    windSum+=nums[r];
                }
            }
            else
            {
                max=Math.max(max,r-l);
                windSum=windSum-nums[l];
                l++;
                windSize--;
            }
        }
        max=Math.max(max,r-l);
        return max;
    }
}