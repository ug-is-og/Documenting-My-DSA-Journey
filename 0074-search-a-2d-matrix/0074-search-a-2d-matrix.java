// brute approach O(m*n) TC , directly searching target in the matrix

//better approach through O(m+n) TC , pehle pura 1st column check karlo to find breaking point, 
// breaking point -1 th row mein possibility hai milne ki toh fir woh row check kar lenge

// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int i=0;
//         for(i=0;i<matrix.length;i++)
//         {
//             if(matrix[i][0]>target)
//             break;
//         }
//         int row=Math.max(i-1,0);
//         for(int j=0;j<matrix[0].length;j++)
//         {
//             if(matrix[row][j]==target)
//             return true;
//         }
//         return false;
//     }
// }

// dekh ek optimization toh yeh click kar ra ki sorted format mein di hai cheezin toh binary search laga sakte hai ham, in a row toh O(log n) ho jayega par ab woh soecific row kaise dhundhe lekin ?

// dekho yaar row find karne ke liye bhi laga sakte bas mid return karo agar start==end ho toh
// and ya toh mid, mid-1,mid+1 ek toh target row hogi hi

//TC is O( log m + 3*log n)

// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int i=0;
//         int mid=binarySearch1(matrix,0,matrix.length-1,target);
//         int row1=Math.max(mid-1,0); // yaha apne aap bach gaye
//         int row2=mid; // yahan tumhe soch samajh ke lana padega ans jo bhi hai condition wagera lagake
//         int row3=Math.min(mid+1,matrix.length-1); // yahan bhi bach gaye
//         System.out.println(row1+" "+row2+" "+row3);
//         return binarySearch2(row1,matrix,0,matrix[0].length-1,target)||binarySearch2(row2,matrix,0,matrix[0].length-1,target)||binarySearch2(row3,matrix,0,matrix[0].length-1,target);
//     }
//     // yahan hamne binary search with certain modifications lagaya hai
//     public int binarySearch1(int matrix[][],int start,int end,int target)
//     {
//         // yeh condition tukke se nahi nikali hai, multiple test cases dry run karne ke baad pata chala tha
//         if(start>end)
//         return Math.min(start,matrix.length-1);// Math.min lagana padega, [[1]], target=2 ke liye check karna zara
//         int mid=(start+end)/2;
//         if(matrix[mid][0]==target) 
//         return mid;
//         else if(matrix[mid][0]>target)
//         return binarySearch1(matrix,start,mid-1,target);
//         else
//         return binarySearch1(matrix,mid+1,end,target);
//     }
//     // yaha pe standard binary search lagaya hai
//     public boolean binarySearch2(int row,int matrix[][],int start,int end,int target)
//     {
//         int mid=0;
//         if(start<=end)
//         {
//             mid=(start+end)/2;
//             if(matrix[row][mid]==target)
//             return true;
//             else if(matrix[row][mid]>target)
//             return binarySearch2(row,matrix,start,mid-1,target);
//             else
//             return binarySearch2(row,matrix,mid+1,end,target);
//         }
//         return false;
//     }
// }

// a better approach by Aryan Mittal using x coordinate=val/m and y coordinate=val%m;
//https://www.youtube.com/watch?v=D6U_daz4wGA
// achieved the expected TC that is O(log(m*n))

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start=0,end=matrix.length*matrix[0].length-1;
        int mid=0;
        int m=matrix[0].length;
        while(start<=end)
        {
            mid=(start+end)/2;
            if(matrix[mid/m][mid%m]==target)
            return true;
            else if(matrix[mid/m][mid%m]>target)
            end=mid-1;
            else
            start=mid+1;
        }
        return false;
    }
} 