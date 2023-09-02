//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String str = read.readLine().trim(); 
            Solution obj = new Solution();
            int ans = obj.palindromeSubStrs(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

// This approach is giving TLE 71/73 test cases passed
// Contains() baar baar use kar re array list ka shayad iss wajah se , TC is O(n) for contains()

// class Solution 
// { 
//     int palindromeSubStrs(String str) { 
//         int N=str.length();
//         boolean dp1[][]=new boolean[N][N];
//         List<String> list=new ArrayList<>();
//         for(int g=0;g<N;g++)
//         {
//             for(int i=0,j=g;i<dp1.length&&j<dp1.length;i++,j++)
//             {
//                 if(g==0)
//                 {
//                     dp1[i][j]=true;
//                     if(!list.contains(str.charAt(i)+""))
//                     {
//                         list.add(str.charAt(i)+"");
//                     }
//                 }
//                 else if(g==1)
//                 {
//                     if(str.charAt(i)==str.charAt(j))
//                     {
//                         dp1[i][j]=true;
//                         if(!list.contains(str.substring(i,j+1))) // very important, dp[i][j]=true toh karna hi hai
//                         // regardless of whether list contains substring or not, socho iske baare mein abaaa ke saath
//                         list.add(str.substring(i,j+1));
//                     }
//                 }
//                 else
//                 {
//                     if(str.charAt(i)==str.charAt(j)&&dp1[i+1][j-1])
//                     {
//                          dp1[i][j]=true;
//                          if(!list.contains(str.substring(i,j+1)))
//                          list.add(str.substring(i,j+1));
//                     }
//                 }
//             }
//         }
//         return list.size();
//     }
// } 



// optimization using hashset


class Solution 
{ 
    int palindromeSubStrs(String str) { 
        int N=str.length();
        boolean dp1[][]=new boolean[N][N];
        HashSet<String> set=new HashSet<>();
        for(int g=0;g<N;g++)
        {
            for(int i=0,j=g;i<dp1.length&&j<dp1.length;i++,j++)
            {
                if(g==0)
                {
                    dp1[i][j]=true;
                    set.add(str.charAt(i)+"");
                    // if(!list.contains(str.charAt(i)+""))
                    // {
                    //     list.add(str.charAt(i)+"");
                    // }
                }
                else if(g==1)
                {
                    if(str.charAt(i)==str.charAt(j))
                    {
                        dp1[i][j]=true;
                        set.add(str.substring(i,j+1));
                        
                        // if(!list.contains(str.substring(i,j+1))) // very important, dp[i][j]=true toh karna hi hai
                        // // regardless of whether list contains substring or not, socho iske baare mein abaaa ke saath
                        // list.add(str.substring(i,j+1));
                    }
                }
                else
                {
                    if(str.charAt(i)==str.charAt(j)&&dp1[i+1][j-1])
                    {
                         dp1[i][j]=true;
                         set.add(str.substring(i,j+1));
                         
                        //  if(!list.contains(str.substring(i,j+1)))
                        //  list.add(str.substring(i,j+1));
                    }
                }
            }
        }
        return set.size();
    }
} 