class KthLargest {
    int k;
    PriorityQueue<Integer> pq=new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k=k;
        // build PQ of k largest elements
        buildPQ(pq,nums,k);
    }
    private void buildPQ(PriorityQueue<Integer> pq,int nums[],int k)
    {
        for(int i=0;i<nums.length;i++)
        {
            if(i<k)
            {
                pq.add(nums[i]);
            }
            else
            {
                if(pq.peek()<nums[i])
                {
                    pq.remove();
                    pq.add(nums[i]);
                }
            }
        }
    }
    public int add(int val) {
        if(pq.size()<k) // yeh condition bhot dhyan se dekhna, yaar aesa ho sakta hai ki jab tumne nums ke elements bhare apni PQ mein toh k se kam elements bhar paaye....aese mein agar seedha pq.peek() se compare karliya val toh woh logically galat ho gaya....consider test case pq has (4,8) and val=2, k=3

// itna yaad rakho ki yeh pq.peek()<val wala kaam tab karte ho jab k elements pade ho PQ mein, agar k elements nahi toh tum nakhre nahi dikha sakte, tumhe pehle k elements complete karne padenge uske baad hi if's and but's sunungs
        {
            pq.add(val);
        }
        else if(pq.peek()<val)
        {
            pq.remove();
            pq.add(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */