class Solution {
    public long subArrayRanges(int[] nums) {
        // basic funda samjho, Sum of subarray ranges= summantion(subarray maximums)-summation(subarray minimums)
        long maxSummation=findSumMaximums(nums);
        long minSummation=findSumMinimums(nums);
        return maxSummation-minSummation;
    }
    public long findSumMaximums(int nums[])
    {
        long ans=0;
        int NGR[]=new int[nums.length];
        int NGL[]=new int[nums.length];
        fillNGL(nums,NGL);
        fillNGR(nums,NGR);
        for(int i=0;i<nums.length;i++)
        {
            ans=ans+1L*nums[i]*(i-NGL[i])*(NGR[i]-i);
        }
        return ans;
    }
    public long findSumMinimums(int nums[])
    {
        long ans=0;
        int NSR[]=new int[nums.length];
        int NSL[]=new int[nums.length];
        fillNSR(nums,NSR);
        fillNSL(nums,NSL);
        for(int i=0;i<nums.length;i++)
        {
            ans=ans+1L*nums[i]*(i-NSL[i])*(NSR[i]-i);
        }
        return ans;
    }
    public void fillNGL(int nums[],int NGL[])
    {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<nums.length;i++)
        {
            while(!st.isEmpty()&&nums[st.peek()]<nums[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                NGL[i]=-1;
            }
            else
            {
                NGL[i]=st.peek();
            }
            st.push(i);
        }
    }
    public void fillNSL(int nums[],int NSL[])
    {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<nums.length;i++)
        {
            while(!st.isEmpty()&&nums[st.peek()]>nums[i])
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
    public void fillNSR(int nums[],int NSR[])
    {
        Stack<Integer> st=new Stack<>();
        for(int i=nums.length-1;i>=0;i--)
        {
            while(!st.isEmpty()&&nums[st.peek()]>=nums[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                NSR[i]=nums.length;
            }
            else
            {
                NSR[i]=st.peek();
            }
            st.push(i);
        }
    }
    public void fillNGR(int nums[],int NGR[])
    {
        Stack<Integer> st=new Stack<>();
        for(int i=nums.length-1;i>=0;i--)
        {
            while(!st.isEmpty()&&nums[st.peek()]<=nums[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                NGR[i]=nums.length;
            }
            else
            {
                NGR[i]=st.peek();
            }
            st.push(i);
        }
    }
}