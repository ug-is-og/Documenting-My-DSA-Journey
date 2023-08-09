class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums); // isse ham yeh ensure kar re ki jo bhi differences nikal re woh
        // minimum possible rahe, taki isse ham yeh ensure kar paaye ki minimize ho jaaye maximum difference among all p pairs
        // agar saare differences in a p pairs at one time are minimum possible toh unme se jo maximum hoga that is the minimum maximum difference possible
        int low=0;
        int high=nums[nums.length-1]-nums[0];
        int mid=0,ans=0;
        while(low<=high) // using binary search to check from low to high ki konsa woh minimum maximum difference hai
        {
            mid=(low+high)/2;
            if(isPossibleMaximumDifference(mid,nums,p))
            {
                ans=mid;
                high=mid-1;// matlab if mid is a possible maximum difference toh mein apne max ko agli baar kam karke bhejunga kyunki mujhe max ko minimum possible rakhna hai na
            }
            else
            {
                low=mid+1; // agar mid nahi hai possible maximum difference toh max ko bada karke bhejo kyunki you have no option but to increase maximum kyunki abhi ke bhi maximum nahi mila, minimize toh bhot durr ki baat hai
            }
        }
        return ans;
    }
    public boolean isPossibleMaximumDifference(int mid,int nums[],int p)
    {
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]-nums[i-1]<=mid)
            {
                p--;
                i++;
            }
        }
        return p<=0; // matlab agar p=0 ho gaya ya fir p negative mein hi chala gaya iska matlab mujhe aese p ya p se zaada pairs mil gaye jinka difference mid ya mid se kam hai jo indirectly yeh signify karta hai ki mid is a possible maximum difference
    }
}