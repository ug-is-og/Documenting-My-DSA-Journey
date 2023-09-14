// refer to Pawan's solution
// Binary Search || JAVA || Easiest Beginner Friendly Solution

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum=0,max=Integer.MIN_VALUE;
        for(int a:weights)
        {
            sum=sum+a;
            max=Math.max(a,max);
        }
        int start=max;
        int end=sum;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(isCap(mid,weights,days))
            {
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        return start; // yahan pe start kyun return kiya hai woh thoda sa dicey hai abhi, samajhna padega yeh toh
    }
    public boolean isCap(int wt,int weights[],int days) // iss code ke logic ko analyze karo kaafi pyara banaya gaya hai
    {
        int sum=0;
        int count=0;
        for(int i=0;i<weights.length;i++)
        {
            sum=sum+weights[i];
            if(sum>wt)
            {
                count++;
                sum=weights[i];
            }
        }
        if(sum<=wt)
        count++;
        if(count<=days)
        return true;
        return false;
    }
}
