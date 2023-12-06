class Solution {
    public double myPow(double x, int n) {
        double ans=0;
        if(n>0)
        {
            ans=helper(x,n);
        }
        else
        {
            ans=helper(x,n*-1);
            ans=1/ans;
        }
        return ans;
    }
    public double helper(double x,int n)
    {
        if(n==0)
        {
            return 1;
        }
        double ans=0;
        if(n%2==0)
        {
            // ans=helper(x,n/2)*helper(x,n/2);
            ans=Math.pow(helper(x,n/2),2);
        }
        else
        {
            // ans=helper(x,n/2)*helper(x,n/2)*x;
            ans=Math.pow(helper(x,n/2),2)*x;
        }
        return ans;
    }
}