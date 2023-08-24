class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st=new Stack<>();
        String ans="";
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            {
                st.push(ch);
                if(st.size()>1)
                ans=ans+'(';
            }
            if(ch==')')
            {
                st.pop();
                if(st.size()==0)
                continue;
                else
                {
                    ans=ans+')';
                }
            }
        }
        return ans;
    }
}