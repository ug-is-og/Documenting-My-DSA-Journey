// standard mcm dp wali approach nahi lag sakti, try karke dekh liya apan ne,
// jaise left and right call laga dete inside k loop woh kaam nahi karega yahn pe

// Array resizing wala method bhi try karke dekh liya iss question mein, TLE maar de raha
// probably due to duniya bhar ke for loops, aur baar baar array banana
// recursion based solution se 24 test cases pass ho re and yeh wala memoization lagake 33
// you have to optimize it further

// class Solution {
//     public int maxCoins(int[] nums) {
//         HashMap<String,Integer> map=new HashMap<>();
//         return helper(nums,map);
//     }
//     public int helper(int nums[],HashMap<String,Integer> map)
//     {
//         if(nums.length==0)
//         return 0;
//         int maxCost=0;
//         int cost=0;
//         String key="";
//         for(int i=0;i<nums.length;i++)
//         key=key+nums[i]+"_";
//         if(map.containsKey(key))
//         return map.get(key);
//         for(int i=0;i<nums.length;i++)
//         {
//             int newArray[]=new int[nums.length-1];
//             int k=0;
//             int leftCost=1,rightCost=1,midCost=1;
//             for(int j=0;j<nums.length;j++)
//             {
//                 if(i!=j)
//                 newArray[k++]=nums[j];
//             }
//             if(i-1>=0)
//             leftCost=nums[i-1];
//             if(i+1<nums.length)
//             rightCost=nums[i+1];
//             cost=leftCost*nums[i]*rightCost+helper(newArray,map);
//             maxCost=Math.max(maxCost,cost);
//         }
//         map.put(key,maxCost);
//         return maxCost;
//     }
// }

// approaching with further optimization
// Striver's bottom up approach, pehle 3,1,5,8 ke liye normal dry run karo, ab isme jo most optimal path hai usme last mein 8 balloon bach raha toh ab bottom up socho ki 8 aakhir mein futa toh second last step mein koun koun fut sakta and upar tak jao, aese karke tum left and right independent sub problems mein tod paoge
// https://takeuforward.org/dynamic-programming/striver-dp-series-dynamic-programming-problems/

// recursive solution 31 test cases passed

// class Solution {
//     public int maxCoins(int[] nums) {
//         return helper(0,nums.length-1,nums);
//     }
//     public int helper(int i,int j,int nums[])
//     {
//         if(i>j)
//         return 0;
//         int maxCost=Integer.MIN_VALUE;
//         for(int k=i;k<=j;k++)
//         {
//             int leftCost=1,rightCost=1,midCost=nums[k];
//             if(i-1>=0)
//             leftCost=nums[i-1];
//             if(j+1<nums.length)
//             rightCost=nums[j+1];
//             int cost=leftCost*midCost*rightCost+helper(i,k-1,nums)+helper(k+1,j,nums);
//             maxCost=Math.max(maxCost,cost);
//         }
//         return maxCost;
//     }
// }

// memooization on above approach

class Solution {
    public int maxCoins(int[] nums) {
        int dp[][]=new int[nums.length][nums.length];
        for(int temp[]:dp)
        Arrays.fill(temp,-1);
        return helper(0,nums.length-1,nums,dp);
    }
    public int helper(int i,int j,int nums[],int dp[][])
    {
        if(i>j)
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        int maxCost=Integer.MIN_VALUE;
        for(int k=i;k<=j;k++)
        {
            int leftCost=1,rightCost=1,midCost=nums[k];
            if(i-1>=0)
            leftCost=nums[i-1];
            if(j+1<nums.length)
            rightCost=nums[j+1];
            int cost=leftCost*midCost*rightCost+helper(i,k-1,nums,dp)+helper(k+1,j,nums,dp);
            maxCost=Math.max(maxCost,cost);
        }
        return dp[i][j]=maxCost;
    }
}