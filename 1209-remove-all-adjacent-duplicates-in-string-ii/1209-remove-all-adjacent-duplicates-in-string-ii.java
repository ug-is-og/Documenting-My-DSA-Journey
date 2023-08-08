// naive approach TLE aa raha 18/21 test cases passed
// iss approach mein basically ham baar baar elimination karke loop dobaara se chala re

// class Solution {
//     public String removeDuplicates(String s, int k) {
//         if(s.length()==1)
//         return s;
//         int i=0,j=0,count=1;
//         while(i<s.length()-1)
//         {
//             if(count==k)
//             {
//                 s=s.substring(0,j)+s.substring(i+1,s.length());
//                 i=0;
//                 j=0;
//                 count=1;
//                 continue;
//             }
//             else if(s.charAt(i)==s.charAt(i+1))
//             {
//         (        count++;
//             }
//             else if(s.charAt(i)!=s.charAt(i+1))
//             {
//                 count=1;
//                 j=i+1;
//             }
//             i++;
//         }
//         if(count==k)
//         s=s.substring(0,j)+s.substring(i+1,s.length());
//         return s;
//     }
// }


// mereko approach click nahi ho rahi thi toh fir meine jaake related topics dekhe and diya tha
// stack toh fir uss direction mein dimaag lagaya

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character,Integer>> st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            Pair<Character,Integer> temp=null;
            if(!st.isEmpty())
            {
                if(st.peek().getKey()==ch)
                {
                    temp=st.peek();
                    st.pop();
                    st.push(new Pair<>(temp.getKey(),temp.getValue()+1));
                }
                else
                {
                    st.push(new Pair<>(ch,1));
                }
            }
            else
            {
                st.push(new Pair<>(ch,1));
            }
            if(st.peek().getValue()==k)
            st.pop();
        }
        String ans="";
        while(!st.isEmpty())
        {
            int freq=st.peek().getValue();
            char c=st.peek().getKey();
            for(int i=1;i<=freq;i++)
            {
                ans=c+ans;
            }
            st.pop();
        }
        return ans;
    }
}