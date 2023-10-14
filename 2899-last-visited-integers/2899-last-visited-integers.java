class Solution {
    public List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> ans=new ArrayList<>();
        List<String> visited=new ArrayList<>();
        int k=1;
        for(int i=0;i<words.size();i++)
        {
            if(!words.get(i).equals("prev"))
            {
                visited.add(words.get(i));
            }
            else
            {
                if(i>0&&words.get(i).equals(words.get(i-1)))
                {
                    k++;
                }
                else
                {
                    k=1;
                }
                if(k>visited.size())
                {
                    ans.add(-1);
                }
                else
                {
                    ans.add(Integer.valueOf(visited.get(visited.size()-k)));
                }
            }
        }
        return ans;
    }
}