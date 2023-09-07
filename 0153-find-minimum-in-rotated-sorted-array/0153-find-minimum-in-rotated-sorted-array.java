class Solution {
    public int findMin(int[] arr) {
        int start=0,end=arr.length-1;
        int mid=0;
        int min=Integer.MAX_VALUE;
        while(start<=end)
        {
            if(arr[start]<=arr[end]) // optimization for a better time complexity, matlab zabardasti binary search nahi karna padega
            {
                min=Math.min(arr[start],min);
                return min;
            }
            mid=(start+end)/2;
            if(arr[start]<=arr[mid])
            {
                min=Math.min(min,arr[start]); // left sorted half ke min value (arr[low]) se compare karke right chale ja re
                start=mid+1;
            }
            else
            {
                min=Math.min(min,arr[mid]); // right sorted half ke min value (arr[mid]) se compare karke left mein chale ja re
                end=mid-1;
            }
        }
        return min;
    }
}