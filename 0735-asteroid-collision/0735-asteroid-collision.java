// class Solution {
//     public int[] asteroidCollision(int[] asteroids) {
//         Stack<Integer> stack=new Stack<>();
//        ab: for(int i=0;i<asteroids.length;i++)
//         {
//             int curr=asteroids[i];
//             if(curr<0)
//             {
//                  while(!stack.isEmpty()&&stack.peek()>0)
//                  {
//                      if(stack.peek()<Math.abs(curr))
//                      {
//                          stack.pop();
//                      }
//                      else if(stack.peek()==Math.abs(curr))
//                      {
//                          stack.pop();
//                          continue ab;
//                      }
//                      else
//                      {
//                         continue ab;
//                      }
//                  }
//                  stack.push(curr); 
//             }
//             else
//             {
//                 stack.push(curr);
//             }
//         }
//         int ans[]=new int[stack.size()];
//         for(int i=0;i<stack.size();i++)
//         {
//             ans[i]=stack.get(i);
//         }
//         return ans;
//     }
// }
































class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<asteroids.length;i++)
        {
            if(asteroids[i]<0)
            {
                if(!st.isEmpty()&&st.peek()>0)
                {
                    if(st.peek()>Math.abs(asteroids[i]))
                    {
                        continue;
                    }
                    else if(st.peek()==Math.abs(asteroids[i]))
                    {
                        st.pop();
                    }
                    else
                    {
                        st.pop();
                        i--;
                    }
                }
                else
                {
                    st.push(asteroids[i]);
                }
            }
            else
            {
                st.push(asteroids[i]);
            }
        }
        int ans[]=new int[st.size()];
        for(int i=0;i<ans.length;i++)
        ans[ans.length-i-1]=st.pop();
        return ans;
    }
}