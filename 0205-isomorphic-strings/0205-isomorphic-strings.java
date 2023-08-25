// Completely brute approach
// but this is the power of Java Collections
// YOu didn't even know about LinkedHashMap but it's like the key to slvinf this problem
// SC O(s.length()+t.length()) but kaafi saari list, hashmap bana diye hai
// TC O(s.length()+t.length()) but kaafi saare for loops use kar liye hai

// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//         LinkedHashMap<Character,Integer> map1=new LinkedHashMap<>();
//         LinkedHashMap<Character,Integer> map2=new LinkedHashMap<>();
//         List<Integer> list1=new ArrayList<>();
//         List<Integer> list2=new ArrayList<>();
//         List<Character> list3=new ArrayList<>();
//         List<Character> list4=new ArrayList<>();
//         String test="";
//         for(int i=0;i<s.length();i++)
//         {
//             char ch=s.charAt(i);
//             map1.put(ch,map1.getOrDefault(ch,0)+1);
//         }
//         for(Map.Entry<Character,Integer> entry:map1.entrySet())
//         {
//             list1.add(entry.getValue());
//             list3.add(entry.getKey());
//         }
//         for(int j=0;j<t.length();j++)
//         {
//             char ch=t.charAt(j);
//             map2.put(ch,map2.getOrDefault(ch,0)+1);
//         }
//         for(Map.Entry<Character,Integer> entry:map2.entrySet())
//         {
//             list2.add(entry.getValue());
//             list4.add(entry.getKey());
//         }
//         if(list1.equals(list2))
//         {
//             for(int i=0;i<s.length();i++)
//             {
//                 test=test+list4.get(list3.indexOf(s.charAt(i)));
//             }
//             System.out.println(test);
//             if(test.equals(t))
//             return true;
//         }
//         return false;
//     }
// }

// Let's look for a better approach

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if(!map.containsKey(c1))
            {
                if(!map.containsValue(c2)) // yeh check karna bhul gaye the so for this
                // test case error aa ra tha "badc" , "baba"
                map.put(c1,c2);
                else
                return false;
            }
            else
            {
                if(map.get(c1)==c2)
                continue;
                else
                return false;
            }
        }
        return true;
    }
}