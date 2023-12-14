// class Solution {
//     public int sumSubarrayMins(int[] arr) {
//         // for any element in a subarray we can find the no. of consecutive array elements on left greater than element , similarly we can find no of contiguous array elements on right greater than element.

//         // we can do this by using the concept of next small element on left and next small element on right

//         int nSR[]=new int[arr.length];
//         long sum=0;
//         int n=arr.length;
//         Stack<Integer> stack1=new Stack<>();
//         for(int i=n-1;i>=0;i--)
//         {
//             while(!stack1.isEmpty()&&arr[stack1.peek()]>arr[i]) //yahan pe > kiya toh neeche >= , ek jagah par equal elements wale include karenge subset mein toh dusri jagah nahi karenge include, nahi toh subsets repeat ho jayenge
//             stack1.pop();
//             if(stack1.isEmpty())
//             nSR[i]=arr.length-1-i;
//             else
//             nSR[i]=stack1.peek()-1-i;
//             stack1.push(i);
//         }
//         int nSL[]=new int[arr.length];
//         Stack<Integer> stack2=new Stack<>();
//         for(int i=0;i<n;i++)
//         {
//             while(!stack2.isEmpty()&&arr[stack2.peek()]>=arr[i])
//             {
//                 stack2.pop();
//             }
//             if(stack2.isEmpty())
//             nSL[i]=i;
//             else
//             nSL[i]=i-stack2.peek()-1;
//             stack2.push(i);
//         }
//         for(int i=0;i<arr.length;i++)
//         {
//             sum=(sum+(1L*arr[i]*(nSL[i]+1)*(nSR[i]+1)))%1000000007; // yahan pe 1L karna bhot zaruri tha
//         }
//         //System.out.println(sum);
//         return (int)sum;
//     }
// }











// class Solution {
//     public int sumSubarrayMins(int[] arr) {
//        long ans=0;
//        int nSR[]=new int[arr.length]; // next Striclty smaller on the right
//        int nSL[]=new int[arr.length]; // next smaller or equal to on left
//        Arrays.fill(nSR,arr.length);
//        Arrays.fill(nSL,-1);
//        fillnSL(nSL,arr);
//        fillnSR(nSR,arr);
//        for(int i=0;i<arr.length;i++)
//        {
//            ans=(ans+(1L*(i-nSL[i])*(nSR[i]-i)*arr[i]))%1000000007; // yahan 1L se multiply karna bhot zaruri tha infact 1L expression ke start mein likhna bhi bhot zaruri tha (i-nSL[i])*(nSR[i]-i)*arr[i]*1L pe bhi nahi chalega kyunki till that time calculation already int bounds ke bahar ja chuki hai and last mein keh re tum ki yeh long calculation hai
//        }
//        return (int)ans;
//     }
//     public void fillnSL(int nSL[],int arr[])
//     {
//         Stack<Integer> st=new Stack<>();
//         for(int i=0;i<arr.length;i++)
//         {
//             while(!st.isEmpty()&&arr[st.peek()]>arr[i])
//             {
//                 st.pop();
//             }
//             if(!st.isEmpty())
//             {
//                 nSL[i]=st.peek();
//             }
//             st.push(i);
//         }
//     }
//     public void fillnSR(int nSR[],int arr[])
//     {
//         Stack<Integer> st=new Stack<>();
//         for(int i=arr.length-1;i>=0;i--)
//         {
//             while(!st.isEmpty()&&arr[st.peek()]>=arr[i])
//             {
//                 st.pop();
//             }
//             if(!st.isEmpty())
//             {
//                 nSR[i]=st.peek();
//             }
//             st.push(i);
//         }
//     }
// }


















class Solution {
    public int sumSubarrayMins(int[] arr) {
       // we need NSL and NSR index 
       int NSL[]=new int[arr.length];
       int NSR[]=new int[arr.length];
       int mod=1000000007;
        long ans=0;
       buildNSL(NSL,arr);
       buildNSR(NSR,arr);
       for(int i=0;i<arr.length;i++)
       {
           ans=(ans+1L*arr[i]*(NSR[i]-i)*(i-NSL[i]))%mod;
       }
       return (int)ans%mod;
    }
    public void buildNSL(int NSL[],int arr[])
    {
        // for NSL we will consider next strictly smaller on left
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++)
        {
            while(!st.isEmpty()&&arr[st.peek()]>arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                NSL[i]=-1;
            }
            else
            {
                NSL[i]=st.peek();
            }
            st.push(i);
        }
    }
    public void buildNSR(int NSR[],int arr[])
    {
        // for NSR we will next smaller on right (not strictly smaller)
        Stack<Integer> st=new Stack<>();
        for(int i=arr.length-1;i>=0;i--)
        {
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                NSR[i]=arr.length;
            }
            else
            {
                NSR[i]=st.peek();
            }
            st.push(i);
        }
    }
}







