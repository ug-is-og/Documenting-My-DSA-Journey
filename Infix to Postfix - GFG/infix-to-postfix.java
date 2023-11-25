//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        Stack<Character> oprts=new Stack<>();
        Stack<String> opnds=new Stack<>();
        String temp="*+^-/()";
        for(int i=0;i<exp.length();i++)
        {
            char c=exp.charAt(i);
           // System.out.println("Hello");
            if(!temp.contains(c+""))
            {
                opnds.push(c+"");
            }
            else if(c=='(')
            {
                oprts.push(c);
            }
            else if(c==')')
            {
                while(oprts.peek()!='(')
                {
                    String opnd2=opnds.pop();
                    String opnd1=opnds.pop();
                    String ans=opnd1+opnd2+oprts.pop();
                    opnds.push(ans);
                }
                oprts.pop();
            }
            else
            {
                while(!oprts.isEmpty()&&priority(c)<=priority(oprts.peek()))
                {
                    String opnd2=opnds.pop();
                    String opnd1=opnds.pop();
                    String ans=opnd1+opnd2+oprts.pop();
                    opnds.push(ans);
                }
                oprts.push(c);
            }
        }
        while(!oprts.isEmpty())
        {
            String opnd2=opnds.pop();
            String opnd1=opnds.pop();
            String ans=opnd1+opnd2+oprts.pop();
            opnds.push(ans);
        }
        return opnds.pop();
    }
    public static int priority(char c)
    {
        if(c=='(')
        return 0;
        if(c=='+'||c=='-')
        return 1;
        else if(c=='*'||c=='/')
        return 2;
        return 3;
    }
}