//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.maxCombinations(n, k, a, b);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class sumAndPos{
    int sum;
    int pos;
    public sumAndPos(int sum,int pos){
        this.sum=sum;
        this.pos=pos;
    }
}
class ordering implements Comparator<sumAndPos>{
    public int compare(sumAndPos a,sumAndPos b)
    {
        return b.sum-a.sum;
    }
}
class Solution {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        PriorityQueue<sumAndPos> pq=new PriorityQueue<>(new ordering());
        List<Integer> list=new ArrayList<>();
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0;i<N;i++)
        {
            pq.add(new sumAndPos(A[N-1]+B[i],N-1));
        }
        int count=0;
        while(count<K&&!pq.isEmpty())
        {
            sumAndPos temp=pq.remove();
            int sum=temp.sum;
            int pos=temp.pos;
            list.add(sum);
            if(pos-1>=0)
            pq.add(new sumAndPos(sum-A[pos]+A[pos-1],pos-1));
            count++;
        }
        return list;
    }
}
