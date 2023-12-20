//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class meeting{
    int start,end,index;
    public meeting(int start,int end,int index)
    {
        this.start=start;
        this.end=end;
        this.index=index;
    }
}
class ordering implements Comparator<meeting>{
    public int compare(meeting a,meeting b)
    {
        return a.end-b.end;
    }
}
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        List<meeting> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            list.add(new meeting(start[i],end[i],i));
        }
        Collections.sort(list,new ordering());
        int count=1,prev=0;
        for(int i=1;i<list.size();i++)
        {
            if(list.get(i).start>list.get(prev).end)
            {
                count++;
                prev=i;
            }
        }
        return count;
    }
}
