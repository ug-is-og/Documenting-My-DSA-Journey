// class Solution {
//     public int countGoodNumbers(long n) {
//         double ans=1.0;
//         if(n%2!=0)
//         {
//             ans=Math.pow(5,n/2+1)*Math.pow(4,n/2);
//         }
//         else
//         {
//             ans=Math.pow(5,n/2)*Math.pow(4,n/2);
//         }
//         return (int)ans;
//     }
// }

// upar wali approach mein galti yeh kar re ki hame yaar MOD ka prayog karna hai taaki int bounds mein reh sake but math.pow yeh sab dhyan nahi deta iss liye ans galat aa ra for large inputs, 

// so we need to create our own pow function keeping in mind the mod thing

class Solution {
    public int countGoodNumbers(long n) {
        double ans=1.0;
        long even=(n+1)/2;
        long odd=n/2;
        return (int)((pow(5,even)*pow(4,odd))%1000000007); // jab bhi aese type cast karo
        // toh int ke just baad jo bhi hai sab encapsulate karo bracket mein, don't think ki int apne aap karega yeh sab
    }
    public long pow(int x,long n)
    {
        if(n==0)
        return 1;
        long temp=pow(x,n/2);
        // either n is odd
        if(n%2!=0)
        return (x*temp*temp)%1000000007;
        return (temp*temp)%1000000007;
        // either n is even
    }
}