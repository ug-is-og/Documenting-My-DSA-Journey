// class Solution {

//     public int[] maxSlidingWindow(int[] nums,int k){
//         Stack<Integer> stack=new Stack<>();
//         //stack stores next greater element to the right
//         stack.push(nums.length-1);
//         int right[]=new int[nums.length];
//         int max[]=new int[nums.length-k+1];
//         right[nums.length-1]=nums.length;
//         // filling indexes of next greater element to the right
//         for(int i=nums.length-2;i>=0;i--)
//         {
//             while((!stack.isEmpty())&&nums[stack.peek()]<=nums[i])
//             {
//                 stack.pop();
//             }
//             if(stack.isEmpty())
//             right[i]=nums.length;
//             else
//             right[i]=stack.peek();
//             stack.push(i);
//         }
//         // just to check whether sahi aa raha
//         for(int i=0;i<right.length;i++)
//         System.out.print(right[i]+" ");
//         int j=0,k1=0;

//         // yeh loop ko bhot closely analyze karo bhaii

//         for(int i=0;i<=nums.length-k;i++)
//         {
//             if(j<i)
//             {
//                 j=i;
//             }
//             while(right[j]<i+k)
//             {
//                 j=right[j];
//             }
//             max[k1++]=nums[j];
//         }
//         return max;
//     }
// }


// Using Array List

// class Solution {
//     public int[] maxSlidingWindow(int[] nums,int k){
//         int maximum[]=new int[nums.length-k+1];
//         ArrayList<Integer> list=new ArrayList<>();
//         int j=0,i=0,count=0;
//         while(j<nums.length)
//         {
//             while(!list.isEmpty()&&list.get(list.size()-1)<nums[j])
//             {
//                 list.remove(list.size()-1);
//             }
//             list.add(nums[j]);
//             if(j-i+1<k)
//             {
//                 j++;
//             }
//             else if(j-i+1==k)
//             {
//                 maximum[count++]=list.get(0);
//                 if(list.get(0)==nums[i])
//                 list.remove(0);
//                 i++;
//                 j++;
//             }
//         }
//         return maximum;
//     }
// }

// Using Deque

// class Solution {
//     public int[] maxSlidingWindow(int[] nums,int k){
//         int maximum[]=new int[nums.length-k+1];
//         Deque<Integer> dq=new ArrayDeque<>();
//         int j=0,i=0,count=0;
//         while(j<nums.length)
//         {
//             while(!dq.isEmpty()&&dq.getLast()<nums[j])
//             {
//                 dq.removeLast();
//             }
//             dq.addLast(nums[j]);
//             if(j-i+1<k)
//             {
//                 j++;
//             }
//             else if(j-i+1==k)
//             {
//                 maximum[count++]=dq.getFirst();
//                 if(dq.getFirst()==nums[i])
//                 dq.removeFirst();
//                 i++;
//                 j++;
//             }
//         }
//         return maximum;
//     }
// }






















class Solution {
    public int[] maxSlidingWindow(int[] nums,int k){
        Deque<Integer> dq=new LinkedList<>();
        int maximum[]=new int[nums.length-k+1];
        int i=0,j=0,count=0;
        while(j<nums.length)
        {
            while(!dq.isEmpty()&&dq.getLast()<nums[j])
            {
                dq.removeLast();
            }
            dq.addLast(nums[j]);
            if(j-i+1<k)
            {
                j++;
            }
            else
            {
                maximum[count++]=dq.getFirst();
                if(dq.getFirst()==nums[i])
                {
                    dq.removeFirst();
                }
                i++;
                j++;
            }
        }
        return maximum;
    }
}
