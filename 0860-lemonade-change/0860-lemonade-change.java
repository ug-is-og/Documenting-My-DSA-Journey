// bhot zaada brute approach sochi hai, hame definitely optimize karna padega isko

// class Solution {
//     public boolean lemonadeChange(int[] bills) {
//         HashMap<Integer,Integer> map=new HashMap<>();
//         for(int i=0;i<bills.length;i++)
//         {
//             if(bills[i]==10)
//             {
//                 if(map.containsKey(5)&&map.get(5)>0)
//                 {
//                     map.put(5,map.get(5)-1);
//                 }
//                 else
//                 {
//                     return false;
//                 }
//             }
//             else if(bills[i]==20)
//             {
//                 if(map.containsKey(10)&&map.get(10)>0&&map.containsKey(5)&&map.get(5)>0)
//                 {
//                     map.put(5,map.get(5)-1);
//                     map.put(10,map.get(10)-1);
//                 }
//                 else if(map.containsKey(5)&&map.get(5)>=3)
//                 {
//                     map.put(5,map.get(5)-3);
//                 }
//                 else
//                 {
//                     return false;
//                 }
//             }
//             map.put(bills[i],map.getOrDefault(bills[i],0)+1);
//         }
//         return true;
//     }
// }

// Much better code, use of hashmap was unnecessary in above code

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveCoins=0,tenCoins=0;
        for(int i=0;i<bills.length;i++)
        {
            if(bills[i]==10)
            {
                if(fiveCoins>0)
                {
                    fiveCoins--;
                }
                else
                {
                    return false;
                }
            }
            else if(bills[i]==20)
            {
                if(fiveCoins>0&&tenCoins>0)
                {
                    fiveCoins--;
                    tenCoins--;
                }
                else if(fiveCoins>=3)
                {
                    fiveCoins-=3;
                }
                else
                {
                    return false;
                }
            }
            if(bills[i]==5)
            {
                fiveCoins++;
            }
            if(bills[i]==10)
            {
                tenCoins++;
            }
        }
        return true;
    }
}