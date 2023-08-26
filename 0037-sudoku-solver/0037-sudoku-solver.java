// keep up the great work bhai, you finally did it

class Solution {
    public void solveSudoku(char[][] board) {
        char newBoard[][]=new char[board.length][board[0].length];
        helper(0,0,board,newBoard);
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            board[i][j]=newBoard[i][j];
        }
    }
    public void helper(int i,int j,char board[][],char newBoard[][])
    {
        if(i==board.length)
        {
            for(int i1=0;i1<board.length;i1++)
            {
                for(int j1=0;j1<board[0].length;j1++)
                newBoard[i1][j1]=board[i1][j1];
            }
            return;
        }
        if(j==board[0].length)
        {
            helper(i+1,0,board,newBoard);
            return;
        }
        char ch=board[i][j];
        if(ch!='.')
        {
            helper(i,j+1,board,newBoard);
            return;
        }
        for(int k=0;k<9;k++)
        {
            board[i][j]=(char)(k+1+'0');
            if(safe(i,j,board))
            helper(i,j+1,board,newBoard);
            board[i][j]='.';
        }
    }
    public boolean safe(int i,int j,char board[][])
    {
        List<Integer> rowList=new ArrayList<>();
        for(int i1=0;i1<9;i1++)
        rowList.add(i1+1);
        List<Integer> columnList=new ArrayList<>(rowList);
        List<Integer> section=new ArrayList<>(rowList);
        // check that row
        for(int col=0;col<board[0].length;col++)
        {
            if(board[i][col]!='.')
            {
                if(rowList.contains(board[i][col]-'0'))
            rowList.remove(Integer.valueOf(board[i][col]-'0'));
            else
            {
                System.out.println(rowList);
                 return false;
            }
            }
        }
        // check that column
        for(int row=0;row<board[0].length;row++)
        {
            if(board[row][j]!='.')
            {
                if(columnList.contains(board[row][j]-'0'))
            columnList.remove(Integer.valueOf(board[row][j]-'0'));
            else
            return false;
            }
        }
        // check that section
        int rowSection[]={0,3,6,10};
        int colSection[]={0,3,6,10};
        for(int i1=0;i1<rowSection.length-1;i1++)
        {
            for(int j1=0;j1<colSection.length-1;j1++)
            {
                if(i>=rowSection[i1]&&i<rowSection[i1+1]&&j>=colSection[j1]&&j<colSection[j1+1])
                {
                    for(int i3=rowSection[i1];i3<rowSection[i1]+3;i3++)
                    {
                        for(int j3=colSection[j1];j3<colSection[j1]+3;j3++)
                        {
                            if(board[i3][j3]!='.')
                            {
                                if(section.contains(board[i3][j3]-'0'))
                            section.remove(Integer.valueOf(board[i3][j3]-'0'));
                            else
                            return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}