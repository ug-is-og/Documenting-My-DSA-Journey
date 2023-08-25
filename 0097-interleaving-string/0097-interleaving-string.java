// Successfully got TLE in this recursive approach
// 99/106 test cases passed

// class Solution {
//     public boolean isInterleave(String s1, String s2, String s3) {
//         return check(s1,s1,s2,s3)||check(s2,s2,s1,s3);
//     }
//     public boolean check(String test,String s1,String s2,String s3)
//     {
//         if(s3.length()==0)
//         {
//             if(s1.length()==0&&s2.length()==0)
//             return true;
//             else
//             return false;
//         }
//         int count=0;
//         boolean ans=false;
//         for(int i=1;i<=test.length();i++)
//         {
//             if(s3.startsWith(test.substring(0,i)))
//             {
//                 ans=ans||check(s2,s2,s1.substring(i),s3.substring(i));
//             }
//             else
//             break;
//         }
//         return ans;
//     }
// }

// let's memoize the above approach using HashMap

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        HashMap<String,Integer> map=new HashMap<>();
        return check(s1,s1,s2,s3,map)||check(s2,s2,s1,s3,map);
    }
    public boolean check(String test,String s1,String s2,String s3,HashMap<String,Integer> map)
    {
        if(s3.length()==0)
        {
            if(s1.length()==0&&s2.length()==0)
            return true;
            else
            return false;
        }
        String key=s1+"_"+s2;
        if(map.containsKey(key))
        {
            if(map.get(key)==1)
            return true;
            return false;
        }
        int count=0;
        boolean ans=false;
        for(int i=1;i<=test.length();i++)
        {
            if(s3.startsWith(test.substring(0,i)))
            {
                ans=ans||check(s2,s2,s1.substring(i),s3.substring(i),map);
            }
            else
            break;
        }
        if(ans==true)
        map.put(key,1);
        else
        map.put(key,0);
        return ans;
    }
}

// But this only beats 5% and might not be the most optimal solution
// we'll have to optimize this solution later