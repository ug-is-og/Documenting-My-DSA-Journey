// Brute force approach

// class Solution {
//     public List<List<Integer>> combinationSum3(int k, int n) {
//         List<List<Integer>> ans=new ArrayList<>();
//         List<Integer> temp=new ArrayList<>();
//         helper(k,n,temp,ans);
//         return ans;
//     }
//     public void helper(int k,int remSum,List<Integer> temp,List<List<Integer>> ans)
//     {
//         if(k==0&&remSum!=0)
//         return;
//         if(remSum==0)
//         {
//           ArrayList<Integer> newTemp=null;
//           if(k==0)
//           {
//             newTemp=new ArrayList<>(temp);
//             Collections.sort(newTemp);
//             if(!ans.contains(newTemp))
//             ans.add(newTemp);
//           }
//           return;
//         }
//         for(int i=1;i<=9;i++)
//         {
//             if(remSum>=i&&!temp.contains(i))
//             {
//                 temp.add(i);
//                 helper(k-1,remSum-i,temp,ans);
//                 temp.remove(temp.size()-1);
//             }
//         }
//     }
// }


// Better Approach
// but is this the optimal approach, think about it

// class Solution {
//     public List<List<Integer>> combinationSum3(int k, int n) {
//         List<List<Integer>> ans=new ArrayList<>();
//         List<Integer> temp=new ArrayList<>();
//         helper(1,k,n,temp,ans);
//         return ans;
//     }
//     public void helper(int index,int k,int remSum,List<Integer> temp,List<List<Integer>> ans)
//     {
//         if(k==0&&remSum!=0)
//         return;
//         if(remSum==0)
//         {
//           ArrayList<Integer> newTemp=null;
//           if(k==0)
//           {
//             newTemp=new ArrayList<>(temp);
//             Collections.sort(newTemp);
//             if(!ans.contains(newTemp))
//             ans.add(newTemp);
//           }
//           return;
//         }
//         if(index>9) // isko upar likhoge toh 12th test case nahi chalega
//         return;
//         // no take
//         helper(index+1,k,remSum,temp,ans);
//         // take
//         temp.add(index);
//         helper(index+1,k-1,remSum-index,temp,ans);
//         temp.remove(temp.size()-1);
//     }
// }

// for optimal approach, ab jo bhi optimizations honi hai woh above code mein hi hongi
// this is all

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        helper(1,k,n,temp,ans);
        return ans;
    }
    public void helper(int index,int k,int remSum,List<Integer> temp,List<List<Integer>> ans)
    {
        if(index>9)
        {
          if(k==0&&remSum==0)
          ans.add(new ArrayList<>(temp));
          return;
        }
        // no take
        helper(index+1,k,remSum,temp,ans);
        // take
        temp.add(index);
        helper(index+1,k-1,remSum-index,temp,ans);
        temp.remove(temp.size()-1);
    }
}
