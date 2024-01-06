// sorting a 2d array basis the custom comparator
// best explanation :https://www.youtube.com/watch?v=Uz2iNhjGGm0

class ordering implements Comparator<int[]>{
    public int compare(int a[],int b[])
    {
        return a[0]-b[0];
    }
}
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int data[][]=new int[startTime.length][3];
        for(int i=0;i<startTime.length;i++)
        {
            data[i][0]=startTime[i];
            data[i][1]=endTime[i];
            data[i][2]=profit[i];
        }
        Arrays.sort(data,new ordering());
        int dp[]=new int[startTime.length];
        Arrays.fill(dp,-1);
        int sortedStartTime[]=new int[startTime.length];
        for(int i=0;i<startTime.length;i++)
        {
            sortedStartTime[i]=data[i][0];
        }
        return helper(dp,data,0,sortedStartTime);
    }
    public int helper(int dp[],int data[][],int index,int sortedStartTime[])
    {
        if(index==data.length)
        {
            return 0;
        }
        if(dp[index]!=-1)
        {
            return dp[index];
        }
        int profit=Math.max(data[index][2]+helper(dp,data,findIndex(sortedStartTime,data[index][1]),sortedStartTime),helper(dp,data,index+1,sortedStartTime));
        return dp[index]=profit;
    }
    public int findIndex(int sortedStartTime[],int target)
    {
        int low=0,high=sortedStartTime.length-1;
        int index=sortedStartTime.length;
        while(low<=high)
        {
            int mid=low+(high-low)/2; 
            if(sortedStartTime[mid]>=target) // >= hoga yaha pe tumne check kiya ki equal hai ya nahi, agar equal toh index return kar diya, jo galat hai, ho sakta hai ki usse peeche bhi equal element mil jaye kam index mein toh tumhe peeche tak aana padega
            {
                index=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return index;
    }
}