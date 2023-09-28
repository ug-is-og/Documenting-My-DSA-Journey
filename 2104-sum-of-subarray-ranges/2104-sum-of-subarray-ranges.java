// Sliding Window Based Question
// This question is very similar to the one where we find maxium in all subarrays of size K, ussi se inspired hai 
// Deque ka use kiya hamne, kaafi mushkil aayi parr end mein ho hi gaya
// https://leetcode.com/problems/sliding-window-maximum/description/

class Solution {
    public long subArrayRanges(int[] nums) {
        long sum=0;
        for(int k=1;k<=nums.length;k++)
        {
            int max=Integer.MIN_VALUE;
            int min=Integer.MAX_VALUE;
            Deque<Integer> dqMax=new ArrayDeque<>();
            Deque<Integer> dqMin=new ArrayDeque<>();
            for(int j=0;j<k;j++)
            {
                while(!dqMax.isEmpty()&&dqMax.getLast()<nums[j])
                dqMax.removeLast();
                dqMax.addLast(nums[j]);
                while(!dqMin.isEmpty()&&dqMin.getLast()>nums[j])
                dqMin.removeLast();
                dqMin.addLast(nums[j]);
                max=dqMax.getFirst();
                min=dqMin.getFirst();
            }
            sum=sum+max-min;
            int i=0,j=k;
            while(j<nums.length)
            {
                if(dqMax.getFirst()==nums[i])
                {
                    dqMax.removeFirst();
                }
                while(!dqMax.isEmpty()&&dqMax.getLast()<nums[j])
                dqMax.removeLast();
                dqMax.addLast(nums[j]);
                if(dqMin.getFirst()==nums[i])
                {
                    dqMin.removeFirst();
                }
                while(!dqMin.isEmpty()&&dqMin.getLast()>nums[j])
                dqMin.removeLast();
                dqMin.addLast(nums[j]);
                max=dqMax.getFirst();
                min=dqMin.getFirst();
                sum=sum+max-min;
                i++;
                j++;
            }
        }
        return sum;
    }
}