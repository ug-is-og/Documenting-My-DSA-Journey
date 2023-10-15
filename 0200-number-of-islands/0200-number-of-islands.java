// class Solution {
//     public int numIslands(char[][] grid) {
//         boolean visited[][]=new boolean[grid.length][grid[0].length];
//         int count=0;
//         for(int i=0;i<grid.length;i++)
//         {
//             for(int j=0;j<grid[0].length;j++)
//             {
//                 if(grid[i][j]=='1'&&!visited[i][j])
//                 {
//                      count++;
//                      dfs(grid,visited,i,j);
//                 }
//             }
//         }
//         return count;
//     }
//     public void dfs(char grid[][],boolean visited[][],int i,int j)
//     {
//         if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0'||visited[i][j]==true)
//         return;
//         visited[i][j]=true;
//         //right move
//         dfs(grid,visited,i,j+1);
//         //bottom move
//         dfs(grid,visited,i+1,j);
//         //left move
//         dfs(grid,visited,i,j-1);
//         //top move
//         dfs(grid,visited,i-1,j);
//     }
// }

// dfs approach

class Solution {
    public int numIslands(char[][] grid) {
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1'&&!visited[i][j])
                {
                    visited[i][j]=true;
                    count++;
                    dfs(visited,grid,i,j);
                }
            }
        }
        return count;
    }
    public void dfs(boolean visited[][],char grid[][],int i,int j)
    {
        int rows[]={-1,0,1,0};
        int cols[]={0,1,0,-1};
        for(int k=0;k<rows.length;k++)
        {
            int row=rows[k]+i;
            int col=cols[k]+j;
            if(row>=0&&row<grid.length&&col>=0&&col<grid[0].length&&grid[i][j]=='1'&&!visited[row][col])
            {
                visited[row][col]=true;
                dfs(visited,grid,row,col);
            }
        }
    }
}

