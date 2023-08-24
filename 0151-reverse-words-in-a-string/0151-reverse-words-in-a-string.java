// Completely Brute Approach
// learning , a stirng list by default is printed like [abc, def, ghi], yeh space apne aap aati hai by default, tum isme kaafi der tak uljhe the
// We need to optimize this code later

class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String ans="";
        int firstIndex=s.indexOf(' ');
        String firstWord="";
        if(firstIndex==-1)
        {
            firstWord=s;
            return firstWord;
        }
        else
        firstWord=s.substring(0,firstIndex);
        List<String> list=new ArrayList<>();
        if(firstWord.length()!=0)
        list.add(firstWord);
        int lastIndex=s.lastIndexOf(' ');
        String lastWord="";
        if(lastIndex!=-1)
        lastWord=s.substring(lastIndex+1);
        int startIndex=firstIndex;
        while(startIndex!=lastIndex)
        {
            while(s.charAt(startIndex)==' '&&startIndex<lastIndex)
            startIndex++;
            int index1=0,index2=0;
            if(s.charAt(startIndex)!=' ')
            {
                index1=startIndex;
                while(s.charAt(startIndex)!=' ')
                startIndex++;
                if(s.charAt(startIndex)==' ')
                index2=startIndex;
                list.add(s.substring(index1,index2));
            }
        }
        if(lastWord.length()!=0)
        list.add(lastWord);
        reverse(list);
        return findAns(list);
    }
    public void reverse(List<String> list)
    {
        for(int i=0;i<list.size()/2;i++)
        {
            String temp=list.get(i);
            list.set(i,list.get(list.size()-1-i));
            list.set(list.size()-1-i,temp);
        }
    }
    public String findAns(List<String> list)
    {
        String ans="";
        for(int i=0;i<list.size();i++)
        ans=ans+list.get(i)+" ";
        ans=ans.trim();
        return ans;
    }
}