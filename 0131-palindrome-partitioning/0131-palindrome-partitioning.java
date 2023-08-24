class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        helper(0,temp,ans,s);
        return ans;
    }
    public void helper(int index,List<String> temp,List<List<String>> ans,String s)
    {
        if(index==s.length())
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index+1;i<=s.length();i++)
        {
            if(isPalindrome(s.substring(index,i)))
            {
                temp.add(s.substring(index,i));
                helper(i,temp,ans,s);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPalindrome(String test)
    {
        for(int i=0;i<test.length()/2;i++)
        {
            if(test.charAt(i)==test.charAt(test.length()-1-i))
            continue;
            return false;
        }
        return true;
    }
}