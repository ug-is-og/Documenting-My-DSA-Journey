// // key denotes array elements and value denotes frequency 
// class keyValue{
//     int key;
//     int value;
//     public keyValue(int key,int value){
//         this.key=key;
//         this.value=value;
//     }
// }
// class ordering implements Comparator<keyValue>{
//     public int compare(keyValue num1,keyValue num2)
//     {
//         return num1.value-num2.value;
//     }
// }
// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         int arr[]=new int[k];
//         HashMap<Integer,Integer> map=new HashMap<>();
//         for(int i=0;i<nums.length;i++)
//         {
//             if(map.containsKey(nums[i]))
//             map.put(nums[i],map.get(nums[i])+1);
//             else
//             map.put(nums[i],1);
//         }
//         ordering valueOrdering=new ordering();
//         PriorityQueue<keyValue> pq=new PriorityQueue<>(valueOrdering);
//         int i=0;
//         for(Map.Entry<Integer,Integer> entry: map.entrySet())
//         {
//             if(i<k)
//             pq.add(new keyValue(entry.getKey(),entry.getValue()));
//             else
//             {
//                 if(pq.peek().value<entry.getValue())
//                 {
//                     pq.remove();
//                     pq.add(new keyValue(entry.getKey(),entry.getValue()));
//                 }
//             }
//             i++;
//         }
//         i=0;
//         while(!pq.isEmpty())
//         {
//             arr[i]=pq.remove().key;
//             i++;
//         }
//         return arr;
//     }
// }












class keyValue{
    int key;
    int value;
    public keyValue(int key,int value){
        this.key=key;
        this.value=value;
    }
}
class ordering implements Comparator<keyValue>{
    public int compare(keyValue kV1,keyValue kV2){
        return kV1.value-kV2.value;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       int ans[]=new int[k];
       HashMap<Integer,Integer> map=new HashMap<>();
       for(int i=0;i<nums.length;i++)
       {
           map.put(nums[i],map.getOrDefault(nums[i],0)+1);
       }
       PriorityQueue<keyValue> pq=new PriorityQueue<>(new ordering());
       int i=0;
       for(Map.Entry<Integer,Integer> entry:map.entrySet())
       {
           if(i<k)
           {
               pq.add(new keyValue(entry.getKey(),entry.getValue()));
           }
           else
           {
               if(pq.peek().value<entry.getValue())
               {
                   pq.remove();
                   pq.add(new keyValue(entry.getKey(),entry.getValue()));
               }
           }
           i++;
       }
       int size=pq.size();
       for(i=0;i<size;i++)
       {
           ans[i]=pq.remove().key;
       }
       return ans;
    }
}







