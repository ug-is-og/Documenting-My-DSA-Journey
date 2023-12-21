

// class Solution {
//     public List<Integer> spiralOrder(int[][] matrix) {
//         List<Integer> ans=new ArrayList<>();
//         int target=matrix.length*matrix[0].length;
//         int count=0,r1=0,r2=matrix.length-1,c1=0,c2=matrix[0].length-1;
//         while(count<target)
//         {
//             for(int i=c1;i<=c2;i++)
//             {
//                 ans.add(matrix[r1][i]);
//                 count++;
//             }
//             if(count==target)
//             break;
//             for(int i=r1+1;i<=r2;i++)
//             {
//                 ans.add(matrix[i][c2]);
//                 count++;
//             }
//             if(count==target)
//             break;
//             for(int i=c2-1;i>=c1;i--)
//             {
//                 ans.add(matrix[r2][i]);
//                 count++;
//             }
//             if(count==target)
//             break;
//             for(int i=r2-1;i>=r1+1;i--)
//             {
//                 ans.add(matrix[i][c1]);
//                 count++;
//             }
//             r1++;
//             r2--;
//             c1++;
//             c2--;
//         }
//         return ans;
//     }
// }






















// Also keep in mind this approach told by striver
// https://youtu.be/3Zv-s9UUrFM

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int top=0,bottom=matrix.length-1,left=0,right=matrix[0].length-1;
        while(top<=bottom&&left<=right)
        {
            for(int i=left;i<=right;i++)
            {
                ans.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++)
            {
                ans.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom) // need to ensure that we have a row left
            {
                 for(int i=right;i>=left;i--)
                {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right) // we need to ensure that we have a column left
            {
                for(int i=bottom;i>=top;i--)
                {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}