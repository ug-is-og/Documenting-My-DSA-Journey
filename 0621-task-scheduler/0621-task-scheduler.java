class data{
    char task;
    int freq;
    public data(char task,int freq)
    {
        this.task=task;
        this.freq=freq;
    }
}
class ordering implements Comparator<data>{
    public int compare(data d1,data d2){
        if(d1.freq==d2.freq)
        {
            return d1.task-d2.task;
        }
        return d2.freq-d1.freq;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<data> pq=new PriorityQueue<>(new ordering());
        HashMap<Character,Integer> map=new HashMap<>();
        ArrayList<data> list=new ArrayList<>();
        int count=0;
        for(int i=0;i<tasks.length;i++)
        {
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet())
        {
            pq.add(new data(entry.getKey(),entry.getValue()));
        }
        while(!pq.isEmpty())
        {
            int i=1,countFreq=0;
            for(i=1;i<=n+1&&!pq.isEmpty();i++)
            {
                data temp=pq.remove();
                list.add(new data(temp.task,temp.freq-1));
                if(temp.freq==1)
                countFreq++;
            }
            if(countFreq!=i-1)
            count=count+(n+1);
            else
            {
                count=count+countFreq;
            }
            int size=list.size();
            for(i=0;i<size;i++)
            {
                data temp=list.remove(list.size()-1);
                if(temp.freq!=0)
                pq.add(temp);
            }
        }
        return count;
    }
}