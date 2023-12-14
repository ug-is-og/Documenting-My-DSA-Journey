// https://youtu.be/0ytpZyiZFhA
class cellData{
    int diff,row,col;
    public cellData(int diff,int row,int col)
    {
        this.diff=diff;
        this.row=row;
        this.col=col;
    }
}
class ordering implements Comparator<cellData>{
    public int compare(cellData a,cellData b)
    {
        return a.diff-b.diff;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int distance[][]=new int[heights.length][heights[0].length];
        int ans=0;
        for(int temp[]:distance)
        {
            Arrays.fill(temp,(int)1e9);
        }
        distance[0][0]=0;
        PriorityQueue<cellData> pq=new PriorityQueue<>(new ordering());
        pq.add(new cellData(0,0,0));
        while(!pq.isEmpty())
        {
            cellData temp=pq.remove();
            if(temp.row==heights.length-1&&temp.col==heights[0].length-1)
            {
                ans=temp.diff;
                break;
            }
            int rows[]={1,0,-1,0};
            int cols[]={0,1,0,-1};
            for(int i=0;i<4;i++)
            {
                int row=rows[i]+temp.row;
                int col=cols[i]+temp.col;
                if(row>=0&&row<heights.length&&col>=0&&col<heights[0].length)
                {
                    int diff=Math.max(Math.abs(heights[row][col]-heights[temp.row][temp.col]),temp.diff);
                    if(distance[row][col]>diff)
                    {
                        distance[row][col]=diff;
                        pq.add(new cellData(diff,row,col));
                    }
                }
            }
        }
        return ans;
    }
}