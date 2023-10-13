class data{
    int i,j,time;
    public data(int i,int j,int time)
    {
        this.i=i;
        this.j=j;
        this.time=time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<data> q=new LinkedList<>();
         boolean visited[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new data(i,j,0));
                    visited[i][j]=true;
                }
            }
        }
        int rows[]={-1,0,1,0};
        int cols[]={0,1,0,-1};
        int ansTime=0;
        while(!q.isEmpty())
        {
            data temp=q.remove();
            ansTime=Math.max(ansTime,temp.time);
            for(int i=0;i<rows.length;i++)
            {
                int row=rows[i]+temp.i;
                int col=cols[i]+temp.j;
                if(row<0||col<0||row>=grid.length||col>=grid[0].length||visited[row][col]==true||grid[row][col]==0)
                {
                    continue;
                }
                visited[row][col]=true;
                q.add(new data(row,col,temp.time+1));
            }
        }
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1&&visited[i][j]==false)
                {
                    return -1;
                }
            }
        }
        return ansTime;
    }
}