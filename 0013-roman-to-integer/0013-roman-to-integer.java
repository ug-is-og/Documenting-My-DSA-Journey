class Solution {
    public int romanToInt(String s) {
        int ans=0;
        int i=0;
        for(i=0;i<s.length()-1;i++)
        {
            char c1=s.charAt(i);
            char c2=s.charAt(i+1);
            if(numeralValue(c1+"")>=numeralValue(c2+""))
            {
                ans=ans+numeralValue(c1+"");
            }
            else
            {
                ans=ans+numeralValue(c2+"")-numeralValue(c1+"");
                i++;
            }
        }
        if(i==s.length()-1)
        ans=ans+numeralValue(s.charAt(s.length()-1)+"");
        return ans;
    }
    public int numeralValue(String roman)
    {
        int ans=0;
        switch(roman)
        {
            case "I":
            ans=1;
            break;
            case "V":
            ans=5;
            break;
            case "X":
            ans=10;
            break;
            case "L":
            ans=50;
            break;
            case "C":
            ans=100;
            break;
            case "D":
            ans=500;
            break;
            case "M":
            ans=1000;
            break;
        }
        return ans;
    }
}