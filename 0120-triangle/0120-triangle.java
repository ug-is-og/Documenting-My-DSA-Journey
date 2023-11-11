// yeh tareeka galat ho ja raha if elements in triangle are negative
// very important point to note
// [[-1],[2,3],[1,-1,-3]] , tumhara aa ra -2 but ans is -1
// question sahi se nahi padha tumne
// More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int dp[]=new int[triangle.size()];
//         Arrays.fill(dp,-1);
//         return helper(0,triangle,dp);
//     }
//     public int helper(int index,List<List<Integer>> triangle,int dp[])
//     {
//         if(index==triangle.size())
//         return 0;
//         if(dp[index]!=-1)
//         return dp[index];
//         int min=Integer.MAX_VALUE;
//         for(int i=0;i<triangle.get(index).size();i++)
//         {
//             min=Math.min(min,triangle.get(index).get(i));
//         }
//         return dp[index]=min+helper(index+1,triangle,dp);
//     }
// }

// doing corrections
// tumne ek galti aur yeh bhi kari hai ki greedy approach se solve karne lage question ko
// greedy se nahi hone wala, saari possibilities dekhni padengi
// ab aagaya TLE successfully

// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         return helper(0,0,triangle);
//     }
//     public int helper(int rowIndex,int colIndex,List<List<Integer>> triangle)
//     {
//         if(rowIndex==triangle.size())
//         return 0;
//         int way1=helper(rowIndex+1,colIndex,triangle);
//         int way2=helper(rowIndex+1,colIndex+1,triangle);
//         return Math.min(way1,way2)+triangle.get(rowIndex).get(colIndex);
//     }
// }

// let's memoize this approach
// we'll optimize this solution later, as a follow up is given to do in O(n) space

// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int dp[][]=new int[triangle.size()][triangle.get(triangle.size()-1).size()];
//         for(int temp[]:dp)
//         Arrays.fill(temp,-1);
//         return helper(0,0,triangle,dp);
//     }
//     public int helper(int rowIndex,int colIndex,List<List<Integer>> triangle,int dp[][])
//     {
//         if(rowIndex==triangle.size())
//         return 0;
//         if(dp[rowIndex][colIndex]!=-1)
//         return dp[rowIndex][colIndex];
//         int way1=helper(rowIndex+1,colIndex,triangle,dp);
//         int way2=helper(rowIndex+1,colIndex+1,triangle,dp);
//         return dp[rowIndex][colIndex]=Math.min(way1,way2)+triangle.get(rowIndex).get(colIndex);
//     }
// }

























class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
       int dp[][]=new int[triangle.size()][triangle.get(triangle.size()-1).size()];
       for(int temp[]:dp)
       {
           Arrays.fill(temp,-1);
       }
       return helper(triangle,0,0,dp);
    }
    public int helper(List<List<Integer>> triangle,int i,int j,int dp[][])
    {
        if(i==triangle.size())
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        return dp[i][j]=triangle.get(i).get(j)+Math.min(helper(triangle,i+1,j,dp),helper(triangle,i+1,j+1,dp));
    }
}
