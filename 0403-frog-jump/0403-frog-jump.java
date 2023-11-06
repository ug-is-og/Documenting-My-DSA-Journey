// the code has been accepted but will surely optimize it later

class Solution {
    public boolean canCross(int[] stones) {
        int dp[][]=new int[stones.length][2000];
        for(int temp[]:dp)
        {
            Arrays.fill(temp,-1);
        }
        if(stones[1]!=1)
        {
            return false;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<stones.length;i++)
        {
            map.put(stones[i],i);
        }
        return helper(1,stones,dp,1,map);
    }
    public boolean helper(int index,int stones[],int dp[][],int lastJump,HashMap<Integer,Integer> map)
    {
        if(index==stones.length-1)
        {
            return true;
        }
        if(dp[index][lastJump]!=-1)
        {
            if(dp[index][lastJump]==0)
            {
                return false;
            }
            return true;
        }
        boolean way1=false,way2=false,way3=false;
        if(map.containsKey(stones[index]+lastJump))
        {
            System.out.println("Hello 1");
            way1=helper(map.get(stones[index]+lastJump),stones,dp,lastJump,map);
        }
        if(lastJump>1&&map.containsKey(stones[index]+lastJump-1))
        {
            System.out.println("Hello 2");
            way2=helper(map.get(stones[index]+lastJump-1),stones,dp,lastJump-1,map);
        }
        if(map.containsKey(stones[index]+lastJump+1))
        {
            System.out.println("Hello 3");
            way3=helper(map.get(stones[index]+lastJump+1),stones,dp,lastJump+1,map);
        }
        boolean ans=((way1||way2)||way3);
        if(ans==true)
        {
            dp[index][lastJump]=1;
        }
        else
        {
            dp[index][lastJump]=0;
        }
        return ans;
    }
}