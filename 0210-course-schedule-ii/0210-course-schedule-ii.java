class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         int indegree[]=new int[numCourses];
        // build the adjacency list
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i=0;i<list.size();i++)
        {
            for(int j=0;j<list.get(i).size();j++)
            {
                indegree[list.get(i).get(j)]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
        while(!q.isEmpty())
        {
            int temp=q.remove();
            ans.add(temp);
            for(int i=0;i<list.get(temp).size();i++)
            {
                indegree[list.get(temp).get(i)]--;
                if(indegree[list.get(temp).get(i)]==0)
                {
                    q.add(list.get(temp).get(i));
                }
            }
        }
        int ansArray[];
        if(ans.size()<numCourses)
        {
            ansArray=new int[0]; // this is how you make an empty array
            return ansArray;
        }
        ansArray=new int[numCourses];
        for(int i=0;i<ans.size();i++)
        {
            ansArray[i]=ans.get(i);
        }
        return ansArray;
    }
}