// class Solution {
//     public int largestAltitude(int[] gain) {
//        // prefix sum algorithm

//         // int max=Integer.MIN_VALUE;
//         // for(int i=1;i<gain.length;i++)
//         // gain[i]=gain[i]+gain[i-1];
//         // for(int i=0;i<gain.length;i++)
//         // {
//         //     max=Math.max(max,gain[i]);
//         // }
//         // if(max>0)
//         // return max;
//         // return 0;

//          int maxAltitude = 0; // kyunki minimum possible value of maxAltitude yahi ho sakti
//     int currentAltitude = 0;
    
//     for (int i = 0; i < gain.length; i++) {
//         currentAltitude += gain[i];
//         maxAltitude = Math.max(maxAltitude, currentAltitude);
//     }
    
//     return maxAltitude;
//     }
// }




















// O(n) TC but O(n) SC

// class Solution {
//     public int largestAltitude(int[] gain) {
//        int heights[]=new int[gain.length+1];
//        heights[0]=0;
//        int maxHeight=0;
//        for(int i=1;i<heights.length;i++)
//        {
//            heights[i]=heights[i-1]+gain[i-1];
//            maxHeight=Math.max(maxHeight,heights[i]);
//        }
//        return maxHeight;
//     }
// }

// O(n) TC and O(1) space

class Solution {
    public int largestAltitude(int[] gain) {
       int maxHeight=0,currHeight=0;
       for(int i=0;i<gain.length;i++)
       {
           currHeight+=gain[i];
           maxHeight=Math.max(maxHeight,currHeight);
       }
       return maxHeight;
    }
}