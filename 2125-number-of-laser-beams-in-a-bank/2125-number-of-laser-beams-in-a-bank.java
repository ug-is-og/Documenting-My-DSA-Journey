class Solution {
    public int numberOfBeams(String[] bank) {
        int newCount=0,prevCount=0,beams=0;
        for(int i=0;i<bank.length;i++)
        {
            for(int j=0;j<bank[i].length();j++)
            {
                char c=bank[i].charAt(j);
                if(c=='1')
                {
                    newCount++;
                }
            }
            if(newCount!=0)
            {
                beams+=prevCount*newCount;
                prevCount=newCount;
                newCount=0;
            }
        }
        return beams;
    }
}