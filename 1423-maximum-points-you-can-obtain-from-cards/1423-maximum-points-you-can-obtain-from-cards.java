class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int totalSum=0,windowSum=0,minSum=Integer.MAX_VALUE;
        int n=cardPoints.length,i=0,j=0;
        // find total sum of all elements in array
        for(i=0;i<cardPoints.length;i++)
        {
            totalSum+=cardPoints[i];
        }
        i=0;
        // find minimum subarray sum of size n-k
        if(n-k==0)
        {
            minSum=0;
        }
        else // kyunki neeche wale while loop se ham >=1 window size se deal kar re
        {
            while(j<n)
            {
                windowSum+=cardPoints[j];
                if(j-i+1==n-k)
                {
                    minSum=Math.min(minSum,windowSum);
                    windowSum=windowSum-cardPoints[i];
                    i++;
                }
                j++;
            }
        }
        return totalSum-minSum;
    }
}