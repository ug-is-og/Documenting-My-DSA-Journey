class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        helper(ans,digits,0,"");
        return ans;
    }
    public void helper(List<String> ans,String digits,int index,String eachString)
    {
        if(index==digits.length())
        {
            if(eachString.length()!=0) // yeh wali condition super important hai considering the input digits=""; dry run and check once
            ans.add(eachString);
            return;
        }
        int eachDigit=Integer.valueOf(digits.charAt(index)+"");
        String options=getOptions(eachDigit);
        for(int i=0;i<options.length();i++)
        helper(ans,digits,index+1,eachString+options.charAt(i));
    }
    public String getOptions(int eachDigit)
    {
        if(eachDigit==2)
        return "abc";
        else if(eachDigit==3)
        return "def";
        else if(eachDigit==4)
        return "ghi";
        else if(eachDigit==5)
        return "jkl";
        else if(eachDigit==6)
        return "mno";
        else if(eachDigit==7)
        return "pqrs";
        else if(eachDigit==8)
        return "tuv";
        else
        return "wxyz";
    }
}