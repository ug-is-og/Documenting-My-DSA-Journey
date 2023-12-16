// Recursive + Memoization approach se partially accept ho ra (f(i,j) ka standard approach use kiya tha partial sum)

// class Solution {
//     public int maxSumAfterPartitioning(int[] arr, int k) {
//         int dp[][]=new int[arr.length][arr.length];
//         for(int temp[]:dp)
//         Arrays.fill(temp,-1);
//         return helper(0,arr.length-1,k,arr,dp);
//     }
//     public int helper(int i,int j,int k,int arr[],int dp[][])
//     {
//         int max1=Integer.MIN_VALUE;
//         if(j-i+1<=k)
//         {
//             for(int p=i;p<=j;p++)
//             max1=Math.max(max1,arr[p]);
//             return max1*(j-i+1);
//         }
//         if(dp[i][j]!=-1)
//         return dp[i][j];
//         int max2=Integer.MIN_VALUE;
//         int ans=0;
//         for(int p=i;p<j;p++)
//         {
//             ans=helper(i,p,k,arr,dp)+helper(p+1,j,k,arr,dp);
//             max2=Math.max(max2,ans);
//         }
//         return dp[i][j]=max2;
//     }
// }

// whole new approach using fornt partition by Striver
// recursive + memoization approach


// class Solution {
//     public int maxSumAfterPartitioning(int[] arr, int k) {
//         int dp[]=new int[arr.length];
//         Arrays.fill(dp,-1);
//         return helper(0,arr,k,dp);
//     }
//     public int helper(int i,int arr[],int k,int dp[]){
//         if(i==arr.length)
//         return 0;
//         if(dp[i]!=-1)
//         return dp[i];
//         int max=Integer.MIN_VALUE;
//         int maxAns=Integer.MIN_VALUE;
//         int ans=0;
//         for(int j=i;j<i+k&&j<arr.length;j++)
//         {
//             max=Math.max(max,arr[j]);
//             ans=max*(j-i+1)+helper(j+1,arr,k,dp);
//             maxAns=Math.max(maxAns,ans);
//         }
//         System.out.println(i+" "+maxAns);
//         return dp[i]=maxAns;
//     }
// }



// Great this is highly optimized approach

// class Solution {
//     public int maxSumAfterPartitioning(int[] arr, int k) {
//         int dp[]=new int[arr.length+1];
//         Arrays.fill(dp,-1);
//         return helper(arr,0,dp,k);
//     }
//     public int helper(int arr[],int index,int dp[],int k)
//     {
//         if(index==arr.length)
//         {
//             return 0;
//         }
//         if(dp[index]!=-1)
//         {
//             return dp[index];
//         }
//         int maxScore=Integer.MIN_VALUE;
//         int max=Integer.MIN_VALUE;
//         for(int i=index;i<=index+k-1;i++)
//         {
//             if(i<arr.length)
//             {
//                 max=Math.max(max,arr[i]);
//                 maxScore=Math.max(maxScore,max*(i-index+1)+helper(arr,i+1,dp,k));
//             }
//         }
//         return dp[index]=maxScore;
//     }
// }





















class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[]=new int[arr.length];
        Arrays.fill(dp,-1);
        return helper(dp,0,k,arr);
    }
    public int helper(int dp[],int index,int k,int arr[])
    {
        if(index>=arr.length)
        {
            return 0;
        }
        if(dp[index]!=-1)
        {
            return dp[index];
        }
        int ans=0,max=0;
        for(int i=index;i<Math.min(index+k,arr.length);i++)
        {
            max=Math.max(max,arr[i]);
            ans=Math.max(ans,(i-index+1)*max+helper(dp,i+1,k,arr));
        }
        return dp[index]=ans;
    }
}

