// typical question of front partition
// iss question mein overconfidence ki wajah se bhot time waste kiya hai
// tum baat ko samjho , tumne yeh figure out kar liya tha ki front partition ka ques hai 
// and overconfidence mein aake directly code karne lage, tumne pura protocol tod diya, 
// tumhe paper pe likh ke conditions dryn run kar leni chahiye thi, 1 hr condition sahi and 
// debug karne mein laga diya just because tumne paper pen pe nahi likhke dekha,
// thoda patience maintain karo bhai, bhot dikkar hogi

class Solution {
    public boolean validPartition(int[] nums) {
        int dp[]=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return helper(0,nums,dp);
    }
    public boolean helper(int index,int nums[],int dp[])
    {
        if(index==nums.length)
        return true;
        if(dp[index]!=-1)
        {
            if(dp[index]==1)
            return true;
            else
            return false;
        }
        boolean ans=false;
        int count1=1,count2=1;
        for(int i=index;i<nums.length-1&&i<index+2;i++)
        {
            if(nums[i]==nums[i+1])
            count1++;
            if(nums[i]==nums[i+1]-1)
            count2++;
            if((i==index&&count1==2)||(i==index+1&&count1==3)||count2==3)
            ans=ans||helper(i+2,nums,dp);
        }
        if(ans==true)
        dp[index]=1;
        else
        dp[index]=0;
        return ans;
    }
}