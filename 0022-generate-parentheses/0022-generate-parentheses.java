// Brute force appraoch, generating all possible paranthesis and eventually validating them

// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> finalList=new ArrayList<>();
//         helper(n*2,"",finalList);
//         return finalList;
//     }
//     public void helper(int symbols,String temp,List<String> finalList)
//     {
//         if(symbols==0)
//         {
//             if(validate(temp))
//             finalList.add(temp);
//             return;
//         }
//         // add opening symbol
//         helper(symbols-1,temp+"(",finalList);
//         // add closing bracket
//         helper(symbols-1,temp+")",finalList);
//     }
//     public boolean validate(String temp)
//     {
//         Stack<Character> st=new Stack<>();
//         for(int i=0;i<temp.length();i++)
//         {
//             char c=temp.charAt(i);
//             if(c=='(')
//             st.add('(');
//             else
//             {
//                 if(st.isEmpty()||st.peek()!='(')
//                 return false;
//                 else
//                 st.pop();
//             }
//         }
//         if(st.isEmpty())
//         return true;
//         return false;
//     }
// }

// generating the valid paranthesis in the first place
// for open paranthesis , open>0
// for close paranthesis, close>0 and open<close

class Solution {
    
    public List<String> generateParenthesis(int n) 
    {
        List<String> list=new ArrayList<>();
        helper(n,n,list,"");
        return list;
    }
    public void helper(int open,int close,List<String> list,String s)
    {
        if(open==0&&close==0)
        {
            list.add(s);
            return;
        }
        if(open>0)
        {
            helper(open-1,close,list,s+"(");
        }
        if(close>0&&open<close)
        {
            helper(open,close-1,list,s+")");
        }
    }
}