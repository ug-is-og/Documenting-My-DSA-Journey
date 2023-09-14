class ordering implements Comparator<Pair<Integer,Integer>>{
    public int compare(Pair<Integer,Integer> p1,Pair<Integer,Integer> p2)
    {
        if(p1.getKey()<p2.getKey())
        {
            return -1;
        }
        else if(p1.getKey()>p2.getKey())
        {
            return 1;
        }
        else
        {
            return p1.getValue()-p2.getValue();
        }
    }
}
class Solution {
    public int getKth(int lo, int hi, int k) {
        List<Pair<Integer,Integer>> list=new ArrayList<>();
        for(int i=lo;i<=hi;i++)
        {
            list.add(new Pair(helper(i),i));
        }
        Collections.sort(list,new ordering());
        return list.get(k-1).getValue();
    }
    public int helper(int target)
    {
        if(target==1)
        {
            return 0;
        }
        int steps=0;
        if(target%2==0)
        steps=1+helper(target/2);
        else
        steps=1+helper(3*target+1);
        return steps;
    }
}