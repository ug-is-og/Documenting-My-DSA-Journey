//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maximumSumRectangle(N, M, a));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int maximumSumRectangle(int R, int C, int M[][]) {
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<C;i++)
        {
            int cumulativeSum[]=new int[R];
            for(int j=i;j<C;j++)
            {
                for(int k=0;k<R;k++)
                {
                    cumulativeSum[k]+=M[k][j];
                }
                maxSum=Math.max(maxSum,maxSubArraySum(cumulativeSum));
            }
        }
        return maxSum;
    }
     public int maxSubArraySum(int[] nums) {
        int currSum=0,maxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            currSum=currSum+nums[i];
            if(maxSum<currSum)
            maxSum=currSum;
            if(currSum<0)
            currSum=0;
        }
        return maxSum;
    }
};