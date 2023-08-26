class Solution {
    public int maxDepth(String s) {
        Stack<Character> st=new Stack<>();
        int maxDepth=Integer.MIN_VALUE;
        int currDepth=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            {
                st.push(ch);
                currDepth++;
                maxDepth=Math.max(currDepth,maxDepth);
            }
            else if(ch==')')
            {
                currDepth--;
            }
        }
        if(maxDepth==Integer.MIN_VALUE) // yeh wala edge case bhul gaye the ki maxDepth update hi nahi hua matlab paranthesis hi nahi mile phir tum toh min value return kardoge
        return 0;
        return maxDepth;
    }
}