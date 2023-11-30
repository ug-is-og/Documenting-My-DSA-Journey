// yahan pe tum elements ke saath deal kar re ho kyunki eventually woh specific element chahiye tha jo bada hai

// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         int nums[]=new int[nums1.length];
//         for(int i=0;i<nums1.length;i++)
//         {
//             for(int j=0;j<nums2.length;j++)
//             {
//                 if(nums1[i]==nums2[j])
//                 {
//                     //nums1[i]=j;// yeh badi critical galti hai , tumhe nayi array banani hi padegi
//                     nums[i]=j;
//                     System.out.print(nums[i]+" ");
//                 }
//             }
//         }
//         System.out.println();
//         Stack<Integer> stack=new Stack<>();
//         stack.push(nums2[nums2.length-1]);
//         nums2[nums2.length-1]=-1;
//         int temp;
//         for(int i=nums2.length-2;i>=0;i--)
//         {
//             while((!stack.isEmpty())&&stack.peek()<=nums2[i])
//             {
//                 stack.pop();
//             }
//             temp=nums2[i];
//             if(stack.isEmpty())
//             nums2[i]=-1;
//             else
//             nums2[i]=stack.peek();
//             stack.push(temp);
//         }
//         for(int i=0;i<nums.length;i++)
//         nums[i]=nums2[nums[i]];
//         for(int i=0;i<nums2.length;i++)
//         System.out.print(nums2[i]+" ");
//         return nums;
//     }
// }



















class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int temp[]=new int[nums2.length];
        int ans[]=new int[nums1.length];
       Stack<Integer> st=new Stack<>();
       for(int i=nums2.length-1;i>=0;i--)
       {
           while(!st.isEmpty()&&st.peek()<=nums2[i])
           {
               st.pop();
           }
           if(st.isEmpty())
           temp[i]=-1;
           else
           temp[i]=st.peek();
           st.push(nums2[i]);
       }
      for(int i=0;i<nums1.length;i++)
      {
          for(int j=0;j<nums2.length;j++)
          {
              if(nums1[i]==nums2[j])
              {
                  ans[i]=temp[j];
              }
          }
      }
       return ans;
    }
}