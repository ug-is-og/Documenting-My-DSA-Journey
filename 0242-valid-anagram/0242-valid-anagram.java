// brute force approach

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         HashMap<Character,Integer> map=new HashMap<>();
//         for(int i=0;i<s.length();i++)
//         {
//             char ch=s.charAt(i);
//             map.put(ch,map.getOrDefault(ch,0)+1);
//         }
//         for(int i=0;i<t.length();i++)
//         {
//             char ch=t.charAt(i);
//             if(map.containsKey(ch)&&map.get(ch)>0)
//             {
//                 map.put(ch,map.get(ch)-1);
//             }
//             else
//             return false;
//         }
//         for(Map.Entry<Character,Integer> entry:map.entrySet())
//         {
//             if(entry.getValue()==0)
//             {
//                 continue;
//             }
//             else
//             return false;
//         }
//         return true;
//     }
// }






















// O(n) TC and O(n) space (using map)

// class Solution {
//     public boolean isAnagram(String s, String t) {
//        HashMap<Character,Integer> map=new HashMap<>();
//        for(int i=0;i<s.length();i++)
//        {
//            char c=s.charAt(i);
//            map.put(c,map.getOrDefault(c,0)+1);
//        }
//        for(int i=0;i<t.length();i++)
//        {
//            char c=t.charAt(i);
//            if(map.containsKey(c))
//            {
//                if(map.get(c)==1)
//                {
//                    map.remove(c);
//                }
//                else
//                {
//                    map.put(c,map.get(c)-1);
//                }
//            }
//            else
//            {
//                return false;
//            }
//        }
//        if(map.isEmpty())
//        {
//            return true;
//        }
//        return false;
//     }
// }


// using array

class Solution {
    public boolean isAnagram(String s, String t) {
       int freq[]=new int[26];
       for(int i=0;i<s.length();i++)
       {
           int index=((int)s.charAt(i))-97;
           freq[index]++;
       }
       for(int i=0;i<t.length();i++)
       {
           int index=((int)t.charAt(i))-97;
           if(freq[index]==0)
           return false;
           freq[index]--;
       }
       for(int i=0;i<freq.length;i++)
       {
           if(freq[i]!=0)
           return false;
       }
       return true;
    }
}