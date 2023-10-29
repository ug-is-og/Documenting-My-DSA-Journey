class Solution {
    public int findKOr(int[] nums, int k) {
        int maxBits=Integer.MIN_VALUE;
        int ans=0;
        for(int a:nums){
            maxBits=Math.max(maxBits,Integer.toBinaryString(a).length());
        }
        for(int i=0;i<maxBits;i++)
        {
            int temp=(int)Math.pow(2,i);
            int count=0;
            for(int j:nums){
                if((temp&j)==temp){
                    count++;
                }
            }
            if(count>=k){
                ans=ans+temp;
            }
        }
        return ans;
    }
}