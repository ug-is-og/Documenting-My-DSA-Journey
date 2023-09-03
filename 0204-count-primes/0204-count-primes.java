// Sieve of Eratosthenes

// class Solution {
//     public int countPrimes(int n) {
//         int a[]=new int[n];
//         for(int i=2;i<n;i++)
//         a[i]=1;
//         for(int i=2;i<n;i++)
//         {
//             if(a[i]==1)
//             {
//                     for(int j=2*i;j<n;j+=i)
//                 {
//                     a[j]=0;
//                 }
//             }
//         }
//         int count=0;
//         for(int b:a)
//         {
//             if(b==1)
//             count++;
//         }
//         return count;
//     }
// }

// slight Optimization

class Solution {
    public int countPrimes(int n) {
        int a[]=new int[n];
        int count=0;
        for(int i=2;i<n;i++)
        a[i]=1;
        for(int i=2;i<n;i++)
        {
            if(a[i]==1)
            {
                count++; // ek yeh optimization kari taaki 2 baar loop na chalana pade
                if(((long)i*i)<n) // agar yeh nahi kiya toh i*i int ki range ke bahar ja sakta, negative h jayega toh <n toh ho hi gaya par jab uss array index ko access karoge toh error aayega due negative array index
                    for(int j=i*i;j<n;j+=i)
                {
                    a[j]=0;
                }
            }
        }
        return count;
    }
}
