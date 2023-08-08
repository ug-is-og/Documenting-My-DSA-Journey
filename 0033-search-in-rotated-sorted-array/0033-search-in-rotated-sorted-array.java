
// // yaar iss approach mein sabse bada red flag toh woh for loop hi hai kyunki worst case mein
// // uski TC O(n) ho jayegi toh Binary search ka faayda kya hua janaab

// // iss approach mein basically ham yeh figure out kar le rahe ki left sorted part kahan se 
// // kahan tak hai and right sorted part kahan se kahan tak hai apna, uske baad we can figure out target left sorted part mein hoga ya fir right sorted part mein ya hai hi nahi, accordingly
// // BS call kar denge

// class Solution {
//     public int search(int[] nums, int target) {
//         if(nums.length==1) // yeh edge case ka bhot dhyan dena, tum edge cases baar baar bhul jaate ho
//         {
//             if(nums[0]==target)
//             return 0;
//             else
//             return -1;
//         }
//         int index=0;
//         for(index=0;index<nums.length-1;index++) // to figure out left and right sorted part
//         {
//             if(nums[index]>nums[index+1])
//             break;
//         }
//         int lSE=index; // leftSorted End
//         int rSS=Math.min(index+1,nums.length-1); // right sorted start
//         // Math.min lagaya kyunki there is a chance ki rotate karne ke baad bhi sorted rahe array apni , toh index+1 toh nums.length ke equal ho jayega matlab pura for loop chala and kahi nahi break hua, toh cheez ko sort karne ke liye kiya
//         if(target>=nums[0]&&target<=nums[lSE])
//         {
//             return binarySearch(nums,0,lSE,target);
//         }
//         else if(target>=nums[rSS]&&target<=nums[nums.length-1])
//         {
//             return binarySearch(nums,rSS,nums.length-1,target);
//         }
//         return -1;
//     }
//     public int binarySearch(int nums[],int start,int end,int target)
//     {
//         int mid=0;
//         while(start<=end)
//         {
//             mid=(start+end)/2;
//             if(nums[mid]==target)
//             return mid;
//             else if(nums[mid]>target)
//             end=mid-1;
//             else
//             start=mid+1;
//         }
//         return -1;
//     }
// }


// upar waali approach mein ham basically yahi optimize karna chahte hai ki tumne soch toh liya ki hame left and right sorted half ki zarurat padegi par ab woh dhundhe kaise bina O(n) ke
// sorted half nikalna zaruri hai kyunki tum elimination tabhi laga paoge jab sorted half pata ho pakke se, kyunki binary search khel hai kewal unwanted elements ke elimination ka

// uska solution striver ki approach se aayega

class Solution {
    public int search(int[] nums, int target) {
        int low=0,high=nums.length-1,mid=0;
        while(low<=high)
        {
            mid=low+(high-low)/2; // preferrably done to avoid the overflow
            if(nums[mid]==target)
            return mid;
            else if(nums[low]<=nums[mid]) // this ensures ki left half sorted hoga including mid
            {
                if(target>=nums[low]&&target<=nums[mid]) // this ensure ki left sorted half mein hi hai element apna agar hai toh
                high=mid-1;
                else
                low=mid+1; // ensures ki right unsorted half mein ho sakta hai element
            }
            else // ensures ki right half sorted hai fir including mid
            {
                if(target>=nums[mid]&&target<=nums[high]) // this ensures ki right sorted half mein ho sakta hai element apna
                low=mid+1;
                else
                high=mid-1; // this ensures ki left unsorted half mein ho sakta hai element apna
            }
        }
        return -1;
    }
}