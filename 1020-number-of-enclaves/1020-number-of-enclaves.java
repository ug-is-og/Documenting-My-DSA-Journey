// we have done with the brute force approach right now, jo bhi dimaag mein aaya usse kar diya, optimize this later

class Solution {
    public int numEnclaves(int[][] grid) {
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                int temp[]=new int[1];
                boolean ans[]=new boolean[1];
                if(grid[i][j]==1&&!visited[i][j])
                {
                    visited[i][j]=true;
                    dfs(visited,grid,i,j,ans,temp);
                    if(ans[0]==false)
                    {
                        count=count+temp[0];
                    }
                }
            }
        }
        return count;
    }
    public void dfs(boolean visited[][],int grid[][],int i,int j,boolean ans[],int count[])
    {
        count[0]++;
        int rows[]={-1,0,1,0};
        int cols[]={0,1,0,-1};
        for(int k=0;k<rows.length;k++)
        {
            int row=rows[k]+i;
            int col=cols[k]+j;
            if(row<0||col<0||row==grid.length||col==grid[0].length)
            {
                ans[0]=true;
            }
            else
            {
                if(grid[row][col]==1&&!visited[row][col])
                {
                    visited[row][col]=true;
                    dfs(visited,grid,row,col,ans,count);
                }
            }
        }
    }
}