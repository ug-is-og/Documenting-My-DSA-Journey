// iss approach mein basically ham yeh figure out kar le rahe ki left sorted part kahan se 
// kahan tak hai and right sorted part kahan se kahan tak hai apna, uske baad we can figure out target left sorted part mein hoga ya fir right sorted part mein ya hai hi nahi, accordingly
// BS call kar denge

class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==1) // yeh edge case ka bhot dhyan dena, tum edge cases baar baar bhul jaate ho
        {
            if(nums[0]==target)
            return 0;
            else
            return -1;
        }
        int index=0;
        for(index=0;index<nums.length-1;index++) // to figure out left and right sorted part
        {
            if(nums[index]>nums[index+1])
            break;
        }
        int lSE=index; // leftSorted End
        int rSS=Math.min(index+1,nums.length-1); // right sorted start
        // Math.min lagaya kyunki there is a chance ki rotate karne ke baad bhi sorted rahe array apni , toh index+1 toh nums.length ke equal ho jayega matlab pura for loop chala and kahi nahi break hua, toh cheez ko sort karne ke liye kiya
        if(target>=nums[0]&&target<=nums[lSE])
        {
            return binarySearch(nums,0,lSE,target);
        }
        else if(target>=nums[rSS]&&target<=nums[nums.length-1])
        {
            return binarySearch(nums,rSS,nums.length-1,target);
        }
        return -1;
    }
    public int binarySearch(int nums[],int start,int end,int target)
    {
        int mid=0;
        while(start<=end)
        {
            mid=(start+end)/2;
            if(nums[mid]==target)
            return mid;
            else if(nums[mid]>target)
            end=mid-1;
            else
            start=mid+1;
        }
        return -1;
    }
}