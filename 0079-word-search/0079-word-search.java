// Brute Approach (302 ms) \U0001f631
// really a brute force approach
// purely done throgh dfs
// leave it, don't optimize further, approach yahi lagani hai

class Solution {
    public boolean exist(char[][] board, String word) {
        boolean visited[][]=new boolean[board.length][board[0].length];
        boolean ans=false;
        for(int i=0;i<visited.length;i++)
        {
            for(int j=0;j<visited[0].length;j++)
            {
                if(word.charAt(0)==board[i][j]) // we added this optimization here to avoid unnecessary calls
                ans=ans||helper(i,j,board,word,visited);
            }
        }
        return ans;
    }
    public boolean helper(int i,int j,char board[][],String word,boolean visited[][])
    {
        if(word.length()==0)
        return true;
        if(i<0||j<0||i==board.length||j==board[0].length||visited[i][j]==true||word.charAt(0)!=board[i][j])
        return false;
        visited[i][j]=true;
        String temp=word.substring(1);
        int row[]={0,-1,0,1};
        int col[]={1,0,-1,0};
        boolean ans=false;
        for(int k=0;k<4;k++)
        {
            int newRow=i+row[k];
            int newCol=j+col[k];
            ans=ans||helper(newRow,newCol,board,temp,visited);
        }
        visited[i][j]=false;
        return ans;
    }
}

