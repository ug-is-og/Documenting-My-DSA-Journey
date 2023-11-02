//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class knapSack{
    int value;
    int weight;
    double valueToWeight;
    public knapSack(int value,int weight,double valueToWeight)
    {
        this.value=value;
        this.weight=weight;
        this.valueToWeight=valueToWeight;
    }
}
class ordering implements Comparator<knapSack>{
    public int compare(knapSack k1,knapSack k2){
        if(k2.valueToWeight>k1.valueToWeight)
        {
            return 1;
        }
        else if(k1.valueToWeight>k2.valueToWeight)
        {
            return -1;
        }
        else
        {
            return 0;
        }
        // return k2.valueToWeight-k1.valueToWeight;
    }
}
class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        List<knapSack> list=new ArrayList<>();
        double ans=0.0;
        for(int i=0;i<arr.length;i++)
        {
            list.add(new knapSack(arr[i].value,arr[i].weight,(arr[i].value*1.0)/arr[i].weight));
        }
        Collections.sort(list,new ordering());
        for(int i=0;i<n;i++)
        {
            if(W>=list.get(i).weight)
            {
                W=W-list.get(i).weight;
                ans=ans+list.get(i).value;
            }
            else
            {
                ans=ans+((list.get(i).value*1.0)/list.get(i).weight)*W;
                break;
            }
        }
        return ans;
    }
}