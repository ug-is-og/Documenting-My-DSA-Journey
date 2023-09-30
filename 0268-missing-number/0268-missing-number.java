// was firstly able to think of a solution with O(n) TC and O(n) SC
// after that I was able to think of a TC : O(n log n) solution using sorting
// eventually came up with O(n) TC approach

class Solution {
    public int missingNumber(int[] nums) {
        long sum=(nums.length*(nums.length+1))/2;
        for(int i=0;i<nums.length;i++)
        sum=sum-nums[i];
        return (int)sum;
    }
}