// better approach than previous submission, 
// if(count>n*n)  break;
// due to use of the above condition
// can also use this below condition but its not as good as the above condition
// if(b[r1][i]==0) b[r1][i]=k++;
// go through theaccepted submissions you'll get it'

class Solution {
    public int[][] generateMatrix(int n) {
        int r1=0,r2=n-1,c1=0,c2=n-1;
        int count=1;
        int ans[][]=new int[n][n];
        while(count<=n*n)
        {
            for(int i=c1;i<=c2;i++)
            {
                ans[r1][i]=count;
                count++;
            }
            if(count>n*n)
            break;
            for(int i=r1+1;i<=r2-1;i++)
            {
                ans[i][c2]=count;
                count++;
            }
            if(count>n*n)
            break;
            for(int i=c2;i>=c1;i--)
            {
                ans[r2][i]=count;
                count++;
            }
            if(count>n*n)
            break;
            for(int i=r2-1;i>=r1+1;i--)
            {
                ans[i][c1]=count;
                count++;
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }
}