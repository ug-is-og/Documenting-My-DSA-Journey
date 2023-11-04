class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int i=0,j=0,count=0,ans=0;
        List<Integer> oddIndices=new ArrayList<>();
        while(j<nums.length)
        {
            if(nums[j]%2!=0)
            {
                oddIndices.add(j);
                count++;
            }
            if(count>k)
            {
                ans=ans+(oddIndices.get(0)-i+1)*(oddIndices.get(count-1)-oddIndices.get(count-2));
                i=oddIndices.remove(0)+1;
                count--;
            }
            j++;
        }
        if(count==k)
        {
            ans=ans+(oddIndices.get(0)-i+1)*(j-oddIndices.get(count-1));
        }
        return ans;
    }
}