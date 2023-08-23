// Brute force approach

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        helper(k,n,temp,ans);
        return ans;
    }
    public void helper(int k,int remSum,List<Integer> temp,List<List<Integer>> ans)
    {
        if(k==0&&remSum!=0)
        return;
        if(remSum==0)
        {
          ArrayList<Integer> newTemp=null;
          if(k==0)
          {
            newTemp=new ArrayList<>(temp);
            Collections.sort(newTemp);
            if(!ans.contains(newTemp))
            ans.add(newTemp);
          }
          return;
        }
        for(int i=1;i<=9;i++)
        {
            if(remSum>=i&&!temp.contains(i))
            {
                temp.add(i);
                helper(k-1,remSum-i,temp,ans);
                temp.remove(temp.size()-1);
            }
        }
    }
}