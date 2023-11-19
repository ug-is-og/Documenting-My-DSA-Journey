// Damnn bhaiii 575/581 test cases were passed


// iss approach mein logic bilkul sahi build kiya hai, just dikkat yahi huii hai ki tumne right to left wali approach follow kari jiski wajah se tumhe substring nikalne ki need pad gayi which had a O(n) time complexity, same approach ko left to right chalana tha and tumhe ans mil jata
// bhaiii itna close aake bhi nahi hua

// class Solution {
//     public long minimumSteps(String s) {
//         long count=0;
//         int lastOcc1=s.length();
//         for(int i=s.length()-1;i>0;i--)
//         {
//             char c2=s.charAt(i);
//             char c1=s.charAt(i-1);
//             if(c1=='1'&&c2=='0')
//             {
//                 count=count+(lastOcc1-i);
//                s=s.substring(0,i-1)+"01"+s.substring(i+1);
//             }
//             if((c1=='1'&&c2=='0')||(c2=='1'))
//             {
//                 lastOcc1=lastOcc1-1;
//             }
//         }
//         return count;
//     }
// }

class Solution {
    public long minimumSteps(String s) {
        long count=0;
        int w=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='0')
            {
                count=count+i-w;
                w++;
            }
        }
        return count;
    }
}