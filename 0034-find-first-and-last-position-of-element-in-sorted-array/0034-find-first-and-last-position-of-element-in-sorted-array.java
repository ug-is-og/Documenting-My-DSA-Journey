class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[]=new int[2];
        ans[0]=binarySearch(nums,target,true); // startIndex represented by set bit
        ans[1]=binarySearch(nums,target,false);
        return ans;
    }
    public int binarySearch(int nums[],int target,boolean start)
    {
        int index=-1,lo=0,hi=nums.length-1;
        while(lo<=hi)
        {
            int mid=(lo+hi)/2;
            if(nums[mid]==target)
            {
                index=mid;
                if(start)
                {
                    hi=mid-1;
                }
                else
                {
                    lo=mid+1;
                }
            }
            else if(nums[mid]>target)
            {
                hi=mid-1;
            }
            else
            {
                lo=mid+1;
            }
        }
        return index;
    }
}