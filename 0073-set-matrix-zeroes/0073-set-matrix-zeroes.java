// This is O(m+n) solution and not the most optimized one

// class Solution {
//     public void setZeroes(int[][] matrix) {
//         int row[]=new int[matrix.length];
//         int column[]=new int[matrix[0].length];
//         for(int i=0;i<matrix.length;i++)
//         {
//             for(int j=0;j<matrix[0].length;j++)
//             {
//                 if(matrix[i][j]==0)
//                 {
//                     row[i]=1;
//                     column[j]=1;
//                 }
//             }
//         }
//         for(int i=0;i<matrix.length;i++)
//         {
//             for(int j=0;j<matrix[0].length;j++)
//             {
//                 if(row[i]==1||column[j]==1)
//                 matrix[i][j]=0;
//             }
//         }
//     }
// }

// Let's do it in place

// class Solution {
// public void setZeroes(int[][] matrix) {
//     int col0=1;
//     int m=matrix.length;
//     int n=matrix[0].length;
//     for(int i=0;i<matrix.length;i++)
//     {
//         for(int j=0;j<matrix[0].length;j++)
//         {
//             if(matrix[i][j]==0)
//             {
//                 if(j==0)
//                 {
//                     col0=0;
//                 }
//                 else
//                 {
//                     matrix[0][j]=0;
//                 }
//                 matrix[i][0]=0;
//             }
//         }
//     }
//      for(int i=1;i<m;i++)
//         {
//             for(int j=1;j<n;j++)
//             {
//                 if(matrix[i][0]==0||matrix[0][j]==0)
//                 matrix[i][j]=0;
//             }
//         }
//         if(matrix[0][0]==0)
//         {
//             for(int j=0;j<n;j++)
//             matrix[0][j]=0;
//         }
//         if(col0==0)
//         {
//             for(int i=0;i<m;i++)
//             matrix[i][0]=0;
//         }
// }
// }






















class Solution {
    public void setZeroes(int[][] matrix) {
        int firstRowZero=0,firstColZero=0;
        for(int j=0;j<matrix[0].length;j++)
        {
            if(matrix[0][j]==0)
            {
                firstRowZero++;
                break;
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
            if(matrix[i][0]==0)
            {
                firstColZero++;
                break;
            }
        }
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[0].length;j++)
            {
                if(matrix[i][0]==0||matrix[0][j]==0)
                {
                    matrix[i][j]=0;
                }
            }
        }
        if(firstRowZero>0)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                matrix[0][j]=0;
            }
        }
        if(firstColZero>0)
        {
            for(int i=0;i<matrix.length;i++)
            {
                matrix[i][0]=0;
            }
        }
    }
}