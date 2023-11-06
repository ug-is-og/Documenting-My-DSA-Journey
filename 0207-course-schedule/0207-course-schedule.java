class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // if there's a cycle you can never finsih the courses
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
        if(ans.size()<numCourses)
        {
            return false;
        }
        return true;
    }
}