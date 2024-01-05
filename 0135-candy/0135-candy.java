// NeetCode solution is the best
// https://www.youtube.com/watch?v=1IzCRCcK17A

class Solution {
    public int candy(int[] ratings) {
        int candies[]=new int[ratings.length];
        int sum=0;
        // handling the left neighbour part
        for(int i=0;i<ratings.length;i++)
        {
            if(i==0)
            {
                candies[i]=1;
            }
            else
            {
                if(ratings[i]>ratings[i-1])
                {
                    candies[i]=candies[i-1]+1;
                }
                else
                {
                    candies[i]=1;
                }
            }
        }
        // handling the right neighbour part
        for(int i=candies.length-2;i>=0;i--)
        {
            if(ratings[i]>ratings[i+1]&&candies[i]<=candies[i+1])
            {
                candies[i]=candies[i+1]+1;
            }
        }
        for(int a:candies)
        {
            sum+=a;
        }
        return sum;
    }
}