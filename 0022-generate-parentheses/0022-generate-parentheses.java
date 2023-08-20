class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> finalList=new ArrayList<>();
        helper(n*2,"",finalList);
        return finalList;
    }
    public void helper(int symbols,String temp,List<String> finalList)
    {
        if(symbols==0)
        {
            if(validate(temp))
            finalList.add(temp);
            return;
        }
        // add opening symbol
        helper(symbols-1,temp+"(",finalList);
        // add closing bracket
        helper(symbols-1,temp+")",finalList);
    }
    public boolean validate(String temp)
    {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<temp.length();i++)
        {
            char c=temp.charAt(i);
            if(c=='(')
            st.add('(');
            else
            {
                if(st.isEmpty()||st.peek()!='(')
                return false;
                else
                st.pop();
            }
        }
        if(st.isEmpty())
        return true;
        return false;
    }
}