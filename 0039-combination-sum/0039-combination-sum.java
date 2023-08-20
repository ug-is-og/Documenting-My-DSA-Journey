class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp=new ArrayList<>();
        List<List<Integer>> finalAns=new ArrayList<>();
        helper(0,candidates,target,temp,finalAns);
        return finalAns;
    }
    public void helper(int index,int candidates[],int target,List<Integer> temp,List<List<Integer>> finalAns)
    {
        if(target==0)
        {
            List<Integer> newTemp=new ArrayList<>(temp);
            finalAns.add(newTemp);
            return;
        }
        if(index==candidates.length)
        return;
        if(target<candidates[index])
        {
            helper(index+1,candidates,target,temp,finalAns);
        }
        else
        {
            helper(index+1,candidates,target,temp,finalAns);
            temp.add(candidates[index]);
            helper(index,candidates,target-candidates[index],temp,finalAns);
            temp.remove(temp.size()-1);
        }
    }
}