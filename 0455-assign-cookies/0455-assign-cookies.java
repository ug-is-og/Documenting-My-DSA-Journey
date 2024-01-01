// class Solution {
//     public int findContentChildren(int[] g, int[] s) {
//         Arrays.sort(g);
//         Arrays.sort(s);
//         int temp=0,count=0;
//         for(int i=0;i<s.length;i++)
//         {
//             if(temp<g.length&&s[i]>=g[temp])
//             {
//                 count++;
//                 temp++;
//             }
//         }
//         return count;
//     }
// }




















class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0,count=0;
        while(i<g.length&&j<s.length)
        {
            if(s[j]>=g[i])
            {
                i++;
                j++;
                count++;
            }
            else
            {
                j++;
            }
        }
        return count;
    }
}