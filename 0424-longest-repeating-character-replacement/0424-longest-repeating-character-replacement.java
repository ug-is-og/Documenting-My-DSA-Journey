// O(26*n) TC

class Solution {
    public int characterReplacement(String s, int k) {
        int i=0,j=0,max=Integer.MIN_VALUE,ans=Integer.MIN_VALUE;
        char temp='\u0000';
        HashMap<Character,Integer> map=new HashMap<>();
        while(j<s.length())
        {
            char c=s.charAt(j);
            map.put(c,map.getOrDefault(c,0)+1);
            max=Math.max(max,map.get(c));
            if((j-i+1)-max>k)
            {
                temp=s.charAt(i);
                map.put(temp,map.get(temp)-1);
                max=getMaxData(map);
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
    public int getMaxData(HashMap<Character,Integer> map)
    {
        int max=Integer.MIN_VALUE;
        for(Map.Entry<Character,Integer> entry:map.entrySet())
        {
            max=Math.max(max,entry.getValue());
        }
        return max;
    }
}

// Most optimized O(n)
// Go through PratikSen07 solution
// https://youtu.be/gqXU1UyA8pk

// class Solution {
//     public int characterReplacement(String s, int k) {
//         int i=0,j=0,max=Integer.MIN_VALUE,ans=Integer.MIN_VALUE;
//         char temp='\u0000',maxChar='\u0000';
//         HashMap<Character,Integer> map=new HashMap<>();
//         while(j<s.length())
//         {
//             char c=s.charAt(j);
//             map.put(c,map.getOrDefault(c,0)+1);
//             max=Math.max(max,map.get(c));
//             if((j-i+1)-max>k)
//             {
//                 temp=s.charAt(i);
//                 map.put(temp,map.get(temp)-1);
//                 i++;
//             }
//             ans=Math.max(ans,j-i+1);
//             j++;
//         }
//         return ans;
//     }
// }



















