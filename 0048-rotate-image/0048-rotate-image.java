// iss question mein kewal itna yaad rakho ki transpose lagake karte hai kuch
// transpose matlab row ko column and column ko row se swap karna


// class Solution {
//     public void rotate(int[][] matrix) {
//         int temp=0;
//         int n=matrix[0].length;
//         // transpose of matrix
//         for(int i=0;i<matrix.length;i++)
//         {
//             for(int j=i+1;j<matrix.length;j++)
//             {
//                 temp=matrix[i][j];
//                 matrix[i][j]=matrix[j][i];
//                 matrix[j][i]=temp;
//             }
//         }
//         // horizonatally swap array elements
//         for(int i=0;i<n;i++)
//         {
//             for(int j=0;j<n/2;j++)
//             {
//                 temp=matrix[i][j];
//                 matrix[i][j]=matrix[i][n-1-j];
//                 matrix[i][n-1-j]=temp;
//             }
//         }
//     }
// }

















// class Solution {
//     public void rotate(int[][] matrix) {
//         int n=matrix.length;
//         // rotate horizonatally
//         for(int i=0;i<n/2;i++)
//         {
//             for(int j=0;j<n;j++)
//             {
//                 int temp=matrix[i][j];
//                 matrix[i][j]=matrix[n-1-i][j];
//                 matrix[n-1-i][j]=temp;
//             }
//         }
//         //find transpose
//         for(int i=0;i<n;i++)
//         {
//             for(int j=0;j<n;j++)
//             {
//                 if(j>i) 
//                 {
//                     int temp=matrix[i][j];
//                     matrix[i][j]=matrix[j][i];
//                     matrix[j][i]=temp;
//                 }
//             }
//         }
//     }
// }
























class Solution {
    public void rotate(int[][] matrix) {
        // transpose of the matrix from (i,j) to (j,i)
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                if(i<j)
                {
                    int temp=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                }
            }
        }
        // swap columns
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length/2;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][matrix[0].length-1-j];
                matrix[i][matrix[0].length-1-j]=temp;
            }
        }
    }
}
