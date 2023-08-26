class sorting implements Comparator<int[]>{
    public int compare(int a[],int b[])
    {
       return a[1]-b[1]; 
       
       // this one line beautifully handles all the edge cases like
       // (1,4) , (4,4) , (2,3)
       // (4,4) , (1,4) , (2,3)
       // (1,4) , (3,4) , (1,1)
       // (1,9) , (6,6)
       // (1,5) , (1,2) , ...
       // (1,3) , (4,5) , ...
       // yahan pe a[0] , b[0] se deal nahi karna pada
       // seedha funda yeh hai ki agar (a,b) and (c,d) mein if b>d hai toh b>c apne aap ho ja ra, toh if b>d hai toh (c,d),(a,b) kardo simply order ko and agar b<d hai toh ho sakta hai b>c ho, ya ho sakta hai ki b<c ho , ab b>c wale case mein bhi 3 cases hai ki a=c,a<c,a>c jaise

    // for b>d 
    // (1,5) , (2,3) , swap kardo 

    // for b<d edge case

            // b>c ==> 
            // further 3 edge cases

            // in 3 edge cases ko aese hi chhod do apne aap handle ho jayenge main function  
            // mein

            //    (1,2) , (1,5) a=c
            //    (2,2) , (1,5) a>c
            //    (1,3) , (2,5) a<c

            // b<c =>
            // (1,2) , (3,4) // aese hi chhod do

            // for b=c =>
            // (1,2) , (2,3) //aese hi chhod do

    // for b=d case , b>=c is possible, b<c isn't possible

    }
}
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,new sorting());
        for(int i=0;i<pairs.length;i++)
        {
            for(int j=0;j<pairs[0].length;j++)
            System.out.print(pairs[i][j]+" ");
            System.out.println();
        }
        int count=1;
        int prev=pairs[0][1];
        for(int i=1;i<pairs.length;i++)
        {
            if(pairs[i][0]>prev)
            {
                prev=pairs[i][1];
                count++;
            }
        }
        return count;
    }
}

