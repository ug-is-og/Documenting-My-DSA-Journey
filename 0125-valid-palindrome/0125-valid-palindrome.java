class Solution {
    public boolean isPalindrome(String s) {
        // remove unnecessary stuff
        s=s.toLowerCase(); // don't worry alphanumeric will remain unhampered
        String newString="";
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if((c>=97&&c<=122)||(Character.isDigit(c))) // digit check karna bhul gaya tha, brutal mistake bhaii
            newString=newString+c;
        }
        System.out.println(newString);
        if(newString.length()==0)
        return true;
        return palCheck(newString,0,newString.length()-1);
    }
    public boolean palCheck(String s,int i,int j)
    {
        if(i==j)
        {
            return true;
        }
        if(j==i+1)
        {
            if(s.charAt(i)==s.charAt(j))
            return true;
            else
            return false;
        }
        boolean ans=false;
        if(s.charAt(i)==s.charAt(j))
        ans=palCheck(s,i+1,j-1);
        return ans;
    }
}