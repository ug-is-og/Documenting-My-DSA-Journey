// dfs and backtracking are same bas batane ka tareeka alag alag hai

// backtracking approach

// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         int visited[][]=new int[image.length][image[0].length];
//         helper(image,visited,sr,sc,color,image[sr][sc]);
//         return image;
//     }
//     public void helper(int image[][],int visited[][],int i,int j,int color,int prevColor)
//     {
//         if(i<0||j<0||i>=image.length||j>=image[0].length||visited[i][j]==1||image[i][j]!=prevColor)
//         return ;
//         visited[i][j]=1;
//         if(image[i][j]==prevColor)
//         image[i][j]=color;
//         //right direction
//         helper(image,visited,i,j+1,color,prevColor);
//         //left direction
//         helper(image,visited,i,j-1,color,prevColor);
//         //top direction
//         helper(image,visited,i-1,j,color,prevColor);
//         //bottom direction
//         helper(image,visited,i+1,j,color,prevColor);
//     }
// }

// DFS approach

// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color){
//         int visited[][]=new int[image.length][image[0].length];
//         for(int i=0;i<image.length;i++)
//         {
//             for(int j=0;j<image[0].length;j++)
//             visited[i][j]=image[i][j];
//         }
//         helper(image,visited,sr,sc,color,image[sr][sc]);
//         return visited;
//     }
//     public void helper(int image[][],int visited[][],int sr,int sc,int color,int prevColor)
//     {
//         visited[sr][sc]=color;
//         int row[]={-1,0,1,0};
//         int col[]={0,1,0,-1};
//         for(int k=0;k<4;k++)
//         {
//             int nrow=sr+row[k];
//             int ncol=sc+col[k];
//             if(nrow>=0&&ncol>=0&&nrow<image.length&&ncol<image[0].length&&image[nrow][ncol]==prevColor&&visited[nrow][ncol]!=color)
//             helper(image,visited,nrow,ncol,color,prevColor);
//         }
//     }
// }























// we can use bfs or dfs both, both will be applicable

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color){
        int ans[][]=new int[image.length][image[0].length];
        for(int i=0;i<ans.length;i++)
        {
            for(int j=0;j<ans[0].length;j++)
            {
                ans[i][j]=image[i][j];
            }
        }
        boolean visited[][]=new boolean[image.length][image[0].length];
        visited[sr][sc]=true;
        dfs(sr,sc,visited,ans,image,image[sr][sc],color);
        return ans;
    }
    public void dfs(int sr,int sc,boolean visited[][],int ans[][],int image[][],int mainColor,int color)
    {
        ans[sr][sc]=color;
        int rows[]={-1,0,1,0};
        int cols[]={0,-1,0,1};
        for(int i=0;i<rows.length;i++)
        {
            int row=rows[i]+sr;
            int col=cols[i]+sc;
            if(row<0||col<0||row>=image.length||col>=image[0].length||visited[row][col]==true||image[row][col]!=mainColor)
            {
                continue;
            }
            visited[row][col]=true;
            dfs(row,col,visited,ans,image,mainColor,color);
        }
    }
}