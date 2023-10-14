// since if, else dono blocks mein ek ek call hi laga rahe so yeh O(n) time and space mein ho ja ra 

class Solution {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<Integer> list=new ArrayList<>();
        List<Integer> indices=new ArrayList<>();
        helper(list,0,-1,groups,indices);
        List<String> ans=new ArrayList<>();
        for(int i=0;i<indices.size();i++)
        {
            ans.add(words[indices.get(i)]);
        }
        return ans;
    }
    public void helper(List<Integer> list,int index,int prevFound,int groups[],List<Integer> indices)
    {
        if(index==groups.length)
        {
            if(list.size()>indices.size())
            {
                indices.clear();
                for(int i=0;i<list.size();i++)
                {
                    indices.add(list.get(i));
                }
            }
            return;
        }
        if(groups[index]!=prevFound||prevFound==-1)
        {
            list.add(index);
            helper(list,index+1,groups[index],groups,indices);
            // list.remove(list.size()-1);
            // helper(list,index+1,prevFound,groups,indices);

            // the above call is not needed at all kyunki kewal 0,1 ki hi possibility hai iss question mein toh
        }
        else
        {
            helper(list,index+1,prevFound,groups,indices);
        }
    }
}