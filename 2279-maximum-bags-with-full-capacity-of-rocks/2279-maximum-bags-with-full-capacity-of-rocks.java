class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int diffArray[]=new int[capacity.length];
        for(int i=0;i<capacity.length;i++)
        {
            diffArray[i]=capacity[i]-rocks[i];
        }
        Arrays.sort(diffArray);
        int i=0;
        while(i<rocks.length&&additionalRocks>=diffArray[i])
        {
            additionalRocks-=diffArray[i];
            i++;
        }
        return i;
    }
}