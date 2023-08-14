// Aditya Verma approach (Approach-1)

// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> pq=new PriorityQueue<>();
//         for(int i=0;i<nums.length;i++)
//         {
//             pq.add(nums[i]); 
//             if(i>=k)
//             pq.remove(); // basically k largest daavedaar rakhne hai toh usse upar wale sab hatane padenge , wahi kar re yahan pe

//             // just that iss wali approach mein ham sabko aane de rahe and then baad mein chataai kar re
//         }
//         return pq.peek();
//     }
// }

// Pepcoding Approach (Approach-2)

// Pepcoding approach is slightly better kyunki ham pehle filter laga re uske baad elements ko laa rahe

// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> pq=new PriorityQueue<>();
//         for(int i=0;i<nums.length;i++)
//         {
//             if(i<k)
//             pq.add(nums[i]); // aese karke initially hamne k largest daavedar ikattha kar liye
//             // ab inme se sabse kamzor daavedar top wala element hai as it is smallest (kyunki hamara goal was to get k largest elements)
//             else 
//             {
//                 if(nums[i]>pq.peek()) // ab iske baad ham proper filter lagake chtaai karenge ki kisko aana chahiye in those k largest elements, agar min wala element incoming se chhota hai toh usko hatake incoming element le aayenge
//                 {
//                     pq.remove();
//                     pq.add(nums[i]);
//                 }
//             }
//         }
//         return pq.peek();
//     }
// }



class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++)
        {
            if(i<k)
            {
                pq.add(nums[i]);
            }
            else
            {
                if(nums[i]>pq.peek())
                {
                    pq.remove();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.peek();
    }
}











