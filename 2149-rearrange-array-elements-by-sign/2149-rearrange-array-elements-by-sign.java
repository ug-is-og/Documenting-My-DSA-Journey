class Solution {
    public int[] rearrangeArray(int[] nums) {
        int i=0,j=1;
        int ans[]=new int[nums.length];
        for(int k=0;k<ans.length;k++)
        {
            if(nums[k]>0)
            {
                ans[i]=nums[k];
                i=i+2;
            }   
            else
            {
                ans[j]=nums[k];
                j=j+2;
            }
        }
        return ans;
    }
}