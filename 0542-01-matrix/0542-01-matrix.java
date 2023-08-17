// iss code mein kewal ek bhot chhoti si insight hai jo pura ques solve kar degi and that is
// kisi bhi cell se nearest 0 tak pahuchne ki distance = nearest cell containing 0 se uss cell tak pahuchne ki distance. 
// toh agar ham saare cells containing 0 ko queue mein bharde aur ek ek baar chalaye dist+1 karte jaaye toh jis bhi cell pe pahuchte jayenge(that are not previously visited), uss point pe jo distance hai wahi hai distance of nearest 0 for that cell
// clear indication of BFS

class bfs{
    int first;
    int second;
    int distance;
    public bfs(int first,int second,int distance)
    {
        this.first=first;
        this.second=second;
        this.distance=distance;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<bfs> q=new LinkedList<>();
        boolean visited[][]=new boolean[mat.length][mat[0].length];
        int dist[][]=new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==0)
                q.add(new bfs(i,j,0));
                else
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        int row[]={-1,0,1,0};
        int col[]={0,1,0,-1};
        // bfs
        while(!q.isEmpty())
        {
            bfs temp=q.remove();
            if(!visited[temp.first][temp.second])
            {
                dist[temp.first][temp.second]=temp.distance;
                visited[temp.first][temp.second]=true;
                for(int i=0;i<4;i++)
                {
                    int newRow=row[i]+temp.first;
                    int newCol=col[i]+temp.second;
                    if(newRow>=0&&newCol>=0&&newRow<mat.length&&newCol<mat[0].length&&!visited[newRow][newCol])
                    q.add(new bfs(newRow,newCol,temp.distance+1));
                }
            }
        }
        return dist;
    }
}