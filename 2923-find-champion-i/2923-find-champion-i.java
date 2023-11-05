class Solution {
    public int findChampion(int[][] grid) {
        List<Integer> strong=new ArrayList<>();
        List<Integer> weak=new ArrayList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    strong.add(i);
                    weak.add(j);
                }
            }
        }
        int ans=0;
        for(int i=0;i<strong.size();i++)
        {
            if(!weak.contains(strong.get(i)))
            {
                ans=strong.get(i);
                break;
            }
        }
        return ans;
    }
}