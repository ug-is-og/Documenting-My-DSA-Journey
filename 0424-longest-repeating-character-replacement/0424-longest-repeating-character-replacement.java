class maxData{
    int val;
    char letter;
    public maxData(int val,char letter)
    {
        this.val=val;
        this.letter=letter;
    }
}
class Solution {
    public int characterReplacement(String s, int k) {
        int i=0,j=0,max=Integer.MIN_VALUE,ans=Integer.MIN_VALUE;
        char temp='\u0000',maxChar='\u0000';
        HashMap<Character,Integer> map=new HashMap<>();
        while(j<s.length())
        {
            char c=s.charAt(j);
            map.put(c,map.getOrDefault(c,0)+1);
            if(max<map.get(c))
            {
                maxChar=c;
                max=map.get(c);
            }
            max=Math.max(max,map.get(c));
            if((j-i+1)-max>k)
            {
                temp=s.charAt(i);
                if(map.get(temp)==1)
                {
                    map.remove(temp);
                }
                else
                {
                    map.put(temp,map.get(temp)-1);
                }
                maxData obj=getMaxData(map);
                max=obj.val;
                maxChar=obj.letter;
                i++;
            }
            else
            {
                ans=Math.max(ans,j-i+1);
            }
            j++;
        }
        return ans;
    }
    public maxData getMaxData(HashMap<Character,Integer> map)
    {
        char maxChar='\u0000';
        int max=Integer.MIN_VALUE;
        for(Map.Entry<Character,Integer> entry:map.entrySet())
        {
            if(entry.getValue()>max)
            {
                max=entry.getValue();
                maxChar=entry.getKey();
            }
        }
        return new maxData(max,maxChar);
    }
}