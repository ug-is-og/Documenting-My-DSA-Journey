// Sliding Window Problems mein ek cheez notice kari hai, ki it is about how effectively you can think of edge cases and sample test cases other than those given in the question, becuase ques mein kaafi baar kewal samjhane ke liye de dete hai test cases and they don't cover edge cases, but tumhe khud se kuch kuch complex test cases uthake dry run karna padega, only then you can build an effective approach

// jab pehli baar iss ques ko try kiya tab yahi galti kari ki jo cases ques mein diye kewal unko pakadke logic bana diya jo bhot galat cheez thi, tumhe khud se sochke dry run karna padega test cases ko

// Approach sahi hai, par optimize karo, not the best approach

class Solution {
    public int numberOfSubstrings(String s) {
        int i=0,j=0,ans=0,count=0,lastOcc=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while(j<s.length())
        {
            char c1=s.charAt(j);
            if(map.containsKey(c1))
            {
                map.put(c1,map.get(c1)+1);
            }
            else
            {
                count++;
                map.put(c1,1);
            }
            if(count==3)
            {
                while(count!=2)
                {
                    char c2=s.charAt(i);
                    if(map.get(c2)==1)
                    {
                        count--;
                        map.remove(c2);
                    }
                    else
                    {
                        map.put(c2,map.get(c2)-1);
                    }
                    i++;
                }
                ans=ans+(i-lastOcc)*(s.length()-j);
                lastOcc=i;
            }
            j++;
        }
        return ans;
    }
}