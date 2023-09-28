// this is one of those questions jisme ede cases bhot carefully sochne hote hai toh bhot dhyan se karna aese questions, we'll optimize this later

class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> dq=new ArrayDeque<>();
        int i=0;
        for(i=0;i<num.length()&&k>0;i++)
        {
            while(!dq.isEmpty()&&k>0&&(dq.getLast()-'0')>(num.charAt(i)-'0')) // yahan > hoga >= nahi , analyze "1432219" k=3 test case
            {
                dq.removeLast();
                k--;
            }
            if(!(dq.isEmpty()&&num.charAt(i)=='0'))
            dq.addLast(num.charAt(i));
        }
        System.out.println(k+" "+i+" "+dq.size());
        for(int m=i;m<num.length();m++)
        dq.addLast(num.charAt(m));
        String ans="";
        int size=dq.size();
        if(k>0)
        {
            for(int p=0;p<size-k;p++)
            {
                if(!(ans.length()==0&&dq.getFirst()=='0'))
                ans=ans+dq.getFirst();
                dq.removeFirst();
            }
        }
        else
        {
            for(int p=0;p<size;p++)
            {
                if(!(ans.length()==0&&dq.getFirst()=='0'))
                ans=ans+dq.getFirst();
                dq.removeFirst();
            }
        }
        if(ans.length()==0)
        return "0";
        return ans;
    }
}