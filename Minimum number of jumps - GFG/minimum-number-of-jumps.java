//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends


class Solution{
    static int minJumps(int[] arr){
        int ans=0,jmp=0;
        for(int i=0;i<arr.length;i++)
        {
            int max=Integer.MIN_VALUE;
            int newPos=Integer.MIN_VALUE;
            jmp++;
            int pos=i;
            int jmpValue=arr[i];
            if(arr[i]==0)
            return -1;
            if(jmpValue+pos>=arr.length-1)
            {
                ans=jmp;
                break;
            }
            for(int j=pos+1;j<=pos+jmpValue;j++)
            {
                if(max<arr[j]+j)
                {
                    max=arr[j]+j;
                    newPos=j;
                }
            }
            i=newPos-1;
        }
        return ans;
    }
}