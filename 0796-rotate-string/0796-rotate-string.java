class Solution {
    public boolean rotateString(String s, String goal) {
        int index=-1;
        for(int i=1;i<=s.length();i++)
        {
            if(goal.contains(s.substring(0,i)))
            {
                index=i;
                continue;
            }
        }
        if(index==-1) 
        return false;
        if(s.substring(index).equals(goal.substring(0,goal.indexOf(s.substring(0,index)))))
        return true;
        return false;
    }
}