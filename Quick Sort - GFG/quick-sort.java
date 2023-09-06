//{ Driver Code Starts
import java.util.*;
class Sorting
{
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    // Driver program
    public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

			
			new Solution().quickSort(arr,0,n-1);
			printArray(arr);
		    T--;
		}
} }
// } Driver Code Ends






class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        if(low>=high)
        return;
        int pivotIndex=partition(arr,low,high);

        quickSort(arr,low,pivotIndex-1);
        quickSort(arr,pivotIndex+1,high);
        // code here
    }
    static int partition(int arr[], int low, int high)
    {
        int pivot=arr[low];
        int k=0;
        for(int i=low+1;i<=high;i++)
        {
            if(pivot>=arr[i]) // yahan = lagaya hai taaki pivot ke equal wale left mein aa jaye aur fir neeche == check karenge
            k++;
        }
        int pivotIndex=low+k;
        int temp=arr[low];
        arr[low]=arr[low+k];
        arr[low+k]=temp;
        int i=low,j=high;
        while(i<pivotIndex&&j>pivotIndex)
        {
            
            while(i<pivotIndex&&arr[i]<=arr[pivotIndex]) // ek = miss karne se poora code kharab ho sakta hai ,, do it patiently...arr[i]<=arr[pivotIndex] yahan = lagaya kyunki upar = lagaya tha
            i++;
            while(j>pivotIndex&&arr[j]>arr[pivotIndex])
            j--;
            if(i<pivotIndex&&j>pivotIndex)
            {
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
        }
        return pivotIndex;
        // your code here
    } 
}