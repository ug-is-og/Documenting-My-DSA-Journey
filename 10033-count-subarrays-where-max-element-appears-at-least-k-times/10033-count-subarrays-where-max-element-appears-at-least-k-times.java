class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        // find max element
        for(int a:nums)
            max=Math.max(max,a);
        int start=0,end=nums.length-1,getter=0,count=0,firstOcc=0,kOcc=0;
        long ans=0; // bhot bekaar mistake kari hai leetcode weekly 375 mein, pura ques ho gaya 628/633 ho gaye par accept nahi hua kyu kyunki tumne return type nahi dekha, long tha chacha, int mein kar re the and neg mein ans aa ra tha
        List<Integer> indices=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==max)
            {
                count++;
                indices.add(i);
                if(count==1)
                {
                    firstOcc=i;
                }
                if(count==k)
                {
                    kOcc=i;
                }
                if(count==k)
                {
                    ans=ans+1L*(firstOcc-start+1)*(end-kOcc+1);
                    start=firstOcc+1;
                    if(firstOcc!=kOcc)
                    firstOcc=indices.get(++getter);
                    count--;
                }
            }
        }
        return ans;
    }
}