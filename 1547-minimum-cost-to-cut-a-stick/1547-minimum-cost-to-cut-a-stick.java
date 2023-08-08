
// Arrays.asList(arr).contains() // yahan array ka type Integer[] hona chahiye int[] nahi
// basically asList is used to treat arr as an arrayList


// successfully TLE aa gaya hai , let's optimize this code
// by basically using a dp array for memoization

// class Solution {
//     public int minCost(int n, int[] cuts) {
//         int dp[][]=new int[n+1][n+1];
//         for(int temp[]:dp)
//         Arrays.fill(temp,-1);
//         return helper(cuts,0,n,dp);
//     }
//     public int helper(int cuts[],int i,int j,int dp[][])
//     {
//         if(i==j)
//         return 0;
//         if(dp[i][j]!=-1)
//         return dp[i][j];
//         int minCost=Integer.MAX_VALUE;
//         boolean isCut=false;
//         for(int k=i+1;k<=j-1;k++)
//         {
//             boolean found=false;
//             for(int m=0;m<cuts.length;m++)
//             {
//                 if(cuts[m]==k)
//                 {
//                     found=true;
//                     break;
//                 }
//             }
//             if(found)
//             {
//                 int cost=(j-i)+helper(cuts,i,k,dp)+helper(cuts,k,j,dp);
//                 minCost=Math.min(minCost,cost);  
//                 isCut=true; // denotes ki ek toh cut mara hi hai
//             }
//         }
//         if(isCut==false)
//         return 0;
//         return dp[i][j]=minCost;
//     }
// }

// memoize karne ke baad apna Memory Limit exceeded aa raha hai
// lets use a hashmap for memoization instead of 2d dp array, got this intuition from solutions section of this question, someone was facing the same issue there


// yeh hashmap use karne ke baad bhi 81 tC pe TLE de raha, further optimization

// class Solution {
//     public int minCost(int n, int[] cuts) {
//         HashMap<String,Integer> map=new HashMap<>();
//         return helper(cuts,0,n,map);
//     }
//     public int helper(int cuts[],int i,int j,HashMap<String,Integer> map)
//     {
//         if(i==j)
//         return 0;
//         String key=i+"_"+j;
//         if(map.containsKey(key))
//         return map.get(key);
//         int minCost=Integer.MAX_VALUE;
//         boolean isCut=false;
//         for(int k=i+1;k<=j-1;k++)
//         {
//             boolean found=false;
//             for(int m=0;m<cuts.length;m++)
//             {
//                 if(cuts[m]==k)
//                 {
//                     found=true;
//                     break;
//                 }
//             }
//             if(found)
//             {
//                 int cost=(j-i)+helper(cuts,i,k,map)+helper(cuts,k,j,map);
//                 minCost=Math.min(minCost,cost);  
//                 isCut=true; // denotes ki ek toh cut mara hi hai
//             }
//         }
//         if(isCut==false)
//         {
//             map.put(key,0);
//             return 0;
//         }
//         map.put(key,minCost);
//         return minCost;
//     }
// }

// further optimization 
// hamne iss optimization mein loop ko i to j traverse karne ki jagah kewal 0 to cuts.length
// iss case mein cuts ki max length 100 ho sakti but i to j kaafi bada no ho ja ra kyunki n ki value 10^5 tak ja sakti so be very careful

class Solution {
    public int minCost(int n, int[] cuts) {
        HashMap<String,Integer> map=new HashMap<>();
        return helper(cuts,0,n,map);
    }
    public int helper(int cuts[],int i,int j,HashMap<String,Integer> map)
    {
        if(i==j)
        return 0;
        String key=i+"_"+j;
        if(map.containsKey(key))
        return map.get(key);
        int minCost=Integer.MAX_VALUE;
        boolean isCut=false;
        for(int k=0;k<cuts.length;k++)
        {
            if(cuts[k]>i&&cuts[k]<j)
            {
                int cost=(j-i)+helper(cuts,i,cuts[k],map)+helper(cuts,cuts[k],j,map);
                minCost=Math.min(minCost,cost);  
                isCut=true; // denotes ki ek toh cut mara hi hai
            }
        }
// yeh dhyan se dekho minCost wali jo problem aati hai na ki ek 
// baar bhi if condition mein nahi ghusa toh max value return karega and fir wahan 
// se dikkatein chalu, bas usko sort karne ke liye kiya hai humne
// ek aur better solution hai uss problem ko solve karne ka, bas simply yeh check karlo ki loop ke bahar aake max value ke equal toh nhai , agar max value ke equal hai matlab kabhi update hi nahi hua hence 0 return kar dete hai, dono hi solution badhiya hai
        if(isCut==false)
        {
            map.put(key,0);
            return 0;
        }
        map.put(key,minCost);
        return minCost;
    }
}