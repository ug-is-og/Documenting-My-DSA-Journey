// Done using BFS approach told by striver
// https://youtu.be/tRPda0rcf8E

class queueData{
    String data;
    int steps;
    public queueData(String data,int steps)
    {
        this.data=data;
        this.steps=steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<queueData> q=new LinkedList<>();
        // build a set for List<String> so that contains() can be done in O(1)
        Set<String> set=new HashSet<>();
        for(int i=0;i<wordList.size();i++)
        set.add(wordList.get(i));
        q.add(new queueData(beginWord,1));
        while(!q.isEmpty())
        {
            queueData temp=q.remove();
            String data=temp.data;
            if(endWord.equals(data))
            {
                return temp.steps;
            }
            for(int i=0;i<data.length();i++) // Striver ka solution dekhne se pehle ham yeh soch re the ki jaise "hit" hai uska hashmap banayenge fir wordList ke harr ek word ka hashmap banake compare karte jayenge, jahan pe bhi mujhe ek letter ka difference mila bas wahan ham sequence length+1 karke aage check karenge par yeh bhot zaada brute approach hai, fir hamne socha ki yaar "hit" mein harr ek combination ko try karke dekh lete hai jahan kewal ek letter vary kar ra toh O(26*N) ka operation hua kyunki ham set bana chuke hai aur set ke contains() ki complexity O(1) hogi , worst case mein ham apne set ke harr ek bande ko queue mein laayenge hence O(26*length of word*wordList.size())
            {
                char c=data.charAt(i);
                for(char j='a';j<='z';j++)
                {
                    String str=data.substring(0,i)+j+data.substring(i+1);
                    if(set.contains(str))
                    {
                        q.add(new queueData(str,temp.steps+1));
                        set.remove(str);
                    }
                }
            }
        }
        return 0;
    }
}