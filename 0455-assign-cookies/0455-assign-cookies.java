class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int temp=0,count=0;
        for(int i=0;i<s.length;i++)
        {
            if(temp<g.length&&s[i]>=g[temp])
            {
                count++;
                temp++;
            }
        }
        return count;
    }
}