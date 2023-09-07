class Solution {
    public int[] searchRange(int[] nums, int target) {
        int occurence[]=new int[2];
        int start=0,end=nums.length-1;
        boolean isFirst=true;
        occurence[0]=targetOccurence(nums,start,end,target,true);
        occurence[1]=targetOccurence(nums,start,end,target,false);
        return occurence;
    }
    public int targetOccurence(int nums[],int start,int end,int target,boolean isFirst)
    {
       int mid;
        int occurence=-1;
        while(start<=end)
        {
            mid=(start+end)/2;
            if(nums[mid]==target)
            {
                occurence=mid;
                if(isFirst)
                end=mid-1;
                else
                start=mid+1;
            }
            else if(nums[mid]<target)
            start=mid+1;
            else
            end=mid-1;
        }
        return occurence;
    }
}