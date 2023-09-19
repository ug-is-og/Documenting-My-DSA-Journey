class Solution {
    public int numSplits(String s) {
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            map2.put(c,map2.getOrDefault(c,0)+1);
            map1.put(c,map1.get(c)-1);
            if(map1.get(c)==0)
            map1.remove(c);
            if(map1.size()==map2.size())
            count++;
        }
        return count;

    }
}