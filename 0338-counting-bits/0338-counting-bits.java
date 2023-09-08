class Solution {
    public int[] countBits(int n) {
        if(n==0)
        {
            int a[]=new int[1];
            return a;
        }
        int a[]=new int[n+1];
        for(int i=1;i<n+1;i++)
        {
            int y=i/2;
            if(i%2==0)
            {
                a[i]=a[y];
            }
            else
            {
                a[i]=a[y]+1;
            }
        }
        return a;
    }
}