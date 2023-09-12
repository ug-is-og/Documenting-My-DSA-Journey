class Solution {
    public int[] findBall(int[][] grid) {
        int arr[]=new int[grid[0].length];
        for(int i=0;i<grid[0].length;i++)
        {
            arr[i]=helper(i,grid,0);
        }
        return arr;
    }
    public int helper(int i,int grid[][],int index)
    {
        int m=grid.length;
        int n=grid[0].length;
        if(index==grid.length)
        {
            return i;
        }
        int ans=0;
        if(grid[index][i]==1)
        {
            if(i==n-1)
            {
                return -1;
            }
            else
            {
                if(grid[index][i+1]==1)
                ans=helper(i+1,grid,index+1);
                else
                return -1;
            }
        }
        else
        {
            if(i==0)
            {
                return -1;
            }
            else
            {
                if(grid[index][i-1]==-1)
                ans=helper(i-1,grid,index+1);
                else
                return -1;
            }
        }
        return ans;
    }
}