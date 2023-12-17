// yeh wala code badhiya likha hai and standard approach bhi hai apr yaar bhot zaada optimized nahi hai, isko optimize karte for test cases like this

//[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]

//target=30

// class Solution {
//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//         List<List<Integer>> finalAns=new ArrayList<>();
//         List<Integer> temp=new ArrayList<>();
//         Arrays.sort(candidates); // this is one optimization, agar yeh kara toh Collections.sort() nahi lagana padega inside base condition of helper
//         helper(0,candidates,target,temp,finalAns);
//         return finalAns;
//     }
//     public void helper(int index,int candidates[],int target,List<Integer> temp,List<List<Integer>> finalAns)
//     {
//         if(target==0)
//         {
//             List<Integer> newTemp=new ArrayList<>(temp);
//             //Collections.sort(newTemp);
//             if(finalAns.isEmpty()||!finalAns.contains(newTemp))
//             finalAns.add(newTemp);
//             return;
//         }
//         if(index==candidates.length)
//         return;
//         if(target>=candidates[index])
//         {
//             helper(index+1,candidates,target,temp,finalAns);
//             temp.add(candidates[index]);
//             helper(index+1,candidates,target-candidates[index],temp,finalAns);
//             temp.remove(temp.size()-1);
//         }
//         else
//         {
//             helper(index+1,candidates,target,temp,finalAns);
//         }
//     }
// }

// insight for optimization, hame bol rakha hai ki ek combination mein ek array element ko ek hi baar le sakte hai
//https://youtu.be/G1fRTGRxXU8 (Striver's approach)

// class Solution {
//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//          List<List<Integer>> finalAns=new ArrayList<>();
//         List<Integer> temp=new ArrayList<>();
//         Arrays.sort(candidates); 
//         helper(0,candidates,finalAns,target,temp);
//         return finalAns;
//     }
//     public void helper(int index,int candidates[],List<List<Integer>> finalAns,int target,List<Integer> temp)
//     {
//         if(target==0)
//         {
//             finalAns.add(new ArrayList<>(temp));
//             return ;
//         }
//         if(target<0)
//         return;
//         for(int i=index;i<candidates.length;i++)
//         {
//             // iss condition se agar [1,1,1,2,2] hai and target=4 toh mein duplicate calls lagane se bach ja raha hun, matlab 1 liya aur ab seedha 2 pe chale gaye...kyun ...kyunki baaki ke 2 1's recursive calls mein cover ho jayenge and agar recursive calls mein cover ho chuke hai toh loop mein wapas kyun consider karoge..kyunki agar loop mein aake wapas add karoge toh duplicate calls ho jayengi..toh tum unnecesaarilty kyun maaroge duplicate call...upar wale code mein unnecessarily bhot saari calls lag ri...isme kewal useful calls mein ho ja ra karyakram, matlab upar wale code mein tumne take no take ka rona kar diya hai, yahan woh nahi karna padega
//             if(i>index&&candidates[i]==candidates[i-1])
//             continue;
//             if(candidates[i]>target)
//             break;
//             temp.add(candidates[i]);
//             helper(i+1,candidates,finalAns,target-candidates[i],temp);
//             temp.remove(temp.size()-1);
//         }
//     }
// }






















// meri approach bhi striver se milti jhulti hai par khud se likhi so great job

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        helper(ans,new ArrayList<>(),0,candidates,target);
        return ans;
    }
    public void helper(List<List<Integer>> ans,List<Integer> temp,int index,int candidates[],int remSum){
        if(remSum==0)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(index==candidates.length||remSum<candidates[index]||remSum<0)
        {
            return;
        }
        int i=0;
        for(i=index;i<candidates.length;i++)
        {
            if(candidates[i]==candidates[index])
            {
                continue;
            }
            else
            {
                break;
            }
        }
        helper(ans,temp,i,candidates,remSum);
        for(int k=index;k<i;k++)
        {
            temp.add(candidates[k]);
            helper(ans,temp,i,candidates,remSum-(k-index+1)*candidates[k]);
        }
        for(int k=index;k<i;k++)
        {
            temp.remove(temp.size()-1);
        }
    }
}

