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

// class Solution {
//     public List<List<Integer>> combinationSum3(int k, int n) {
//         List<List<Integer>> ans=new ArrayList<>();
//         List<Integer> temp=new ArrayList<>();
//         helper(1,k,n,temp,ans);
//         return ans;
//     }
//     public void helper(int index,int k,int remSum,List<Integer> temp,List<List<Integer>> ans)
//     {
//         if(index>9)
//         {
//           if(k==0&&remSum==0)
//           ans.add(new ArrayList<>(temp));
//           return;
//         }
//         // no take
//         helper(index+1,k,remSum,temp,ans);
//         // take
//         temp.add(index);
//         helper(index+1,k-1,remSum-index,temp,ans);
//         temp.remove(temp.size()-1);
//     }
// }











// most optimal code, beats 100%

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int arr[]={1,2,3,4,5,6,7,8,9};
        List<List<Integer>> ans=new ArrayList<>();
        helper(ans,new ArrayList<>(),arr,k,n,0);
        return ans;
    }
    public void helper(List<List<Integer>> ans,List<Integer> temp,int arr[],int k,int n,int index)
    {
        if(n==0)
        {
            if(temp.size()==k)
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(index==arr.length||n<arr[index])
        {
            return;
        }
        helper(ans,temp,arr,k,n,index+1);
        if(temp.size()<k)
        {
            temp.add(arr[index]);
            helper(ans,temp,arr,k,n-arr[index],index+1);
            temp.remove(temp.size()-1);
        }
    }
}
