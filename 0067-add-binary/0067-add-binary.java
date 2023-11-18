// brute approach, will optimize it later

class Solution {
    public String addBinary(String a, String b) {
        String result="";
        int l1=a.length()-1;
        int l2=b.length()-1;
        char c1='\u0000',c2='\u0000',sum='\u0000',carry='\u0000';
        while(l1>=0||l2>=0)
        {
            if(l1>=0)
            {
                c1=a.charAt(l1);
                l1--;
            }
            else
            c1='0';
            if(l2>=0)
            {
                c2=b.charAt(l2);
                l2--;
            }
            else
            c2='0';
            if(c1=='1'&&c2=='1'&&carry=='1')
            {
                sum='1';
                carry='1';
            }
            else if((c1=='1'&&c2=='1')||(c1=='1'&&carry=='1')||(c2=='1'&&carry=='1'))
            {
                sum='0';
                carry='1';
            }
            else if(c1=='1'||c2=='1'||carry=='1')
            {
                sum='1';
                carry='0';
            }
            else
            {
                sum='0';
                carry='0';
            }
            result=sum+result;
        }
        if(carry=='1')
        result=carry+result;
        return result;
    }
}