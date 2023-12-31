// class Solution {
//     public int findMin(int[] arr) {
//         int start=0,end=arr.length-1;
//         int mid=0;
//         int min=Integer.MAX_VALUE;
//         while(start<=end)
//         {
//             mid=(start+end)/2;
//             if(arr[start]<=arr[mid])
//             {
//                 min=Math.min(min,arr[start]); // left sorted half ke min value (arr[low]) se compare karke right chale ja re
//                 start=mid+1;
//             }
//             else
//             {
//                 min=Math.min(min,arr[mid]); // right sorted half ke min value (arr[mid]) se compare karke left mein chale ja re
//                 end=mid-1;
//             }
//         }
//         return min;
//     }
// }






















class Solution {
    public int findMin(int[] arr) {
        int lo=0,hi=arr.length-1,min=Integer.MAX_VALUE;
        int mid=(lo+hi)/2;
        if(arr[mid]>=arr[lo]&&arr[mid]<=arr[hi])
        return arr[0];
        while(lo<=hi)
        {
            mid=(lo+hi)/2;
            if(arr[mid]>=arr[lo])
            {
                min=Math.min(min,arr[lo]);
                lo=mid+1;
            }
            else if(arr[mid]<=arr[hi])
            {
                min=Math.min(min,arr[mid]);
                hi=mid-1;
            }
        }
        return min;
    }
}