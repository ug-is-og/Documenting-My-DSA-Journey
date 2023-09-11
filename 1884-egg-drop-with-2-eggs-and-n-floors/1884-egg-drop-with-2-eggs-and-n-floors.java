// https://www.youtube.com/watch?v=UvksR0hR9nA

// pehli baat toh hame floor nahi nikalna hai matlab f ki value nahi chahiye, hame toh minimum no of attempts nikalna hai jisme ham pakke se determine kar lenge f ki vlaue

// project estimation ka question hai...jahan estimation involved hai wahan luck ki baat hai...aur jahan pe luck involved hai ...wahan luck ko apne against maanke chalte hai

// jahan pe bhi luck involve ho wahan pe apna bura maanlo, ki apne saath toh bura hi hone wala hai

// saare worst luck waale cases mein se jo best hota hai that is the guaranteed best time

// eggs=0 wala case consider hi nahi kiya hai

// https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/solutions/3291262/recursion-memoization-dp-java-solution/

class Solution {
    public int twoEggDrop(int n) {
        int dp[][]=new int[n+1][3];
        for(int temp[]:dp)
        Arrays.fill(temp,-1);
        return helper(n,2,dp);
    }
    public int helper(int floors,int eggs,int dp[][])
    {
        if(floors==1)
        return 1;
        if(floors==0)
        return 0;
        if(eggs==1)
        return floors;
        if(dp[floors][eggs]!=-1)
        return dp[floors][eggs];
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=floors;i++)
        {
            // anda fuut gaya
            int way1=helper(i-1,eggs-1,dp);
            // anda nahi futa
            int way2=helper(floors-i,eggs,dp);
            int max=Math.max(way1,way2);
            min=Math.min(min,max);
        }
        return dp[floors][eggs]=min+1;
    }
}