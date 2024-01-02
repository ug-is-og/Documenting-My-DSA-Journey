// great learning from this question is map.remove(entry.getKey()) can't be used to remove a key value pair from hashmap while iterating it using simple for loop, for(Map.Entry<Integer,Integer> entry:map.entrySet()) , it will give concurrent modification exception, instead you can use iterator to solve this issue

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        List<List<Integer>> ans=new ArrayList<>();
        for(int a:nums)
        {
            map.put(a,map.getOrDefault(a,0)+1);
        }
        while(map.size()!=0)
        {
            List<Integer> list=new ArrayList<>();
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                list.add(entry.getKey());
                if (entry.getValue() == 1) {
                    iterator.remove(); // Use iterator to remove the entry safely
                } else {
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}