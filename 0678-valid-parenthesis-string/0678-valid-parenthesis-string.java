// https://www.youtube.com/watch?v=QhPdNS143Qg

class Solution {
    public boolean checkValidString(String s) {
        int leftMax=0,leftMin=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='(')
            {
                leftMax++;
                leftMin++;
            }
            else if(c==')')
            {
                leftMin--;
                leftMax--;
            }
            else
            {
                leftMax++;
                leftMin--;
            }
            if(leftMax<0)
            return false;
            leftMin=Math.max(leftMin,0);
        }
        if(leftMin>0)
        return false;
        return true;
    }
}