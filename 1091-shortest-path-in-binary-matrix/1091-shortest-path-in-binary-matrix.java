class cellData{
    int row,col,cost;
    public cellData(int row,int col,int cost)
    {
        this.row=row;
        this.col=col;
        this.cost=cost;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1)
        return -1;
        Queue<cellData> q=new LinkedList<>();
        int distance[][]=new int[grid.length][grid[0].length]; // yeh banani hi padegi, nahi banaoge toh stack overflow kyunki infinite recursive calls ho jayengi sochna dhyan se...(0,0) se (0,1) gaye fir (0,1) se (0,0) aa jaoge and recursive loop mein fas jaoge
        for(int temp[]:distance) 
        {
            Arrays.fill(temp,(int)1e9);
        }
        distance[0][0]=0;
        q.add(new cellData(0,0,0));
        int ans=-1;
        while(!q.isEmpty())
        {
            cellData temp=q.remove();
            if(temp.row==grid.length-1&&temp.col==grid[0].length-1)
            {
                ans=temp.cost;
                break;
            }
            int rows[]={-1,-1,-1,0,0,1,1,1};
            int cols[]={0,1,-1,1,-1,-1,1,0};
            for(int i=0;i<8;i++)
            {
                int row=temp.row+rows[i];
                int col=temp.col+cols[i];
                if(row>=0&&row<=grid.length-1&&col>=0&&col<=grid[0].length-1&&grid[row][col]==0&&temp.cost+1<distance[row][col])
                {
                    distance[row][col]=temp.cost+1;
                    q.add(new cellData(row,col,temp.cost+1));
                }
            }
        }
        if(ans==-1)
        return ans;
        return ans+1; // agar -1 nahi hai toh matlab path mil gaya hai ab isme+1 karke no of nodes in that path mil jayenge
    }
}