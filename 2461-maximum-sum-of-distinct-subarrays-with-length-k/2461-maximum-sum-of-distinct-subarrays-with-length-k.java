class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        int i=0,j=0;
        long sum=0,maxSum=0;
        while(j<nums.length)
        {
            if(!set.contains(nums[j])) // there is no need to check whether set is empty or not
            {
                set.add(nums[j]);
                sum=sum+nums[j];
            }
            else
            {
                set.remove(nums[i]);
                sum=sum-nums[i];
                i++;
                continue;
            }
            if(j-i+1<k)
            {
                j++;
            }
            else
            {
                maxSum=Math.max(maxSum,sum);
                sum=sum-nums[i];
                set.remove(nums[i]);
                i++;
                j++;   
            }
        }
        return Math.max(0,maxSum);
    }
}