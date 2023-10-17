// class Solution {
//     public void solve(char[][] board) {
//         boolean visited[][]=new boolean[board.length][board[0].length];
//         for(int i=0;i<board.length;i++)
//         {
//             for(int j=0;j<board[0].length;j++)
//             {
//                 if(!visited[i][j])
//                 {
//                     visited[i][j]=true;
//                     boolean check[]=new boolean[1];
//                     if(board[i][j]=='O')
//                     {
//                         if(i==0||i==board.length-1||j==0||j==board[0].length-1)
//                         {
//                             check[0]=true;
//                         }
//                         board[i][j]='X';
//                         dfs(i,j,board,visited,check);
//                         if(check[0]==true)
//                         {
//                             board[i][j]='O';
//                         }
//                     }
//                 }
//             }
//         }
//     }
//     public void dfs(int i,int j,char board[][],boolean visited[][],boolean check[])
//     {
//         int rows[]={-1,0,1,0};
//         int cols[]={0,1,0,-1};
//         for(int k=0;k<4;k++)
//         {
//             int row=rows[k]+i;
//             int col=cols[k]+j;
//             if(row>=0&&col>=0&&row<=board.length-1&&col<=board[0].length-1&&board[row][col]=='O'&&!visited[row][col]) 
//             {
//                 visited[row][col]=true;
//                 board[row][col]='X';
//                 if(row==0||col==0||row==board.length-1||col==board[0].length-1)
//                 {
//                     check[0]=true;
//                 }
//                 dfs(row,col,board,visited,check);
//                 if(check[0]==true)
//                 {
//                     board[row][col]='O';
//                 }
//             }
//         }
//     }
// }


// upar (pehli) wali approach mein socha tha ki ek saath saara kaam ho jayega matlab pehle sabko O to X mark kar diya fir wapas aate huye check kar liye ki kahi check[0] true toh nahi matlab boundary element mila kya, agar mila toh wapas se O mein convert kar diya jinko X kiya tha, par iss approach mein ek dikkat hai , tum saare O jinko X mark kara tha temporarily waapas O mein convert nahi kar paoge ....analyze this test case with above code samajh jaoge....

// toh iss liye hamne socha ki ek list rakh lete hai apne pas to keep a track of all (row,col) pairs jinko o to X mark kar re and end mein agar check[0] mil gaya toh saare pairs ko ek main list mein store karte jayenge and bilkul end mein update kar denge wapni board array ko

class pair{
    int row,col;
    public pair(int row,int col)
    {
        this.row=row;
        this.col=col;
    }
}

class Solution {
    public void solve(char[][] board) {
        boolean visited[][]=new boolean[board.length][board[0].length];
        List<pair> ans=new ArrayList<>();
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                List<pair> temp=new ArrayList<>();
                if(!visited[i][j])
                {
                    visited[i][j]=true;
                    boolean check[]=new boolean[1];
                    if(board[i][j]=='O')
                    {
                        temp.add(new pair(i,j));
                        board[i][j]='X';
                        if(i==0||i==board.length-1||j==0||j==board[0].length-1)
                        {
                            check[0]=true;
                        }
                        dfs(i,j,board,visited,check,temp);
                        if(check[0]==true)
                        {
                            ans.addAll(temp);
                        }
                    }
                }
            }
        }
        for(int i=0;i<ans.size();i++)
        {
            board[ans.get(i).row][ans.get(i).col]='O';
        }
    }
    public void dfs(int i,int j,char board[][],boolean visited[][],boolean check[],List<pair> temp)
    {
        int rows[]={-1,0,1,0};
        int cols[]={0,1,0,-1};
        for(int k=0;k<4;k++)
        {
            int row=rows[k]+i;
            int col=cols[k]+j;
            if(row>=0&&col>=0&&row<=board.length-1&&col<=board[0].length-1&&board[row][col]=='O'&&!visited[row][col]) // yahan row<board.length-1 and col<board[0].length-1 likh rakha tha jiski wajah se galat ans aaya and ek = ki wajah se aadha ghanta waste hua, be very careful
            {
                visited[row][col]=true;
                temp.add(new pair(row,col));
                board[row][col]='X';
                if(row==0||col==0||row==board.length-1||col==board[0].length-1)
                {
                    check[0]=true;
                }
                dfs(row,col,board,visited,check,temp);
            }
        }
    }
}