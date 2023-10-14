class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxCount=0,count=0,i=0,j=0,temp=k;
        while(j<nums.length)
        {
            if(nums[j]==1)
            {
                count++;
            }
            else
            {
                if(temp>0)
                {
                    temp--;
                    count++;
                }
                else
                {
                    maxCount=Math.max(maxCount,count);
                    while(nums[i]!=0)
                    {
                        i++;
                        count--;
                    }
                    i++;
                    count--;
                    temp++;
                    j--; // yeh bhot important hai sochna iske baare mein
                }
            }
            System.out.println(count+" "+i+" "+j);
            j++;
        }
        maxCount=Math.max(maxCount,count);
        return maxCount;
    }
}