// Even a O(n) solution isn't working

// class Solution {
//     public long minimumPossibleSum(int n, int target) {
//         HashMap<Integer,Integer> map=new HashMap<>();
//         long currSum=0; // long wali optimization ke baad bhi TLE
//         // O(n) mein bhi TLE aa raha, god knows why
//         for(int i=1;i<=target;i++)
//         {
//             if(!map.containsValue(i))
//             {
//                 map.put(i,target-i);
//                 currSum=currSum+i;
//             }
//             if(map.size()==n)
//                 break;
//         }
//         if(map.size()==n)
//             return currSum;
//         long remN=n-map.size();
        
//         // optimization
           // yeh wala formula and neeche jo optimal approach mein formula likha hai that are different,
           // iss approach mein hamne target already include kar liya hai upar loop mein toh ab target +1 se chalu kar re direct but neeche wali approach mein hame target se chalu karna hai toh uske according likha hai
           
//         return currSum+target*(remN)+(remN*(remN+1))/2;
        
//         // brute approach
        
//         // int temp=target+1;
//         // for(int i=1;i<=n-map.size();i++)
//         // {
//         //     currSum=currSum+temp;
//         //     temp=temp+1;
//         // }
//         // return currSum;
//     }
// }

// optimizing the above approach

// we don't actually need a hashmap

class Solution {
    public long minimumPossibleSum(int n, int target) {
        long currSum=0; 
        int i=0;
        for(i=1;i<=target/2&&i<=n;i++)
        {
           currSum=currSum+i;   
        }
        if(i-1==n)
        return currSum;
        long remN=n-i+1;
        // think about this formula kaafi sochke nikala hai
        return currSum+target*(remN)+((remN-1)*(remN))/2;
    }
}

