// class MedianFinder {
//     ArrayList<Integer> list;
//     int size;
//     public MedianFinder() {
//         list=new ArrayList<>();
//         size=0;
//     }
    
//     public void addNum(int num) {
//         list.add(num);
//         size++;
//     }
    
//     public double findMedian() {
//         Collections.sort(list); // bhai sabse important step hai issi ko bhul gaye the, question mein diya tha ki ordered honi chahiye list hamari while finding median
//         double ans=0.0;
//         if(size%2==0)
//         {
//             ans=((list.get(size/2)+list.get(size/2-1))*1.0)/2;
//         }
//         else
//         {
//             ans=list.get((size-1)/2);
//         }
//         return ans;
//     }
// }



// using two heaps
// maxheap represents the left half part of ordered integer list and minheap represents the right half part of ordered integer list
// go through sourin_bruh code titled "JAVA | 2 approaches | ArrayList | Heap ✅"
// https://www.youtube.com/watch?v=itmhHWaHupI

class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(maxHeap.size()==0||maxHeap.peek()>=num)
        {
            maxHeap.add(num);
        }
        else
        {
            minHeap.add(num);
        }
        balance();
    }
    public double findMedian() {
        if(maxHeap.size()>minHeap.size())
        {
            return maxHeap.peek()*1.0;
        }
        else if(minHeap.size()>maxHeap.size())
        {
            return minHeap.peek()*1.0;
        }
        else
        {
            return ((minHeap.peek()+maxHeap.peek())*1.0)/2;
        }
    }
    public void balance(){
        if(maxHeap.size()-minHeap.size()>1){
            minHeap.add(maxHeap.remove());
        }
        if(minHeap.size()-maxHeap.size()>1){
            maxHeap.add(minHeap.remove());
        }
    }
}

