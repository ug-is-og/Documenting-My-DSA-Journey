class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int lCount=0, rCount=0, dashCount=0,ans=0;
        for(int i=0;i<moves.length();i++)
        {
            char ch=moves.charAt(i);
            if(ch=='L')
                lCount++;
            else if(ch=='R')
                rCount++;
            else
                dashCount++;
        }
        if(lCount>=rCount)
        {
            ans=lCount-rCount+dashCount;
        }
        else
            ans=rCount-lCount+dashCount;
        return ans;
    }
}