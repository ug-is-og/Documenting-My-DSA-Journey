//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

class train{
    int arrival;
    int departure;
    public train(int arrival,int departure)
    {
        this.arrival=arrival;
        this.departure=departure;
    }
}
class ordering implements Comparator<train>{
    public int compare(train a,train b)
    {
        return a.arrival-b.arrival;
    }
}
class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        List<train> list=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++)
        {
            list.add(new train(arr[i],dep[i]));
        }
        Collections.sort(list,new ordering());
        int platforms=1;
        pq.add(list.get(0).departure);
        for(int i=1;i<list.size();i++)
        {
            int temp=pq.peek();
            if(list.get(i).arrival-temp<=0)
            {
                platforms++;
            }
            else
            {
                pq.remove();
            }
            pq.add(list.get(i).departure);
        }
        return platforms;
    }
    
}

