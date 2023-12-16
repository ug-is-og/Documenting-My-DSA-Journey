// Prerequisite : Largest area of rectangle in a histogram (Leetcode : 84)

// class Solution {
//     public int maximalRectangle(char[][] matrix) {
//         int max=Integer.MIN_VALUE;
//         // char to int conversion matrix
//         int mat[][]=new int[matrix.length][matrix[0].length];
//         for(int i=0;i<matrix.length;i++)
//         {
//             for(int j=0;j<matrix[0].length;j++)
//             {
//                 mat[i][j]=matrix[i][j]-'0';
//             }
//         }
//         for(int i=0;i<matrix.length;i++)
//         {
//             for(int j=0;j<matrix[0].length;j++)
//             {
//                 if(i!=0)
//                 {
//                     if(mat[i][j]!=0)
//                     mat[i][j]=mat[i][j]+mat[i-1][j];
//                 }
//             }
//             max=Math.max(max,leetCode84(mat[i]));
//         }
//         return max;
//     }
//     public int leetCode84(int[] heights) 
//     {
//         Stack<Integer> st=new Stack<>();
//         int leftSmall[]=new int[heights.length];
//         int rightSmall[]=new int[heights.length];
//         int max=Integer.MIN_VALUE;
//         for(int i=0;i<heights.length;i++)
//         {
//             while(!st.isEmpty()&&heights[st.peek()]>=heights[i])
//             {
//                 st.pop();
//             }
//             if(st.isEmpty())
//             leftSmall[i]=0;
//             else
//             leftSmall[i]=st.peek()+1;
//             st.push(i);
//         }
//         while(!st.isEmpty())
//         st.pop();
//         for(int i=heights.length-1;i>=0;i--)
//         {
//             while(!st.isEmpty()&&heights[st.peek()]>=heights[i])
//             st.pop();
//             if(st.isEmpty())
//             rightSmall[i]=heights.length-1;
//             else
//             rightSmall[i]=st.peek()-1;
//             st.push(i);
//         }
//         for(int i=0;i<heights.length;i++)
//         {
//             max=Math.max(max,heights[i]*(rightSmall[i]-leftSmall[i]+1));
//         }
//         return max;
//     }
// }




















class Solution {
    public int maximalRectangle(char[][] matrix) {
        int heights[][]=new int[matrix.length][matrix[0].length];
        // build your heights array
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(i==0)
                {
                    if(matrix[i][j]=='1')
                    heights[i][j]=1;
                    continue;
                }
                if(matrix[i][j]!='0')
                {
                    heights[i][j]=heights[i-1][j]+1;
                }
            }
        }
        // find the largest rectangle
        int max=Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++)
        {
            max=Math.max(max,helper(heights,i));
        }
        return max;
    }
    public int helper(int matrix[][],int i)
    {
        int NSL[]=new int[matrix[0].length];
        int NSR[]=new int[matrix[0].length];
        buildNSL(NSL,matrix,i);
        buildNSR(NSR,matrix,i);
        int ans=Integer.MIN_VALUE;
        for(int k=0;k<matrix[0].length;k++)
        {
            ans=Math.max(ans,(NSR[k]-NSL[k]-1)*matrix[i][k]);
        }
        return ans;
    }
    public void buildNSL(int NSL[],int matrix[][],int i)
    {
        Stack<Integer> st=new Stack<>();
        for(int k=0;k<matrix[0].length;k++)
        {
            while(!st.isEmpty()&&matrix[i][st.peek()]>=matrix[i][k])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                NSL[k]=-1;
            }
            else
            {
                NSL[k]=st.peek();
            }
            st.push(k);
        }
    }
    public void buildNSR(int NSR[],int matrix[][],int i)
    {
        Stack<Integer> st=new Stack<>();
        for(int k=matrix[0].length-1;k>=0;k--)
        {
            while(!st.isEmpty()&&matrix[i][st.peek()]>=matrix[i][k])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                NSR[k]=matrix[0].length;
            }
            else
            {
                NSR[k]=st.peek();
            }
            st.push(k);
        }
    }
}