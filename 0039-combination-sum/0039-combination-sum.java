// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<Integer> temp=new ArrayList<>();
//         List<List<Integer>> finalAns=new ArrayList<>();
//         helper(0,candidates,target,temp,finalAns);
//         return finalAns;
//     }
//     public void helper(int index,int candidates[],int target,List<Integer> temp,List<List<Integer>> finalAns)
//     {
//         if(target==0)
//         {
//             List<Integer> newTemp=new ArrayList<>(temp);
//             finalAns.add(newTemp);
//             return;
//         }
//         if(index==candidates.length)
//         return;
//         if(target<candidates[index])
//         {
//             helper(index+1,candidates,target,temp,finalAns);
//         }
//         else
//         {
//             helper(index+1,candidates,target,temp,finalAns);
//             temp.add(candidates[index]);
//             helper(index,candidates,target-candidates[index],temp,finalAns);
//             temp.remove(temp.size()-1);
//         }
//     }
// }
















// upar wali approacha jaise hi kiya hai bs upar ham pehle hi check kar le re ki remSum, current element se bada hai ya chhota and accordingly calls laga re

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(0,ans,new ArrayList<>(),candidates,target);
        return ans;
    }
    public void helper(int index,List<List<Integer>> ans,List<Integer> temp,int candidates[],int remSum)
    {
        if(remSum==0)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(index==candidates.length||remSum<0)
        {
            return;
        }
        temp.add(candidates[index]);
        helper(index,ans,temp,candidates,remSum-candidates[index]);
        temp.remove(temp.size()-1);
        helper(index+1,ans,temp,candidates,remSum);
    }

}