class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[][]=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int temp[]:dp)
        Arrays.fill(temp,-1);
        return helper(0,0,obstacleGrid,dp);
    }
    public int helper(int i,int j,int obstacleGrid[][],int dp[][])
    {
        // &&obstacleGrid[i][j]==0 likhna bhul gye the, bhai mere last cell tak pahuch gaye
        // par zaruri nahi ki last cell safe ho hamari ya wahan pe koi obstacle na ho, toh tumhe check karna padega
        if(i==obstacleGrid.length-1&&j==obstacleGrid[0].length-1&&obstacleGrid[i][j]==0)
        return 1;
        if(i<0||j<0||i>=obstacleGrid.length||j>=obstacleGrid[0].length||obstacleGrid[i][j]==1)
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        return dp[i][j]=helper(i,j+1,obstacleGrid,dp)+helper(i+1,j,obstacleGrid,dp);
    }
}