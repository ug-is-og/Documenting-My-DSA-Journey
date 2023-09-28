class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        List<Integer> list=new ArrayList<>();
        while(x!=0)
        {
            int m=x%10;
            list.add(m);
            x=x/10;
        }
        for(int i=0;i<list.size()/2;i++)
        {
            if(list.get(i)!=list.get(list.size()-1-i))
                return false;
        }
        return true;
    }
}