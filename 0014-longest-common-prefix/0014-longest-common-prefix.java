// Brute force approach
// TC O(N*max length of string)
// find largest string, aur ab harr ek string ka usse comparison kar, jis min point pe break ho re woh ho jayega answer
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int index=0,maxLength=Integer.MIN_VALUE;
        // yeh edge case bhul gaya tha hence nahi chala tha code for last test case
        if(strs.length==1)
        return strs[0];
        for(int i=0;i<strs.length;i++)
        {
            if(maxLength<strs[i].length())
            {
                maxLength=strs[i].length();
                index=i;
            }
        }
        String temp=strs[index];
        int minIndex=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++)
        {
            if(i!=index)
            {
                String temp2=strs[i];
                int j=0;
                for(j=0;j<Math.min(temp2.length(),temp.length());j++)
                {
                    if(temp.charAt(j)==temp2.charAt(j))
                    continue;
                    else
                    break;
                }
                minIndex=Math.min(minIndex,j);
            }
        }
         if(minIndex==Integer.MAX_VALUE)
         return "";
        return strs[0].substring(0,minIndex);
    }
}