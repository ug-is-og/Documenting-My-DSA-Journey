// an approach using O(3n) space and O(200*n+nlogn) TC

class stringData{
    String original;
    String sorted;
    public stringData(String sorted,String original)
    {
        this.sorted=sorted;
        this.original=original;
    }
}
class ordering implements Comparator<stringData>{
    public int compare(stringData a,stringData b)
    {
        return (a.sorted).compareTo(b.sorted);
    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<stringData> temp=new ArrayList<>();
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<strs.length;i++)
        {
            char c[]=strs[i].toCharArray();
            Arrays.sort(c); // max to max O(200) TC 
            String sortedString=new String(c);
            temp.add(new stringData(sortedString,strs[i]));
        }
        Collections.sort(temp,new ordering());
        List<String> tempAns=new ArrayList<>();
        tempAns.add(temp.get(0).original);
        for(int i=1;i<temp.size();i++)
        {
            if((temp.get(i).sorted).equals(temp.get(i-1).sorted))
            {
                tempAns.add(temp.get(i).original);
            }
            else
            {
                ans.add(tempAns);
                tempAns=new ArrayList<>();
                tempAns.add(temp.get(i).original);
            }
        }
        ans.add(tempAns);
        return ans;
    }

}