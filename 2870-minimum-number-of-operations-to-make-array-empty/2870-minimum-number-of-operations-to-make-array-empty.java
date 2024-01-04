class Solution {
    public int minOperations(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            int temp=entry.getValue();
            if(temp%3==0)
            {
                count=count+temp/3;
            }
            else if(temp%3==2)
            {
                count=count+temp/3+1; // removind 2 elements at a time, 1 time
            }
            else
            {
                if(temp==1)
                {
                    return -1;
                }
                count=count+(temp/3-1)+2; // removing 2 elements at a time, 2 times
            }
        }
        return count;
    }
}