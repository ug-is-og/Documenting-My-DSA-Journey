// Method 1 : Using HashMap and Sets

// class Solution {
//     public int minDeletions(String s) {
//         HashMap<Character,Integer> map=new HashMap<>();
//         Set<Integer> set=new HashSet<>();
//         int ans=0;
//         for(int i=0;i<s.length();i++)
//         {
//             map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
//         }
//         for(Map.Entry<Character,Integer> entry:map.entrySet())
//         {
//             int val=entry.getValue();
//             int key=entry.getKey();
//             int tempVal=val;
//             while(set.contains(tempVal))
//             {
//                 tempVal--;
//             }
//             if(tempVal!=0)
//             set.add(tempVal);
//             ans=ans+val-tempVal;
//         }
//         return ans;
//     }
// }

// Without using sets
// Done only using hashmaps

class Solution {
    public int minDeletions(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet())
        {
            int val=entry.getValue();
            char key=entry.getKey();
            map.put(key,Integer.MIN_VALUE);
            int tempVal=val;
            while(tempVal!=0&&map.containsValue(tempVal))
            {
                tempVal--;
            }
            map.put(key,tempVal);
            ans=ans+val-tempVal;
        }
        return ans;
    }
}