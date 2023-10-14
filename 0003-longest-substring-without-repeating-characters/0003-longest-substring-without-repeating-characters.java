class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0,count=0;
        int maxCount=Integer.MIN_VALUE; 
        HashMap<Character,Integer> map=new HashMap<>();
        while(j<s.length())
        {
            char c1=s.charAt(i);
            char c2=s.charAt(j);
            if(!map.containsKey(c2))
            {
                map.put(c2,1);
                count++;
                j++;
            }
            else
            {
                maxCount=Math.max(maxCount,count);
                count--;
                map.remove(c1);
                i++;
            }
        }
        maxCount=Math.max(maxCount,count); // ho sakta hai ki while loop ke andar jo else block lagaya hai woh kabhi chale hi na, matlab saare characters unique hi hai jaise "abcd" toh fir bahar aake maxCount ko update karna zaruri hai
        return Math.max(maxCount,0); // bhai yahan pe Math.max() lagana bhul gaye the, dhyan se socho ki agar maxCount MIN_VALUE hi raha for "" string input tab tumko 0 return karna chahiye
    }
}