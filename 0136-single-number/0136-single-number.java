// First I thought of a hashmap based solution with O(n) TC and O(n) SC
// then I was able to think of a sorting based solution with just O(nlog n) TC
// eventually saw this solution using Bit Manipulation in O(n) TC
// "Java Easy Solution || Beats 100% || Runtime: 1ms || Bit Manipulation" by vashi16
// simple sa concept use ho ra tha ki a xor a=0 , a xor 0=a toh jab sabka xor kar doge toh eventually woh akela number bachega ans mein

class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int a:nums)
        ans=ans^a;
        return ans;
    }
}