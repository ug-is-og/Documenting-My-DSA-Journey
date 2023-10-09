class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
       ab: for(int i=0;i<nums.length-2;i++)
        {
            int a=nums[i];
            while(i>0&&nums[i]==nums[i-1]) continue ab; // yahan pehle galti yeh kar re the ki nums[i]==nums[i+1] karke check kiye, usse nahi chalega kyunki tumse cases miss ho jayenge, dry run using [-4,-1,-1,0,1,4]
            int temp=0;
            List<Integer> list=null;
            int j=i+1,k=nums.length-1;
            while(j<k)
            {
                temp=nums[j]+nums[k];
                if(temp==(0-a))
                {
                    list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    while(j+1<nums.length&&nums[j]==nums[j+1]) // understand what I am trying to do here through TC: [0,0,0,0] 
                    // jab do element of triplet handle kar liye toh teesra wala apne aap hojayega kyunki ek specific sum laana tha last mein hame
                    j++;
                    j++; 
                }
                else if(temp>-a)
                {
                    k--;
                }
                else
                {
                    j++;
                }
            }
        }
        return ans;
    }
}