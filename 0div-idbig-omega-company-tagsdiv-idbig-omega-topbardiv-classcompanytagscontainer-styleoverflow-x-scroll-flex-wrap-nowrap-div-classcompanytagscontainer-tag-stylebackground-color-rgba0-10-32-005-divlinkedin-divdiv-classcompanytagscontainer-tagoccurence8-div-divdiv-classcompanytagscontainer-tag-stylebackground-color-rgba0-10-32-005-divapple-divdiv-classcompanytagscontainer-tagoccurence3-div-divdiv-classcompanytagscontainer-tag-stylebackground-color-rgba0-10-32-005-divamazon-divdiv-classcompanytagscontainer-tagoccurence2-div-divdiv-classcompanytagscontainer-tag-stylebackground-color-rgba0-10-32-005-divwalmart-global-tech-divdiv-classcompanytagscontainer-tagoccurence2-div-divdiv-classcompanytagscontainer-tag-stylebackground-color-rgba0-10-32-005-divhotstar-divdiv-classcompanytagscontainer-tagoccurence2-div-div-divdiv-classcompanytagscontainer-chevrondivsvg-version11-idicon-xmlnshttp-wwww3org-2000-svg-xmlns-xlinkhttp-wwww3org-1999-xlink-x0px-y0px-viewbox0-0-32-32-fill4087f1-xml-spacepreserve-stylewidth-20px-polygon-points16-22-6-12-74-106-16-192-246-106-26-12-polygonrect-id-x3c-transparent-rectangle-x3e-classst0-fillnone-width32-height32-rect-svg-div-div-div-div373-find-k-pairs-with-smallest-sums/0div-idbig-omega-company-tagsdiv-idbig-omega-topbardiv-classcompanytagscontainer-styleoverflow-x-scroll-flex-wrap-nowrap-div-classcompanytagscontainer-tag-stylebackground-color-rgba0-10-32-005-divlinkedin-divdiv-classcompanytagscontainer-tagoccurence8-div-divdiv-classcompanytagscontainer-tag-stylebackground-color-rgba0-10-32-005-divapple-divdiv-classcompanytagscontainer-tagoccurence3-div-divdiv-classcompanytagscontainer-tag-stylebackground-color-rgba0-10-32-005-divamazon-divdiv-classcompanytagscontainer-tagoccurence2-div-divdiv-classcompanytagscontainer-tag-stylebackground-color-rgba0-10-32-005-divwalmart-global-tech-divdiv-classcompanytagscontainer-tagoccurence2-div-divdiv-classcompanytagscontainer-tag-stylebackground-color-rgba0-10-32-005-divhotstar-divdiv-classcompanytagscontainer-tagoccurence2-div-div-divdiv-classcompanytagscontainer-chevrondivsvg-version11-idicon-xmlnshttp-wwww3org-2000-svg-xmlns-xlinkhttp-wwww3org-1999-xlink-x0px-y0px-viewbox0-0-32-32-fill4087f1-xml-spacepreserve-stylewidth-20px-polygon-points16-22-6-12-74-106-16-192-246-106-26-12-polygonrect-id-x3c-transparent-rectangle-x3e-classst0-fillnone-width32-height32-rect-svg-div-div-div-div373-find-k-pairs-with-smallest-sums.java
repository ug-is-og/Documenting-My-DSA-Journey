// You tried your level best in this question to build a logic from scratch, kaafi kuch soch bhi liya tha, but it had some loop holes, after spending 1 hr I moved to solution

// Went through the solutions section and figured out this chummeshwari logic by curio_sity
// Title : "From Dumb to Pro with Just One Visit - My Promise to You with Efficient Selection of k Smallest Pair"

// Solution dekhne baad meine apne solution ke baare mein socha and I figured out ki yaar dikkat yahi hai ki tumne heaps socha fir uss heaps wali approach ko optimize karne ki jagah bilkul scratch se naya logic build karne ka socha

// hamare bhai ne aesa nahi kiya, usne heaps wale solution ko optimize kiya and O(KlogK) mein kar diya sawal
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list=new ArrayList<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int x:nums1)
        pq.add(new int[]{x+nums2[0],0}); // got to know a new way of initialising elements in array
        while(k>0&&!pq.isEmpty())
        {
            int temp[]=pq.poll();
            int sum=temp[0];
            int pos=temp[1];
            List<Integer> tempList=new ArrayList<>();
            tempList.add(sum-nums2[pos]);
            tempList.add(nums2[pos]);
            if(pos+1<nums2.length)
            pq.add(new int[]{sum-nums2[pos]+nums2[pos+1],pos+1});
            list.add(tempList);
            k--;
        }
        return list;
    }
}