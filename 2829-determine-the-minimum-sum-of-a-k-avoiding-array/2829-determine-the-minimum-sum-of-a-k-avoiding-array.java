// class Solution {
//     public int minimumSum(int n, int k) {
//         HashMap<Integer,Integer> map=new HashMap<>();
//         int tempCount=2;
//         map.put(k-1,1);
//         int sum=1;
//         while(map.size()<n)
//         {
//             if(!map.containsKey(tempCount))
//             {
//                 map.put(k-tempCount,tempCount);
//                 sum=sum+tempCount;
//             }
//             tempCount++;
            
//         }
//         return sum;
//     }
// }






















class Solution {
    public int minimumSum(int n, int k) {
       HashMap<Integer,Integer> map=new HashMap<>();
       int count=0,i=1,sum=0;
       while(count!=n)
       {
           if(!map.containsKey(k-i))
           {
               map.put(i,1);
               count++;
               sum=sum+i;
           }
           i++;
       }
       return sum;
    }
}