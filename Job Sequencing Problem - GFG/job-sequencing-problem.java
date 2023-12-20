//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends



class ordering implements Comparator<Job>{
    public int compare(Job a,Job b)
    {
        return b.profit-a.profit;
    }
}
class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr,new ordering());
        int maxDeadline=Integer.MIN_VALUE;
        int count=0,profit=0;
        for(Job a:arr)
        {
            maxDeadline=Math.max(maxDeadline,a.deadline);
        }
        int id[]=new int[maxDeadline+1];
        Arrays.fill(id,-1);
        for(int i=0;i<n;i++)
        {
            for(int j=arr[i].deadline;j>0;j--)
            {
                if(id[j]==-1)
                {
                    id[j]=arr[i].deadline;
                    profit+=arr[i].profit;
                    count++;
                    break;
                }
            }
        }
        int ans[]=new int[2];
        ans[0]=count;
        ans[1]=profit;
        return ans;
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/