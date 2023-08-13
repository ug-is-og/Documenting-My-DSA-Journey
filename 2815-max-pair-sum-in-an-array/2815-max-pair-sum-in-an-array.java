class Solution {
    public int maxSum(int[] nums) {
        int maxDigits[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            int temp=nums[i];
            int max=Integer.MIN_VALUE;
            while(temp!=0)
            {
                int m=temp%10;
                max=Math.max(m,max);
                temp=temp/10;
            }
            maxDigits[i]=max;
        }
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(maxDigits[i]==maxDigits[j])
                    maxSum=Math.max(maxSum,nums[i]+nums[j]);
            }
        }
        if(maxSum==Integer.MIN_VALUE)
            return -1;
        return maxSum;
    }
}