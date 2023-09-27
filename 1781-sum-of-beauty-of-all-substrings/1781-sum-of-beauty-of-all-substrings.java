// simple brute force approach is giving TLE, iss approach mein simply hashmap ko update karte ja re and harr substring ke liye hashmap ko check kar re...iss wajah se O(26*N^2) solution ho gaya

// bhai TLE SOPLN ki wajah se h aa raha tha

class Solution {
    public int beautySum(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++)
        {
            HashMap<Character,Integer> map=new HashMap<>();
            for(int j=i;j<s.length();j++)
            {
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
                sum=sum+beautyFinder(map);
            }
        }
        return sum;
    }
    public int beautyFinder(HashMap<Character,Integer> map)
    {
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(Map.Entry<Character,Integer> entry:map.entrySet())
        {
            max=Math.max(max,entry.getValue());
            min=Math.min(min,entry.getValue());
        }
        return max-min;
    }
}

// optimized approach using sliding window

// class Solution {
//     public int beautySum(String s) {
//        int sum=0;
//        for(int size=3;size<=s.length();size++)
//        {
//             HashMap<Character,Integer> map=new HashMap<>();
//            int j=0;
//            for(j=0;j<size;j++)
//            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
//            sum=sum+beautyFinder(map);
//            int i=0;
//            while(j<s.length())
//            {
//                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
//                if(map.get(s.charAt(i))==1)
//                map.remove(s.charAt(i));
//                else
//                map.put(s.charAt(i),map.get(s.charAt(i))-1);
//                sum=sum+beautyFinder(map);
//                j++;
//                i++;
//            }
//        }
//        return sum;
//     }
//     public int beautyFinder(HashMap<Character,Integer> map)
//     {
//         int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
//         for(Map.Entry<Character,Integer> entry:map.entrySet())
//         {
//             max=Math.max(max,entry.getValue());
//             min=Math.min(min,entry.getValue());
//         }
//        // System.out.println(max-min); // cheezo ko print karne ki wajah se bhi TLE aa sakta hai yeh seekha hamne
//         return max-min;
//     }
// }