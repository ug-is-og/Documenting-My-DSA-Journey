// Brute force approach
// using concept of sorting hashmap based on values
// For space, we used 1 hashmap, 1 linkedhashmap and 1 list O(n) to build first hashmap, then to build list O(52) then to build linkedhashmap O(52)
// for time O(n) + O(52*52) 26+26 characters for both uppercase and lowercase

class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        List<Integer> list=new ArrayList<>();
        for(Map.Entry<Character,Integer> entry:map.entrySet())
        {
            list.add(entry.getValue());
        }
        // Arrays.sort(list,Collections.reverseOrder());
        // we can't use Collections.reverseOrder() for int type arrays but we can use it with Integer type array
        // to convert int type array to Integer type array and vice versa
        // https://anotepad.com/notes/t9i7ceks

        Collections.sort(list,Collections.reverseOrder());

        LinkedHashMap<Character,Integer> newMap=new LinkedHashMap<>();
        for(int i=0;i<list.size();i++)
        {
            for(Map.Entry<Character,Integer> entry:map.entrySet())
            {
                if(list.get(i)==entry.getValue())
                newMap.put(entry.getKey(),entry.getValue());
            }
        }
        String ans="";
        for(Map.Entry<Character,Integer> entry:newMap.entrySet())
        {
            for(int i=0;i<entry.getValue();i++)
            ans=ans+entry.getKey();
        }
        return ans;
    }
}

// Let's optimize the above approach

