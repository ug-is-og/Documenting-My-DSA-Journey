class Solution {
    public char findFirstValidCharacter(int i,char arr[],char c,char limit)
    {
        char ans=c;
        for(;c<=limit&&(i>0&&(char)c==arr[i-1])||(i>1&&(char)c==arr[i-2]);c++)
        continue;
        return (char)c;
    }
    public String smallestBeautifulString(String s, int k) {
        char limit=(char)('a'+k-1);
        char arr[]=s.toCharArray();
        for(int i=s.length()-1;i>=0;i--)
        {
           char c=findFirstValidCharacter(i,arr,(char)(arr[i]+1),limit);
           if(c<=limit)
           {
               arr[i]=c;
               for(int j=++i;j<s.length();j++)
               {
                   char c1=findFirstValidCharacter(j,arr,'a',limit);
                   arr[j]=c1;
               }
               return String.valueOf(arr);
           }
        }
        return "";
    }
}