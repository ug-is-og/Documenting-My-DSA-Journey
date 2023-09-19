// Prerequisite : Largest area of rectangle in a histogram (Leetcode : 84)

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max=Integer.MIN_VALUE;
        // char to int conversion matrix
        int mat[][]=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                mat[i][j]=matrix[i][j]-'0';
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(i!=0)
                {
                    if(mat[i][j]!=0)
                    mat[i][j]=mat[i][j]+mat[i-1][j];
                }
            }
            max=Math.max(max,leetCode84(mat[i]));
        }
        return max;
    }
    public int leetCode84(int[] heights) 
    {
        Stack<Integer> st=new Stack<>();
        int leftSmall[]=new int[heights.length];
        int rightSmall[]=new int[heights.length];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++)
        {
            while(!st.isEmpty()&&heights[st.peek()]>=heights[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            leftSmall[i]=0;
            else
            leftSmall[i]=st.peek()+1;
            st.push(i);
        }
        while(!st.isEmpty())
        st.pop();
        for(int i=heights.length-1;i>=0;i--)
        {
            while(!st.isEmpty()&&heights[st.peek()]>=heights[i])
            st.pop();
            if(st.isEmpty())
            rightSmall[i]=heights.length-1;
            else
            rightSmall[i]=st.peek()-1;
            st.push(i);
        }
        for(int i=0;i<heights.length;i++)
        {
            max=Math.max(max,heights[i]*(rightSmall[i]-leftSmall[i]+1));
        }
        return max;
    }
}