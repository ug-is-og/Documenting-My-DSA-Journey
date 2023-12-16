// class Solution {
//     public int largestRectangleArea(int[] heights) {
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
    public int largestRectangleArea(int[] heights) {
        int NSL[]=new int[heights.length];
        int NSR[]=new int[heights.length];
        buildNSL(NSL,heights);
        buildNSR(NSR,heights);
        int ans=Integer.MIN_VALUE;
        for(int k=0;k<heights.length;k++)
        {
            ans=Math.max(ans,(NSR[k]-NSL[k]-1)*heights[k]);
        }
        return ans;
    }
    public void buildNSL(int NSL[],int heights[])
    {
        Stack<Integer> st=new Stack<>();
        for(int k=0;k<heights.length;k++)
        {
            while(!st.isEmpty()&&heights[st.peek()]>=heights[k])
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
    public void buildNSR(int NSR[],int heights[])
    {
        Stack<Integer> st=new Stack<>();
        for(int k=heights.length-1;k>=0;k--)
        {
            while(!st.isEmpty()&&heights[st.peek()]>=heights[k])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                NSR[k]=heights.length;
            }
            else
            {
                NSR[k]=st.peek();
            }
            st.push(k);
        }
    }
}