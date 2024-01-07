// best explanation : https://www.youtube.com/watch?v=XjLT4TaXsgw

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        ArrayList<HashMap<Long,Integer>> list=new ArrayList<>();
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            HashMap<Long,Integer> currMap=new HashMap<>();
            for(int j=0;j<i;j++)
            {
                HashMap<Long,Integer> temp=list.get(j);
                long diff=(long)nums[i]-(long)nums[j];
                if(temp.containsKey(diff))
                {
                    ans=ans+temp.get(diff);
                }
                currMap.put(diff,(temp.getOrDefault(diff,0)+1)+currMap.getOrDefault(diff,0));
            }
            list.add(currMap);
        }
        return ans;
    }
}