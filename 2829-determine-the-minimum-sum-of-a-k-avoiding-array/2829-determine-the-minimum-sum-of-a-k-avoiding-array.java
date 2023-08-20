class Solution {
    public int minimumSum(int n, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int tempCount=2;
        map.put(k-1,1);
        int sum=1;
        while(map.size()<n)
        {
            if(!map.containsKey(tempCount))
            {
                map.put(k-tempCount,tempCount);
                sum=sum+tempCount;
            }
            tempCount++;
            
        }
        return sum;
    }
}