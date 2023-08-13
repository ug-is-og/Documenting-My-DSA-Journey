// 2 methods using treeset and treemap

// Using Treeset

// class Solution {
//     public int minAbsoluteDifference(List<Integer> nums, int x) {
//         TreeSet<Integer> set=new TreeSet<>();
//         int ans=Integer.MAX_VALUE;
//         for(int i=x;i<nums.size();i++)
//         {
//             int val=nums.get(i);
//             set.add(nums.get(i-x));
//             // int low=set.lower(val+1);// yeh line error de ri kyunki null return ho ra and tum Integer to int kar re null ko jo possible nahi
//             Integer low=set.lower(val+1); // returns greatest among all elements strictly less than given element, equal elements include ho jaaye iss liye val+1 bheja hai
//             Integer high=set.higher(val-1); // returns smallest among all elements strictly greater than given element, equal elements include ho jaaye iss liye val-1 bheja hai
//             if(low!=null)
//             ans=Math.min(val-low,ans);
//             if(high!=null)
//             ans=Math.min(ans,high-val);
//         }
//         return ans;
//     }
// }


// Using TreeMap

class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=x;i<nums.size();i++)
        {
            map.put(nums.get(i),map.getOrDefault(nums.get(i),0)+1);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.size()-x;i++)
        {
            int val=nums.get(i);
            var low=map.floorEntry(val); // returns greatest among all keys less than or equal to given element, key, value pair return karta hai ek saath
            // var likhne se hame data type ki chinta nahi karni padti, woh apne aap identify kar lega
            var high=map.ceilingEntry(val);
            if(low!=null)
            ans=Math.min(ans,val-low.getKey());
            if(high!=null)
            ans=Math.min(ans,high.getKey()-val);
            int mapValue=nums.get(i+x);
            if(map.get(mapValue)==1)
            map.remove(mapValue);
            else
            map.put(mapValue,map.get(mapValue)-1);
        }
        return ans;
    }
}
