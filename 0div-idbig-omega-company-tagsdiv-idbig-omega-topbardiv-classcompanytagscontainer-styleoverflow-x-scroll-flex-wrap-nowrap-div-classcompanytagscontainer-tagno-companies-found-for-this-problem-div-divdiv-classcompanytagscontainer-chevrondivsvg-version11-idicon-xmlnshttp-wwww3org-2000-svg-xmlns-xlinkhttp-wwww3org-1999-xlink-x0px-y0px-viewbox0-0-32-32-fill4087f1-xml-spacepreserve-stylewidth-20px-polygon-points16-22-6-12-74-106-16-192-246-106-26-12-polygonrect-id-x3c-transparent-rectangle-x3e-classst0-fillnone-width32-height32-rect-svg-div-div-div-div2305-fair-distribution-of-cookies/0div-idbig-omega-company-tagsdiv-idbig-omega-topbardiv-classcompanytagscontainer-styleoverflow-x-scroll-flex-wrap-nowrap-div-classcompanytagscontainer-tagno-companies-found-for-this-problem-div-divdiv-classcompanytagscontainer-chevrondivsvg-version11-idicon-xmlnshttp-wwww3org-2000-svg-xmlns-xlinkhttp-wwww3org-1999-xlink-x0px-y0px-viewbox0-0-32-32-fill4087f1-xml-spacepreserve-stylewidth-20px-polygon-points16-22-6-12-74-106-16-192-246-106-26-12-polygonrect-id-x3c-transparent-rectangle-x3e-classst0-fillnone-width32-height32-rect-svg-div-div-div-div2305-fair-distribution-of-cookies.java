// Solution with Title: ✅Back Track\U0001f525 || C++ || JAVA || Beginner Friendly\U0001f525\U0001f525\U0001f525

class Solution {
    int ans=Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        helper(cookies,k,0,new int[k]);
        return ans;
    }
    public void helper(int cookies[],int k,int index,int temp[])
    {
        if(index==cookies.length)
        {
            int max=0;
            for(int a:temp)
            {
                max=Math.max(max,a);
            }
            ans=Math.min(ans,max);
            return; // bhai yeh return likhna mat bhula kar, interview mein bande par accha impact nahi padta yeh sab galtiya karega toh
        }
        for(int i=0;i<k;i++)
        {
            temp[i]+=cookies[index];
            helper(cookies,k,index+1,temp);
            temp[i]-=cookies[index];
        }
    }
}