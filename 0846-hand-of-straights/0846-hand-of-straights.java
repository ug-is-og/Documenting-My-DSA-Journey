// biggest blunder that you made in this question, word consecutive likha hai, greater nahi iss liye [8,10,12] size=3 ke liye false aana chahiye true nahi

class data{
    int ele;
    int freq;
    public data(int ele,int freq)
    {
        this.ele=ele;
        this.freq=freq;
    }
}
class ordering implements Comparator<data>{
    public int compare(data d1,data d2)
    {
        return d1.ele-d2.ele;
    }
}
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<data> pq=new PriorityQueue<>(new ordering());
        HashMap<Integer,Integer> map=new HashMap<>();
        List<data> list=new ArrayList<>();
        for(int a:hand)
        {
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            pq.add(new data(entry.getKey(),entry.getValue()));
        }
        while(!pq.isEmpty())
        {
            int i=1;
            int prev=0;
            for(i=1;i<=groupSize&&!pq.isEmpty();i++)
            {
                if(i>1&&prev+1!=pq.peek().ele)
                return false;
                data temp=pq.remove();
                prev=temp.ele;
                if(temp.freq>1)
                list.add(new data(temp.ele,temp.freq-1));
            }
            if(pq.isEmpty()&&i<=groupSize)
            return false;
            int size=list.size();
            for(i=0;i<size;i++)
            {
                pq.add(list.remove(list.size()-1));
            }
        }
        return true;
    }
}