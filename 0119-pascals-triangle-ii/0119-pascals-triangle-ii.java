class Solution {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex==0)
        {
            List<Integer> list=new ArrayList<>();
            list.add(1);
            return list;
        }
        List<Integer> list=getRow(rowIndex-1);
        List<Integer> ans=new ArrayList<>();
        ans.add(1);
        ans.add(1);
        if(list.size()>1)
        {
            for(int i=0;i<list.size()-1;i++)
            {
                ans.add(1,list.get(i)+list.get(i+1));
            }
        }
        return ans;
    }
}